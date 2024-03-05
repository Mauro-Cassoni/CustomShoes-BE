package it.epicode.CustomShoesBE.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.epicode.CustomShoesBE.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String password;

    private String firstname;

    private String lastname;

    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "User_Product",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")}
    )
    private List<Product> wishlist;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne
    @JoinColumn(name = "shipping_address")
    private Address  shippingAddress;

    //Business

    @Column(name = "business_name", unique = true)
    private String businessName;

    @Column(name = "vat_number", unique = true)
    private String vatNumber;

    @Column(name = "insertion_date")
    private LocalDate insertionDate;

    @Column(unique = true)
    @Email
    private String pec;

    private String sdi;

    @OneToOne
    @JoinColumn(name = "registered_office_address_id")
    private Address  registeredOfficeAddress;

    @OneToOne
    @JoinColumn(name = "operational_headquarters_address_id")
    private Address  operationalHeadquartersAddress;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "businessUser")
    private List<Invoice> invoices;
}
