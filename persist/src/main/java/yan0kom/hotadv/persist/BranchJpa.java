package yan0kom.hotadv.persist;

import yan0kom.hotadv.domain.Branch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/** Филиалы */
@Entity
@Table(name = "branches")
public class BranchJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Название */
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    /** Компания */
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private CompanyJpa company;

    /** Адрес */
    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private AddressJpa address;

    public Branch toDomain() {
        return new Branch(getId(), getName(), getCompany().toDomainSkipBranches(), getAddress().toDomain());
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

    public CompanyJpa getCompany() {
        return company;
    }

    public void setCompany(CompanyJpa company) {
        this.company = company;
    }

    public AddressJpa getAddress() {
        return address;
    }

    public void setAddress(AddressJpa address) {
        this.address = address;
    }
}
