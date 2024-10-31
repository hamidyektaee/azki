package azki.com.yektaee.dto.transaction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferTransactionDto extends SingleAccountTransactionDto {

    private Long destinationAccountNumber;
}
