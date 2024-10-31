package azki.com.yektaee.service.transaction;

import azki.com.yektaee.entity.Transaction;
import azki.com.yektaee.enums.FinancialType;
import azki.com.yektaee.enums.TransactionType;
import azki.com.yektaee.mapper.TransactionLogMapper;
import azki.com.yektaee.mapper.TransactionMapper;
import azki.com.yektaee.model.AccountModel;
import azki.com.yektaee.model.TransactionLogModel;
import azki.com.yektaee.model.TransactionModel;
import azki.com.yektaee.repository.TransactionRepository;
import azki.com.yektaee.service.account.AccountService;
import azki.com.yektaee.service.observer.obserer.TransactionLogObserver;
import azki.com.yektaee.service.transactionlog.TransactionLogService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final AccountService accountService;

    private final TransactionMapper transactionMapper;

    private final TransactionRepository transactionRepository;

    private final TransactionLogObserver logObserver;

    private final TransactionLogMapper transactionLogMapper;

    private final TransactionLogService transactionLogService;


    @PostConstruct
    void init() {
        TransactionModel model = new TransactionModel();
        model.setTransactionType(TransactionType.DEPOSIT);
        model.setAmount(2000.0);
        model.setSourceAccountNumber(1L);
        transaction(model);

    }

    @Override
    public void transaction(TransactionModel model) {

        switch (model.getTransactionType()) {
            case DEPOSIT -> {
                TransactionLogModel logModel = transactionLogMapper.toTransactionLogModel(deposit(model));
                logObserver.update(logModel);
            }
            case WITHDRAW -> {
                TransactionLogModel logModel = transactionLogMapper.toTransactionLogModel(withdraw(model));
                logObserver.update(logModel);
            }
            case TRANSFER -> transfer(model).forEach(completeTransaction -> {
                TransactionLogModel logModel = transactionLogMapper.toTransactionLogModel(completeTransaction);
                logObserver.update(logModel);
            });
        }

    }

    private Transaction deposit(TransactionModel model) {
        AccountModel account = accountService.getByAccountNumber(model.getSourceAccountNumber());
        Double amount = model.getAmount();
        AccountModel accountModel = accountService.updateAccountBalance(account, BigDecimal.valueOf(amount));
        Transaction transaction = transactionMapper.toTransaction(model, accountModel, FinancialType.DEPOSIT);
        return transactionRepository.save(transaction);
    }


    private Transaction withdraw(TransactionModel model) {
        AccountModel account = accountService.getByAccountNumber(model.getSourceAccountNumber());
        Double amount = model.getAmount();
        validateTransactionPossibility(account.getTotalBalance(), model.getAmount());
        AccountModel accountModel = accountService.updateAccountBalance(account, BigDecimal.valueOf(amount).negate());
        Transaction transaction = transactionMapper.toTransaction(model, accountModel, FinancialType.WITHDRAW);
        return transactionRepository.save(transaction);
    }

    private List<Transaction> transfer(TransactionModel model) {
        AccountModel sourceAccount = accountService.getByAccountNumber(model.getSourceAccountNumber());
        AccountModel destinationAccount = accountService.getByAccountNumber(model.getDestinationAccountNumber());
        validateTransactionPossibility(sourceAccount.getTotalBalance(), model.getAmount());
        sourceAccount = accountService.updateAccountBalance(sourceAccount, BigDecimal.valueOf(model.getAmount()).negate());
        destinationAccount = accountService.updateAccountBalance(destinationAccount, BigDecimal.valueOf(model.getAmount()));
        Transaction withdrawTransaction = transactionMapper.toTransaction(model, sourceAccount, FinancialType.WITHDRAW);
        Transaction depositTransaction = transactionMapper.toTransaction(model, destinationAccount, FinancialType.DEPOSIT);
        return transactionRepository.saveAll(List.of(withdrawTransaction, depositTransaction));
    }

    private void validateTransactionPossibility(Double totalBalance, Double amount) {
        if (totalBalance < amount) {
            new RuntimeException();
        }
    }

}
