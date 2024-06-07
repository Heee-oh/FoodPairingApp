package FoodPair.foodpair.service;

import FoodPair.foodpair.domain.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Optional<User> findById(long id);

    User UpdateUser(User user);

    void deleteUser(long id);


}
