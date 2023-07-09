package com.Collocation.Stage.Service.interfaces;

import com.Collocation.Stage.entities.Image;

import java.util.List;

public interface ImageInterface {
    List<Image> getAllImages();

    Image getImageById(Integer id);

    Image saveImage(Image image);

    Image updateImage(Integer id, Image updatedImage);

    void deleteImage(Integer id);
}
