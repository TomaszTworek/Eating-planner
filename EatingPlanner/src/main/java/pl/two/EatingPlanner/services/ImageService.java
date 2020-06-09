package pl.two.EatingPlanner.services;

import org.springframework.stereotype.Service;
import pl.two.EatingPlanner.model.Image;
import pl.two.EatingPlanner.repository.ImageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image save(Image image) {
        return imageRepository.save(image);
    }

    public Image findByName(String imageName) {
        return imageRepository.findByName(imageName);
    }

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }
}
