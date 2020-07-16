package pl.two.EatingPlanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import pl.two.EatingPlanner.services.ImageService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class OnStart implements CommandLineRunner {

    private ImageService imageService;

    public OnStart(ImageService imageService) {
        this.imageService = imageService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (imageService.getAllImages().size() == 0) {
            setDefaultImage();
        }
    }

    private void setDefaultImage() throws IOException {
        InputStream file = new FileInputStream(new File("C:/IntelProjects/EatingPlanner/EatingPlanner/src/main/resources/static/brak-zdjecia.jpg"));
        MultipartFile multipartFileToSend = new MockMultipartFile("file", "brak-zdjecia", String.valueOf(MediaType.IMAGE_JPEG), file);
        imageService.save(multipartFileToSend);
    }
}
