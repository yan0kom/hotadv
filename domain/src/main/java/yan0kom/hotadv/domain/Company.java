package yan0kom.hotadv.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class Company {
    private Long id;
    @NotBlank
    private String name;
    private String legalForm;
    @NotNull
    private Address address;
    private List<Branch> branches;

    public Company(Long id, String name, String legalForm, Address address, List<Branch> branches) {
        this.id = id;
        this.name = name;
        this.legalForm = legalForm;
        this.address = address;
        this.branches = branches;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLegalForm() {
        return legalForm;
    }

    public Address getAddress() {
        return address;
    }

    public List<Branch> getBranches() {
        return branches;
    }
}
