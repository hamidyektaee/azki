package azki.com.yektaee.service.user;


import azki.com.yektaee.entity.User;
import azki.com.yektaee.mapper.UserMapper;
import azki.com.yektaee.model.UserModel;
import azki.com.yektaee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public Set<UserModel> getUserSetByIds(List<Long> idList) {
        Set<User> userSet = userRepository.findByIdIn(idList);
        return userMapper.toUserModelSet(userSet);
    }

}
