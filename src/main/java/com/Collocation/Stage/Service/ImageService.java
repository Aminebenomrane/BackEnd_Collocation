package com.Collocation.Stage.Service;

import com.Collocation.Stage.Repository.ImageRepository;
import com.Collocation.Stage.Service.interfaces.ImageInterface;
import com.Collocation.Stage.entities.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService implements ImageInterface {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public Image getImageById(Integer id) {
        return imageRepository.findById(id).orElse(null);
    }

    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }

    public Image updateImage(Integer id, Image updatedImage) {
        Image image = imageRepository.findById(id).orElse(null);
        if (image != null) {
            // Update image fields with the values from updatedImage
            image.setNom_Image(updatedImage.getNom_Image());
            image.setType_Image(updatedImage.getType_Image());

            return imageRepository.save(image);
        }
        return null;
    }

    public void deleteImage(Integer id) {
        imageRepository.deleteById(id);
    }

    @Override
    public List<Image> getImagesByAnnonceId(Integer annonceId) {
        return null;
    }


}
