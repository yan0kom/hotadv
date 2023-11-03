package yan0kom.hotadv.persist;

import yan0kom.hotadv.domain.Company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;
import java.util.stream.Collectors;

/** Компания */
@Entity
@Table(name = "companies")
public class CompanyJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Название */
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    /** Правовая форма */
    @Column(name = "legal_form", nullable = true, length = 10)
    private String legalForm;

    /** Адрес */
    @OneToOne(optional = false)
    @JoinColumn(name="address_id", nullable = false)
    private AddressJpa address;

    /** Филиалы */
    @OneToMany(mappedBy = "company")
    private List<BranchJpa> branches;

    public Company toDomain() {
        return new Company(
                getId(), getName(), getLegalForm(), getAddress().toDomain(),
                getBranches().stream().map(BranchJpa::toDomain).collect(Collectors.toList()));
    }

    public Company toDomainSkipBranches() {
        return new Company(
                getId(), getName(), getLegalForm(), getAddress().toDomain(), null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLegalForm() {
        return legalForm;
    }

    public void setLegalForm(String legalForm) {
        this.legalForm = legalForm;
    }

    public AddressJpa getAddress() {
        return address;
    }

    public void setAddress(AddressJpa address) {
        this.address = address;
    }

    public List<BranchJpa> getBranches() {
        return branches;
    }

    public void setBranches(List<BranchJpa> branches) {
        this.branches = branches;
    }
}
