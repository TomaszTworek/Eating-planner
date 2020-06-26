package pl.two.EatingPlanner.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.two.EatingPlanner.converters.ImageConverter;
import pl.two.EatingPlanner.model.Image;
import pl.two.EatingPlanner.services.ImageService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/image")
@CrossOrigin
public class ImageController {

    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    public BodyBuilder uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        imageService.save(file);
        return status(HttpStatus.OK);
    }

    @GetMapping(path = {"/get/{imageName}"})
    public Image getImageByName(@PathVariable("imageName") String imageName){
        final Optional<Image> retrievedImage = imageService.findByName(imageName);
        return new Image(retrievedImage.get().getName(), retrievedImage.get().getType(),
                ImageConverter.decompressBytes(retrievedImage.get().getPicByte()), retrievedImage.get().getSize());
    }

    @GetMapping("/get/all")
    public List<Image> getAllImages() {
        return imageService.getAllImages();
    }
}
