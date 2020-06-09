package pl.two.EatingPlanner.controllers;

import org.springframework.web.bind.annotation.RestController;
import pl.two.EatingPlanner.services.ImageService;

@RestController
public class ImageController {

    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }
}
