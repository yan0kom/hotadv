package yan0kom.hotadv.domain;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

public class Address {
    private Long id;
    @Digits(integer = 6, fraction = 0)
    private String zipCode;
    @NotBlank
    private String city;
    @NotBlank
    private String street;
    @NotBlank
    private String house;
    private String apartment;

    public Address(Long id, String zipCode, String city, String street, String house, String apartment) {
        this.id = id;
        this.zipCode = zipCode;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }

    public Long getId() {
        return id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public String getApartment() {
        return apartment;
    }
}
