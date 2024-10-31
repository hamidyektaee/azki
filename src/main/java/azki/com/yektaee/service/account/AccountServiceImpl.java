package azki.com.yektaee.service.account;

import azki.com.yektaee.entity.Account;
import azki.com.yektaee.mapper.AccountMapper;
import azki.com.yektaee.model.AccountModel;
import azki.com.yektaee.model.UserModel;
import azki.com.yektaee.repository.AccountRepository;
import azki.com.yektaee.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    private final UserService userService;


//    @PostConstruct
//    void init() {
//        AccountModel accountModel = new AccountModel();
//        UserModel userModel = new UserModel();
//        userModel.setId(1L);
//        accountModel.setAccountNumber(1L);
//        HashSet<UserModel> set = new HashSet<>();
//        set.add(userModel);
//        accountModel.setUserSet(set);
//        accountModel.setTotalBalance(0.0);
//        save(accountModel);
//
//    }

    @Override
    public AccountModel save(AccountModel accountModel) {
        prepareUserInfoDetail(accountModel.getUsers());
        Account account = accountMapper.toAccount(accountModel);
        account = accountRepository.save(account);
        return accountMapper.toAccountModel(account);
    }

    @Override
    public AccountModel getById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return accountMapper.toAccountModel(account);
    }

    @Override
    @Transactional
    public AccountModel getByAccountNumber(Long accountNumber) {
        Account account = getAccount(accountNumber);
        return accountMapper.toAccountModel(account);
    }


    @Override
    @Transactional
    public AccountModel updateAccountBalance(AccountModel accountModel, BigDecimal amount) {
        Account account = getAccount(accountModel.getAccountNumber());
        BigDecimal totalBalance = account.getTotalBalance();
        totalBalance = totalBalance.add(amount);
        account.setTotalBalance(totalBalance);
        accountModel = accountMapper.toAccountModel(account);
        return accountModel;
    }


    @Override
    public void deActive(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException());
        accountRepository.delete(account);
    }

    private Account getAccount(Long accountNumber) {
        return accountRepository.findAccountByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException());
    }

    private void prepareUserInfoDetail(Set<UserModel> userModelSet) {
        List<Long> ids = userModelSet.stream().map(UserModel::getId).collect(Collectors.toList());
        Set<UserModel> users = userService.getUserSetByIds(ids);
        if (users.isEmpty() || (!Objects.equals(userModelSet.size(), users.size()))) {
            throw new RuntimeException();
        }
        userModelSet.clear();
        userModelSet.addAll(users);
    }

}
