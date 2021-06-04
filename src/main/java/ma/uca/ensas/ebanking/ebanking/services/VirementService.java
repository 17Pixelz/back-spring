package ma.uca.ensas.ebanking.ebanking.services;

import ma.uca.ensas.ebanking.ebanking.exceptions.NotFoundException;
import ma.uca.ensas.ebanking.ebanking.models.Virement;
import ma.uca.ensas.ebanking.ebanking.repositories.VirementRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class VirementService {
    private final VirementRepo virementRepo;

    @Autowired
    public VirementService(VirementRepo virementRepo) {
        this.virementRepo = virementRepo;
    }

    public Virement addVirement(Virement virement ){
        return virementRepo.save(virement);
    }

    public List<Virement> findAllVirements(){
        return virementRepo.findAll();
    }

    public Virement updateVirement(Virement virement){
        return virementRepo.save(virement);
    }

    public Virement findVirementById(Long id){
        return virementRepo.findVirementById(id)
                .orElseThrow(() -> new NotFoundException("Virement with " + id + " does not exist :("));
    }

    public List<Virement> findVirementByAccId(Long id){
        return virementRepo.findVirementByCompteId(id)
                .orElseThrow(() -> new NotFoundException("Client with " + id + " Has no virements :("));
    }

    public void deleteVirementById(Long id){
        virementRepo.deleteVirementById(id);
    }
}
