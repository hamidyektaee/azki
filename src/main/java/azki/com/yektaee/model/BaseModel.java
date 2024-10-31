package azki.com.yektaee.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseModel {

    protected Long id;

    protected Integer version;

    protected LocalDateTime creationTime;

    protected LocalDateTime lastModifyTime;
}
