package azki.com.yektaee.dto.transaction;


import azki.com.yektaee.enums.TransactionType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SingleAccountTransactionDto {

    private TransactionType transactionType;

    private Double amount;

    private Long sourceAccountNumber;

}
