package FoodPair.foodpair.service;

import FoodPair.foodpair.domain.User;
import FoodPair.foodpair.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceV1 implements UserService{

    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User UpdateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(long id) {

    }
}
