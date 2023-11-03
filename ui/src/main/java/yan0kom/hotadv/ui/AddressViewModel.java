package yan0kom.hotadv.ui;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import yan0kom.hotadv.domain.Address;

import java.util.List;

@VariableResolver(org.zkoss.zkplus.cdi.DelegatingVariableResolver.class)
public class AddressViewModel {
    @WireVariable
    private DomainService domainService;

    private List<Address> addressList;

    @Init
    public void init() {
        refresh();
    }

    @Command
    @NotifyChange("addressList")
    public void refresh() {
        addressList = domainService.getAddressList();
    }

    public List<Address> getAddressList() {
        return addressList;
    }
}
