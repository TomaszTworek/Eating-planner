package pl.two.EatingPlanner.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.two.EatingPlanner.converters.ImageConverter;
import pl.two.EatingPlanner.model.Image;
import pl.two.EatingPlanner.repository.ImageRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    private final ImageRepository imageRepository;
    private Image currentImage;

    public Image getCurrentImage() {
        return currentImage;
    }

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }


    public Image save(MultipartFile file) throws IOException {
        Image img = new Image(file.getOriginalFilename(), file.getContentType(),
                ImageConverter.compressBytes(file.getBytes()), file.getSize());
        this.currentImage = img;
        return imageRepository.save(img);
    }

    public Optional<Image> findByName(String imageName) {
        return imageRepository.findByName(imageName);
    }

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }
}
