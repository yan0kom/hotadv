package yan0kom.hotadv.ui;

import yan0kom.hotadv.domain.Address;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressShort {
    private Long id;
    private String text;

    public AddressShort(Address de) {
        this.id = de.getId();
        this.text = Stream
                .of(de.getZipCode(), de.getCity(), de.getStreet(), de.getHouse(), de.getApartment())
                .filter(Objects::nonNull)
                .collect(Collectors.joining(", "));
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressShort that = (AddressShort) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
