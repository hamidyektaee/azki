package azki.com.yektaee.service.account;

import azki.com.yektaee.entity.Account;
import azki.com.yektaee.model.AccountModel;

import java.math.BigDecimal;

public interface AccountService {

    AccountModel save(AccountModel accountModel);

    AccountModel getById(Long id);

    AccountModel getByAccountNumber(Long accountNumber);

    AccountModel updateAccountBalance(AccountModel accountModel , BigDecimal amount);

    void deActive(Long id);

}
