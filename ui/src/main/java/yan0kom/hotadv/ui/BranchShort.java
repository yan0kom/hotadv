package yan0kom.hotadv.ui;

import yan0kom.hotadv.domain.Branch;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BranchShort {
    private Long id;
    private String company;
    private String name;
    private String address;

    public BranchShort(Branch de) {
        this.id = de.getId();
        this.name = de.getName();
        this.company = de.getCompany().getName();
        var a = de.getAddress();
        this.address = Stream
                .of(a.getZipCode(), a.getCity(), a.getStreet(), a.getHouse(), a.getApartment())
                .filter(Objects::nonNull)
                .collect(Collectors.joining(", "));
    }

    public Long getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
