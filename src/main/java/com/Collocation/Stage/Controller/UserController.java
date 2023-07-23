package com.Collocation.Stage.Controller;

import com.Collocation.Stage.Repository.HobbyRepository;
import com.Collocation.Stage.Service.HobbyService;
import com.Collocation.Stage.Service.RoleService;
import com.Collocation.Stage.Service.UserService;
import com.Collocation.Stage.Service.AnnonceService;
import com.Collocation.Stage.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final HobbyService hobbyService;

    private final UserService userService;
    private final AnnonceService annonceService;
    private final RoleService roleService; // Ajoutez le service de gestion des rôles

    @Autowired
    public UserController(UserService userService, AnnonceService annonceService, RoleService roleService, HobbyService hobbyService) {
        this.userService = userService;
        this.annonceService = annonceService;
        this.roleService = roleService;
        this.hobbyService=hobbyService;
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

    @GetMapping("/{userId}/favorites")
    public List<Annonce> getFavoritesByUser(@PathVariable Integer userId) {
        return userService.getFavoritesByUser(userId);
    }
    @GetMapping("/{userId}/favorite-annonces")
    public List<Annonce> getFavoriteAnnoncesByUser(@PathVariable Integer userId) {
        return userService.getFavoriteAnnoncesByUser(userId);
    }

    @PostMapping("/{userId}/favorites/{annonceId}")
    public ResponseEntity<String> addFavorite(@PathVariable Integer userId, @PathVariable Integer annonceId) {
        boolean added = userService.addFavorite(userId, annonceId);
        if (added) {
            return ResponseEntity.ok("Annonce ajoutée aux favoris avec succès");
        } else {
            return ResponseEntity.badRequest().body("L'annonce existe déjà dans les favoris de l'utilisateur");
        }
    }

    @GetMapping("/{userId}/role")
    public Role getUserRole(@PathVariable Integer userId) {
        return userService.getUserRole(userId);
    }
    @PostMapping("/{userId}/role/{roleId}")
    public ResponseEntity<String> assignRoleToUser(@PathVariable Integer userId, @PathVariable Integer roleId) {
        User user = userService.getUserById(userId);
        Optional<Role> optionalRole = roleService.getRoleById(roleId);

        if (user != null && optionalRole.isPresent()) {
            Role role = optionalRole.get();
            user.setRole(role);
            userService.saveUser(user);
            return ResponseEntity.ok("Rôle attribué avec succès à l'utilisateur.");
        } else {
            return ResponseEntity.badRequest().body("Utilisateur ou rôle introuvable.");
        }
    }

    @GetMapping("/by-role-id/{roleId}")
    public ResponseEntity<List<User>> getUsersByRoleId(@PathVariable int roleId) {
        List<User> users = userService.getUsersByRoleId(roleId);
        if (users.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(users);
    }
    @PostMapping("/{userId}/hobbies/{hobbyId}")
    public ResponseEntity<String> addHobbyToUser(@PathVariable int userId, @PathVariable int hobbyId) {
        User user = userService.getUserById(userId);
        Hobby hobby = hobbyService.getHobbyById(hobbyId);

        if (user != null && hobby != null) {
            user.getHobbies().add(hobby);
            userService.saveUser(user);
            return ResponseEntity.ok("Hobby ajouté avec succès à l'utilisateur !");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("L'utilisateur ou le hobby n'a pas été trouvé.");
        }
    }
    @GetMapping("/{userId}/annonces")
    public ResponseEntity<List<Annonce>> getAnnoncesByUser(@PathVariable int userId) {
        List<Annonce> annonces = userService.getAnnoncesByUser(userId);
        if (annonces.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(annonces);
    }
    @PostMapping(value = "/addFileUser/{userId}")
    public User AddUserFile(@PathVariable int userId,@RequestParam("file") MultipartFile file) throws IOException {
return userService.AddUserFile(userId,file);


    }


}


