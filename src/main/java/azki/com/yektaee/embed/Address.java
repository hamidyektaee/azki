package azki.com.yektaee.embed;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Address {

    @NotBlank
    private String state;

    @NotBlank
    private String city;

    @NotBlank
    private String mainStreet;

    private String sideStreet;

    private String alley;

    @NotBlank
    private Integer unit;

    @NotBlank
    @Pattern(regexp = "[0-9]{10}")
    private String postalCode;

}
