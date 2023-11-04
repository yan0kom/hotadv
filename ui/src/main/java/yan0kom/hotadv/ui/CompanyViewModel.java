package yan0kom.hotadv.ui;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import java.util.List;

@VariableResolver(org.zkoss.zkplus.cdi.DelegatingVariableResolver.class)
public class CompanyViewModel {
    @WireVariable
    private DomainService domainService;

    private List<CompanyForTable> companyList;
    private CompanyForTable selectedCompany;
    private CompanyForEdit editorCompany;
    private List<AddressShort> addressShortList;

    @Init
    public void init() {
        refresh();
    }

    @Command
    @NotifyChange({"companyList", "editorCompany"})
    public void refresh() {
        companyList = domainService.getCompanyRowList();
        if (!companyList.isEmpty()) {
            setSelectedCompany(companyList.get(0));
        }

        addressShortList = domainService.getAddressShortList();
    }

    public List<CompanyForTable> getCompanyList() {
        return companyList;
    }

    public CompanyForTable getSelectedCompany() {
        return selectedCompany;
    }

    @NotifyChange("editorCompany")
    public void setSelectedCompany(CompanyForTable selectedCompany) {
        this.selectedCompany = selectedCompany;
        this.editorCompany = domainService.getCompanyForEdit(selectedCompany.getId()).orElse(null);
    }

    public CompanyForEdit getEditorCompany() {
        return editorCompany;
    }

    public List<AddressShort> getAddressShortList() {
        return addressShortList;
    }
}
