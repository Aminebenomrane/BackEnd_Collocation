package com.Collocation.Stage.Service;

import com.Collocation.Stage.Repository.AnnonceRepository;
import com.Collocation.Stage.Repository.FileeRepository;
import com.Collocation.Stage.Repository.HobbyRepository;
import com.Collocation.Stage.Repository.UserRepository;
import com.Collocation.Stage.Service.interfaces.UserInterface;
import com.Collocation.Stage.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserInterface {
    private final HobbyRepository hobbyRepository;
    private final FileeRepository fileeRepository;
    private final FileeService fileeService;

    private final UserRepository userRepository;
    private final AnnonceRepository annonceRepository;

    @Autowired
    public UserService(UserRepository userRepository, AnnonceRepository annonceRepository,HobbyRepository hobbyRepository,FileeRepository fileeRepository,FileeService fileeService) {
        this.userRepository = userRepository;
        this.annonceRepository = annonceRepository;
        this.hobbyRepository=hobbyRepository;
        this.fileeRepository=fileeRepository;
        this.fileeService=fileeService;
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

    public String saveUserWTCPWD(User user) {
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

    public List<Annonce> getFavoritesByUser(Integer userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            List<AnnonceFavori> favorites = user.getFavorites();
            List<Annonce> favoriteAnnonces = new ArrayList<>();
            for (AnnonceFavori favorite : favorites) {
                favoriteAnnonces.add(favorite.getAnnonce());
            }
            return favoriteAnnonces;
        }
        return Collections.emptyList();
    }
    public List<Annonce> getFavoriteAnnoncesByUser(Integer userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            List<AnnonceFavori> favorites = user.getFavorites();
            List<Annonce> favoriteAnnonces = new ArrayList<>();
            for (AnnonceFavori favorite : favorites) {
                favoriteAnnonces.add(favorite.getAnnonce());
            }
            return favoriteAnnonces;
        }
        return Collections.emptyList();
    }

    public boolean addFavorite(Integer userId, Integer annonceId) {
        User user = userRepository.findById(userId).orElse(null);
        Annonce annonce = annonceRepository.findById(annonceId).orElse(null);

        if (user != null && annonce != null) {
            List<AnnonceFavori> favorites = user.getFavorites();
            for (AnnonceFavori favorite : favorites) {
                if (favorite.getAnnonce().getId_annonce()==(annonceId)) {
                    return false; // L'annonce existe déjà dans les favoris de l'utilisateur
                }
            }

            // Créer un nouvel objet Favorite et l'ajouter à la liste des favoris de l'utilisateur
            AnnonceFavori newFavorite = new AnnonceFavori();
            newFavorite.setUser(user);
            newFavorite.setAnnonce(annonce);
            favorites.add(newFavorite);
            userRepository.save(user);
            return true; // L'annonce a été ajoutée avec succès aux favoris de l'utilisateur
        }

        return false; // L'utilisateur ou l'annonce n'existe pas
    }
    public Role getUserRole(Integer userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return user.getRole();
        }
        return null;
    }

    @Override
    public User AddUserFile(Integer userId, MultipartFile file) throws IOException {
        User user=userRepository.findById(userId).get();
        Filee f =fileeService.uploadImage(file);
        user.setFilee(f);
        return userRepository.save(user);
    }

    public List<User> getUsersByRoleId(int roleId) {
        return userRepository.findByRoleId(roleId);
    }
    public void addHobbyToUser(int userId, int hobbyId) {
        User user = userRepository.findById(userId).orElse(null);
        Hobby hobby = hobbyRepository.findById(hobbyId).orElse(null);

        if (user != null && hobby != null) {
            user.getHobbies().add(hobby);
            userRepository.save(user);
        } else {
            // Gérer le cas où l'utilisateur ou le hobby n'a pas été trouvé
        }
    }

   public List<Annonce> getAnnoncesByUser(int userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return user.getAnnonces();
        } else {
            return Collections.emptyList();
        }
    }




}
