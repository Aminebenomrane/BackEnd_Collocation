package com.Collocation.Stage.Service.interfaces;

import com.Collocation.Stage.entities.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public void addHobbyToUser(int userId, int hobbyId);
     public User AddUserFile(Integer userId, MultipartFile file)throws IOException;
}
