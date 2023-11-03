package yan0kom.hotadv.domain;

import javax.ejb.Local;
import java.util.Optional;
import java.util.stream.Stream;

@Local
public interface CompanyRepo {
    Stream<Company> streamAll();
    Optional<Company> getById(Long id);
}
