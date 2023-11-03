package yan0kom.hotadv.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Branch {
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private Company company;
    @NotNull
    private Address address;

    public Branch(Long id, String name, Company company, Address address) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public Address getAddress() {
        return address;
    }
}
