package it.epicode.CustomShoesBE.model;

import it.epicode.CustomShoesBE.enums.Category;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String img;

    private String name;

    private String brand;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String description;

    private double size;

    private String color;

    private double price;

}
