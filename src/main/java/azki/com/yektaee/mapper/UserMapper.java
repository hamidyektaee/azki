package azki.com.yektaee.mapper;

import azki.com.yektaee.dto.UserDto;
import azki.com.yektaee.entity.User;
import azki.com.yektaee.model.UserModel;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserModel toUserModel(UserDto userDto);

    Set<UserModel> toUserModelSet(Set<User> userSet);

    User toUser(UserModel model);

}
