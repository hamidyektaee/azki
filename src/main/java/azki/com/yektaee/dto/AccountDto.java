package azki.com.yektaee.dto;

import azki.com.yektaee.dto.transaction.SingleAccountTransactionDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class AccountDto {

    private Long accountNumber;

    private Set<UserDto> userSet;

    private Set<SingleAccountTransactionDto> transactionSet;

    private Double totalBalance;
}
