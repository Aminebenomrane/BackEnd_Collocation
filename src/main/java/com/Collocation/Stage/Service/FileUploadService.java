package com.Collocation.Stage.Service;

import com.Collocation.Stage.Repository.AnnonceRepository;
import com.Collocation.Stage.Repository.ImageRepository;
import com.Collocation.Stage.Repository.UserRepository;
import com.Collocation.Stage.entities.Annonce;
import com.Collocation.Stage.entities.Image;
import com.Collocation.Stage.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class FileUploadService {

    private final UserRepository userRepository;
    private final AnnonceRepository annonceRepository;
    private final ImageRepository imageRepository;

    @Autowired
    public FileUploadService(UserRepository userRepository, AnnonceRepository annonceRepository, ImageRepository imageRepository) {
        this.userRepository = userRepository;
        this.annonceRepository = annonceRepository;
        this.imageRepository = imageRepository;
    }

   /* public void uploadImage(Integer userId, Integer annonceId, MultipartFile file) throws IOException {
        // Vérifier si l'utilisateur existe
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            throw new IllegalArgumentException("User not found");
        }

        // Vérifier si l'annonce existe et appartient à l'utilisateur
        User user = userOptional.get();
        Optional<Annonce> annonceOptional = user.getAnnonces().stream()
                .filter(annonce -> annonce.getId_annonce()==(annonceId))
                .findFirst();

        if (!annonceOptional.isPresent()) {
            throw new IllegalArgumentException("Annonce not found");
        }

        Annonce annonce = annonceOptional.get();

        // Enregistrer l'image dans la base de données
        Image image = new Image();
        image.setNom_Image(file.getOriginalFilename()); // Vous pouvez utiliser un chemin ou un nom unique pour l'image
        image.setAnnonce(annonce);

        imageRepository.save(image);
    }*/

    /*  public boolean deleteImage(int userId, int annonceId, int imageId) {
        Annonce annonce = annonceRepository.findById(annonceId)
                .orElse(null);

        User user = userRepository.findById(userId)
                .orElse(null);

        if (user == null || annonce == null) {
            return false; // L'utilisateur ou l'annonce n'a pas été trouvé
        }

        // Vérifier si l'annonce appartient à l'utilisateur
        if (!user.getAnnonces().contains(annonce)) {
            return false; // L'utilisateur n'est pas autorisé à supprimer cette image
        }

        Image image = imageRepository.findById(imageId)
                .orElse(null);

        if (image == null || !annonce.getImages().contains(image)) {
            return false; // L'image n'a pas été trouvée dans l'annonce spécifiée
        }

        // Supprimer l'image de l'annonce et la supprimer de la base de données
        annonce.getImages().remove(image);
        imageRepository.delete(image);

        return true; // Suppression réussie
    }*/
}
