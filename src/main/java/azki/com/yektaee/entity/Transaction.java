package azki.com.yektaee.entity;

import azki.com.yektaee.enums.FinancialType;
import azki.com.yektaee.enums.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "transaction")
public class Transaction extends BaseEntity {

    @Column(name = "transaction_type", nullable = false)
    private TransactionType transactionType;

    @NotNull
    @Column(nullable = false)
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name = "financial_type", nullable = false)
    private FinancialType financialType;

}
