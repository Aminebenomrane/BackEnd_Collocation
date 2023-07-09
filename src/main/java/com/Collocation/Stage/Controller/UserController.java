package com.Collocation.Stage.Controller;

import com.Collocation.Stage.Service.UserService;
import com.Collocation.Stage.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User updatedUser) {
        User user = userService.getUserById(id);
        if (user != null) {
            user.setNom(updatedUser.getNom());
            user.setPrenom(updatedUser.getPrenom());
            user.setAge(updatedUser.getAge());
            user.setEMail(updatedUser.getEMail());
            user.setAdresse(updatedUser.getAdresse());
            user.setAnnonces(updatedUser.getAnnonces());
            user.setGenre(updatedUser.getGenre());
            user.setHobbies(updatedUser.getHobbies());
            user.setImageURL(updatedUser.getImageURL());
            user.setPassword(updatedUser.getPassword());
            user.setProfession(updatedUser.getProfession());
            user.setTelephone(updatedUser.getTelephone());


            return userService.saveUser(user);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
    @PostMapping("/SaveAll")
    public List<User> saveUsers(@RequestBody List<User> users) {
        return userService.saveUsers(users);
    }
    @GetMapping("/starting-with/{letter}")
    public List<User> getUsersByUsernameStartingWith(@PathVariable("letter") String letter) {
        return userService.findByUsernameStartingWithLetter(letter);
    }
    @GetMapping("/with-hobby/{hobby}")
    public List<User> getUsersWithCommonHobby(@PathVariable("hobby") String hobby) {
        return userService.getUsersWithCommonHobby(hobby);
    }
    @PostMapping("/passwordConfirm")
    public String saveUserWTCPWD(@RequestBody User user) {
        return userService.saveUserWTCPWD(user);
    }


}
