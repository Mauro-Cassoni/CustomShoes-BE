package it.epicode.CustomShoesBE.request;

import it.epicode.CustomShoesBE.enums.Role;
import it.epicode.CustomShoesBE.model.Address;
import it.epicode.CustomShoesBE.model.Invoice;
import it.epicode.CustomShoesBE.model.Product;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserRequest {

    @NotBlank(message = "email request")
    @Email
    private String email;

    @NotBlank(message = "password request")
    private String password;

    @NotBlank(message = "firstname request")
    private String firstname;

    @NotBlank(message = "lastname request")
    private String lastname;

    @NotBlank(message = "phone number request")
    private String phoneNumber;

    private List<Product> wishlist;

    private Role role;

    private Address shippingAddress;

    //Business

    private String businessName;
    private String vatNumber;
    private LocalDate insertionDate;
    private String pec;
    private String sdi;
    private Address  registeredOfficeAddress;
    private Address  operationalHeadquartersAddress;
    private List<Invoice> invoices;

}
