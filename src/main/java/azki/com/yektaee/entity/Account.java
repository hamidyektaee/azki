package azki.com.yektaee.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "account")
public class Account extends BaseEntity {

    @Column(name = "account_number", length = 18, nullable = false, unique = true)
    private Long accountNumber;


    @ManyToMany
    @JoinTable(
            name = "account_user",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users;

    @OneToMany
    private Set<Transaction> transactionSet = new HashSet<>();


    @NotNull
    @Column(name = "total_balance", nullable = false)
    private BigDecimal totalBalance;


}
