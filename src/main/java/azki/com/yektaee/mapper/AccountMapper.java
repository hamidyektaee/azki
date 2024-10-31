package azki.com.yektaee.mapper;

import azki.com.yektaee.dto.AccountDto;
import azki.com.yektaee.entity.Account;
import azki.com.yektaee.model.AccountModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface AccountMapper {

    AccountModel toAccountModel(Account account);

    AccountModel toAccountModel(AccountDto accountDto);

    Account toAccount(AccountModel accountModel);

    AccountDto toAccountDto(AccountModel accountModel);
}
