package azki.com.yektaee.service.user;

import azki.com.yektaee.model.UserModel;

import java.util.List;
import java.util.Set;

public interface UserService {

    Set<UserModel> getUserSetByIds(List<Long> id);
}
