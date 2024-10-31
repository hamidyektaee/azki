package azki.com.yektaee.dto;

import azki.com.yektaee.embed.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String nationalCode;

    private String phoneNumber;

    private Address address;
}
