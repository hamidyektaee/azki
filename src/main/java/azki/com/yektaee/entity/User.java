package azki.com.yektaee.entity;

import azki.com.yektaee.embed.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "bank_user")
public class User extends BaseEntity {

    @NotBlank
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Pattern(regexp = "[0-9]{10}")
    @NotBlank
    @Column(name = "national_code", length = 10, nullable = false)
    private String nationalCode;

    @Pattern(regexp = "^09[0-9]{9}")
    @NotBlank
    @Column(name = "phone_number", length = 11, nullable = false)
    private String phoneNumber;

    @NotNull
    @Embedded
    @Column(nullable = false)
    private Address address;

    @ManyToMany
    Set<Account> accounts;


}
