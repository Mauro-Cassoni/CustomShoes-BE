package it.epicode.CustomShoesBE.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;

    private String lastname;

    private String street;

    @Column(name = "street_number")
    private String streetNumber;

    private String city;

    @Column(name = "postal_code")
    private Integer postalCode;

    private String country;

    private String province;

    private String municipality;

    @Column(name = "phone_number")
    private String phoneNumber;

}
