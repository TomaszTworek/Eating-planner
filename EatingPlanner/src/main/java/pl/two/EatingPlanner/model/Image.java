package pl.two.EatingPlanner.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    @Column(length = 100000000)
    private byte[] picByte;

    private Long size;

    public Image(String name, String type, byte[] picByte, Long size) {
        this.name = name;
        this.type = type;
        this.picByte = picByte;
        this.size = size;
    }
}
