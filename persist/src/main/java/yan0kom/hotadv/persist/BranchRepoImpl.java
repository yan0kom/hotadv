package yan0kom.hotadv.persist;

import yan0kom.hotadv.domain.BranchRepo;
import yan0kom.hotadv.domain.Branch;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.stream.Stream;

@Stateless
public class BranchRepoImpl implements BranchRepo {
    @PersistenceContext(unitName = "primary")
    private EntityManager em;

    @Override
    public Stream<Branch> streamAll() {
        Stream<BranchJpa> jpa = em.createQuery("SELECT b FROM BranchJpa b").getResultStream();
        return jpa.map(BranchJpa::toDomain);
    }

    public Stream<Branch> streamByCompany(CompanyJpa c) {
        var q = em.createQuery("SELECT b FROM BranchJpa b WHERE b.company = :c");
        q.setParameter("c", c);
        Stream<BranchJpa> jpa = q.getResultStream();
        return jpa.map(BranchJpa::toDomain);
    }
}
