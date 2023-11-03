package yan0kom.hotadv.ui;

import yan0kom.hotadv.domain.Branch;
import yan0kom.hotadv.domain.Company;

import java.util.List;
import java.util.stream.Collectors;

public class CompanyForEdit {
    private Long id;
    private String name;
    private String legalForm;
    private AddressShort address;
    private List<String> branches;

    public CompanyForEdit(Company de) {
        this.id = de.getId();
        this.name = de.getName();
        this.legalForm = de.getLegalForm();
        this.address = new AddressShort(de.getAddress());
        this.branches = de.getBranches().stream().map(Branch::getName).collect(Collectors.toList());
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

    public AddressShort getAddress() {
        return address;
    }

    public List<String> getBranches() {
        return branches;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLegalForm(String legalForm) {
        this.legalForm = legalForm;
    }

    public void setAddress(AddressShort address) {
        this.address = address;
    }

    public void setBranches(List<String> branches) {
        this.branches = branches;
    }
}
