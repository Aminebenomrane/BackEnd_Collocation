package com.Collocation.Stage.Controller;

import com.Collocation.Stage.Service.AnnonceService;
import com.Collocation.Stage.Service.ImageService;
import com.Collocation.Stage.entities.Annonce;
import com.Collocation.Stage.entities.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {

    private final ImageService imageService;
    private final AnnonceService annonceService;

    @Autowired
    public ImageController(ImageService imageService, AnnonceService annonceService) {
        this.imageService = imageService;
        this.annonceService = annonceService;
    }

    @GetMapping
    public List<Image> getAllImages() {
        return imageService.getAllImages();
    }

    @GetMapping("/{id}")
    public Image getImageById(@PathVariable Integer id) {
        return imageService.getImageById(id);
    }

    @PostMapping
    public Image createImage(@RequestBody Image image) {
        return imageService.saveImage(image);
    }

    @PutMapping("/{id}")
    public Image updateImage(@PathVariable Integer id, @RequestBody Image updatedImage) {
        return imageService.updateImage(id, updatedImage);
    }

    @DeleteMapping("/{id}")
    public void deleteImage(@PathVariable Integer id) {
        imageService.deleteImage(id);
    }


    @GetMapping("/{annonceId}/images")
    public ResponseEntity<List<Image>> getImagesByAnnonceId(@PathVariable Integer annonceId) {
        List<Image> images = imageService.getImagesByAnnonceId(annonceId);
        if (images != null && !images.isEmpty()) {
            return ResponseEntity.ok(images);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
