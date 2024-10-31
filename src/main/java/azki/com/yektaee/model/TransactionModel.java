package azki.com.yektaee.model;


import azki.com.yektaee.enums.TransactionType;
import azki.com.yektaee.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TransactionModel extends BaseModel {

    private TransactionType transactionType;

    private Double amount;

    private Long sourceAccountNumber;

    private Long destinationAccountNumber;

    private LocalDateTime transactionTime;

}
