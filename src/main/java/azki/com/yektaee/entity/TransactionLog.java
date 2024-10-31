package azki.com.yektaee.entity;


import azki.com.yektaee.enums.FinancialType;
import azki.com.yektaee.enums.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "transaction_log")
public class TransactionLog extends BaseEntity{

    @NotBlank
    @Column(name = "account_number", length = 18, nullable = false)
    private String accountNumber;


    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false)
    private TransactionType transactionType;

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name = "financial_type", nullable = false)
    private FinancialType financialType;



}
