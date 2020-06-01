package pl.two.EatingPlanner.model;

import javax.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    @Column(length = 100000000)
    private byte[] picByte;

    private Double size;

}
