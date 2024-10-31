package azki.com.yektaee.model;


import azki.com.yektaee.embed.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel extends BaseModel {

    private String firstName;

    private String lastName;

    private String nationalCode;

    private String phoneNumber;

    private Address address;


}
