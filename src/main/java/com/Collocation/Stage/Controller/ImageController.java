package com.Collocation.Stage.Controller;

import com.Collocation.Stage.Service.ImageService;
import com.Collocation.Stage.entities.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
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
}
