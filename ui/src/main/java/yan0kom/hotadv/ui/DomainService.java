package yan0kom.hotadv.ui;

import yan0kom.hotadv.domain.Address;
import yan0kom.hotadv.domain.AddressRepo;
import yan0kom.hotadv.domain.BranchRepo;
import yan0kom.hotadv.domain.CompanyRepo;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Named
public class DomainService {
    @EJB
    private AddressRepo addressRepo;
    @EJB
    private BranchRepo branchRepo;
    @EJB
    private CompanyRepo companyRepo;

    @Transactional
    public List<Address> getAddressList() {
        return addressRepo.streamAll().collect(Collectors.toUnmodifiableList());
    }

    @Transactional
    public List<AddressShort> getAddressShortList() {
        return addressRepo.streamAll().map(AddressShort::new).collect(Collectors.toUnmodifiableList());
    }

    @Transactional
    public List<BranchShort> getBranchList() {
        return branchRepo.streamAll()
                .map(BranchShort::new)
                .collect(Collectors.toUnmodifiableList());
    }

    @Transactional
    public List<CompanyForTable> getCompanyRowList() {
        return companyRepo.streamAll()
                .map(CompanyForTable::new)
                .collect(Collectors.toUnmodifiableList());
    }

    @Transactional
    public Optional<CompanyForEdit> getCompanyForEdit(Long id) {
        return companyRepo.getById(id).map(CompanyForEdit::new);
    }
}
