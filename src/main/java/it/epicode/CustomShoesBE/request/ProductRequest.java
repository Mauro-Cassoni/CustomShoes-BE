package it.epicode.CustomShoesBE.request;

import it.epicode.CustomShoesBE.enums.Category;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductRequest {

    @NotBlank(message = "img request")
    private String img;

    @NotBlank(message = "name request")
    private String name;

    private String brand;

    @NotBlank(message = "category request")
    private Category category;

    @NotBlank(message = "description request")
    private String description;

    private double size;

    private String color;

    @NotBlank(message = "price request")
    private double price;







}
