package com.Collocation.Stage.Service;

import com.Collocation.Stage.Repository.UserRepository;
import com.Collocation.Stage.Service.interfaces.UserInterface;
import com.Collocation.Stage.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService implements UserInterface {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }
    @Override

    public List<User> saveUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public User updateUser(User user) {
        return userRepository.save(user);
    }
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
    public List<User> findByUsernameStartingWithLetter(String letter) {
        return userRepository.findByUsernameStartingWithLetter(letter);
    }
    public List<User> getUsersWithCommonHobby(String hobby) {
        return userRepository.findUsersWithCommonHobby(hobby);
    }

    public String saveUserWTCPWD(@RequestBody User user) {
        String result = "";

        // Vérifier si le mot de passe et la confirmation du mot de passe correspondent
        if (!user.getPassword().equals(user.getConfirme_Password())) {
            result = "Le mot de passe et la confirmation du mot de passe ne correspondent pas";
        } else {
            userRepository.save(user);
            result = "Utilisateur enregistré avec succès";
        }

        return result;
    }

}
