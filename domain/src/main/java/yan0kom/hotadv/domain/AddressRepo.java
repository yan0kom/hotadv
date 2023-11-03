package yan0kom.hotadv.domain;

import javax.ejb.Local;
import java.util.stream.Stream;

@Local
public interface AddressRepo {
    Stream<Address> streamAll();
}
