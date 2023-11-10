package yan0kom.hotadv.persist;

import yan0kom.hotadv.domain.Company;
import yan0kom.hotadv.domain.CompanyRepo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;
import java.util.stream.Stream;

@Stateless
public class CompanyRepoImpl implements CompanyRepo {
    @PersistenceContext(unitName = "primary")
    private EntityManager em;

    @Override
    public Stream<Company> streamAll() {
        Stream<CompanyJpa> jpa = em.createQuery("SELECT c FROM CompanyJpa c", CompanyJpa.class).getResultStream();
        return jpa.map(CompanyJpa::toDomain);
    }

    @Override
    public Optional<Company> getById(Long id) {
        var q = em.createQuery("SELECT c FROM CompanyJpa c WHERE c.id = :id", CompanyJpa.class);
        q.setParameter("id", id);
        try {
            return Optional.of(q.getSingleResult()).map(CompanyJpa::toDomain);
        } catch (Exception ex) {
            return Optional.empty();
        }
    }
}
