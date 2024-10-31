package azki.com.yektaee.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class AccountModel extends BaseModel{

    private Long accountNumber;

    private Set<UserModel> users;

    private Double totalBalance;

}
