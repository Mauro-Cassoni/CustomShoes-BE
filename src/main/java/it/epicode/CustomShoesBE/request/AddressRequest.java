package it.epicode.CustomShoesBE.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddressRequest {

    @NotBlank(message = "firstname request")
    private String firstname;

    @NotBlank(message = "lastname request")
    private String lastname;

    @NotBlank(message = "street request")
    private String street;

    @NotBlank(message = "street number request")
    private String streetNumber;

    @NotBlank(message = "city request")
    private String city;

    @NotBlank(message = "postal code request")
    private Integer postalCode;

    @NotBlank(message = "country request")
    private String country;

    @NotBlank(message = "province request")
    private String province;

    @NotBlank(message = "municipality request")
    private String municipality;

    private String phoneNumber;

}
