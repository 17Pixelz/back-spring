package ma.uca.ensas.ebanking.ebanking.services;

import ma.uca.ensas.ebanking.ebanking.exceptions.NotFoundException;
import ma.uca.ensas.ebanking.ebanking.models.Virement;
import ma.uca.ensas.ebanking.ebanking.repositories.VirementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Service
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



    public void deleteVirementById(Long id){
        virementRepo.deleteVirementById(id);
    }
}
