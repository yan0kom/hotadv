package yan0kom.hotadv.persist;

import yan0kom.hotadv.domain.Address;
import yan0kom.hotadv.domain.AddressRepo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.stream.Stream;

@Stateless
public class AddressRepoImpl implements AddressRepo {
    @PersistenceContext(unitName = "primary")
    private EntityManager em;

    @Override
    public Stream<Address> streamAll() {
        Stream<AddressJpa> jpa = em.createQuery("SELECT a FROM AddressJpa a").getResultStream();
        return jpa.map(AddressJpa::toDomain);
    }
}
