package com.Collocation.Stage.Service.interfaces;

import com.Collocation.Stage.Service.UserService;
import com.Collocation.Stage.entities.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserInterface {
    List<User> getAllUsers();

    User getUserById(Integer id);

    User saveUser(User user);

    User updateUser(User user);

    void deleteUser(Integer id);
    List<User> saveUsers(List<User> users);
    List<User> findByUsernameStartingWithLetter(String letter);
    List<User> getUsersWithCommonHobby(String hobby);
    String saveUserWTCPWD( User user);
}
