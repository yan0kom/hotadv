package yan0kom.hotadv.persist;

import yan0kom.hotadv.domain.Address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** Адрес */
@Entity
@Table(name = "addresses")
public class AddressJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Индекс */
    @Column(name = "zip_code", nullable = true, length = 6)
    private String zipCode;

    /** Город (об.) */
    @Column(name = "city", nullable = false, length = 100)
    private String city;

    /** Улица (об.) */
    @Column(name = "street", nullable = false, length = 150)
    private String street;

    /** Дом (об.) */
    @Column(name = "house", nullable = false, length = 50)
    private String house;

    /** Квартира */
    @Column(name = "apartment", nullable = true, length = 25)
    private String apartment;

    public Address toDomain() {
        return new Address(getId(), getZipCode(), getCity(), getStreet(), getHouse(), getApartment());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}
