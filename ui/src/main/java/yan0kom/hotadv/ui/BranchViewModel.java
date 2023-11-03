package yan0kom.hotadv.ui;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import java.util.List;

@VariableResolver(org.zkoss.zkplus.cdi.DelegatingVariableResolver.class)
public class BranchViewModel {
    @WireVariable
    private DomainService domainService;

    private List<BranchShort> branchList;

    @Init
    public void init() {
        refresh();
    }

    @Command
    @NotifyChange("branchList")
    public void refresh() {
        branchList = domainService.getBranchList();
    }

    public List<BranchShort> getBranchList() {
        return branchList;
    }
}
