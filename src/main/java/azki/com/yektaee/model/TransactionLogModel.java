package azki.com.yektaee.model;


        import azki.com.yektaee.enums.FinancialType;
        import azki.com.yektaee.enums.TransactionType;
        import lombok.Getter;
        import lombok.Setter;

@Getter
@Setter
public class TransactionLogModel extends BaseModel{

    private String accountNumber;

    private TransactionType transactionType;

    private Double amount;

    private FinancialType financialType;

}
