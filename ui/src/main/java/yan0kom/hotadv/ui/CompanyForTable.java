package yan0kom.hotadv.ui;

import yan0kom.hotadv.domain.Company;

import java.util.Objects;

public class CompanyForTable {
    private Long id;
    private String name;
    private String legalForm;
    private String address;

    public CompanyForTable(Company de) {
        this.id = de.getId();
        this.name = de.getName();
        this.legalForm = de.getLegalForm();
        this.address = new AddressShort(de.getAddress()).getText();
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

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyForTable that = (CompanyForTable) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
