package com.Collocation.Stage.Controller;

import com.Collocation.Stage.Service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/users/{userId}/annonces/{annonceId}/images")
public class FileUploadController {

    private final FileUploadService fileUploadService;

    @Autowired
    public FileUploadController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

  /*  @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@PathVariable("userId") Integer userId,
                                              @PathVariable("annonceId") Integer annonceId,
                                              @RequestParam("file") MultipartFile file) {
        try {
            fileUploadService.uploadImage(userId, annonceId, file);
            return ResponseEntity.ok("Image uploaded successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to upload image: " + e.getMessage());
        }
    }
    @DeleteMapping("/{imageId}")
    public ResponseEntity<String> deleteImage(@PathVariable int userId, @PathVariable int annonceId, @PathVariable int imageId) {
        boolean deleted = fileUploadService.deleteImage(userId, annonceId, imageId);

        if (deleted) {
            return ResponseEntity.ok("Image supprimée avec succès.");
        } else {
            return ResponseEntity.notFound().build(); // Image non trouvée ou suppression échouée
        }
    }*/

}
