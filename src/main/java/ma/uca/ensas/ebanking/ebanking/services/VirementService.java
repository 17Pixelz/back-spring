package ma.uca.ensas.ebanking.ebanking.services;

import ma.uca.ensas.ebanking.ebanking.exceptions.NotFoundException;
import ma.uca.ensas.ebanking.ebanking.exceptions.SoldeInsuffisant;
import ma.uca.ensas.ebanking.ebanking.models.Client;
import ma.uca.ensas.ebanking.ebanking.models.Compte;
import ma.uca.ensas.ebanking.ebanking.models.Virement;
import ma.uca.ensas.ebanking.ebanking.repositories.CompteRepo;
import ma.uca.ensas.ebanking.ebanking.repositories.VirementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VirementService {
    private final VirementRepo virementRepo;
    private final CompteRepo compteRepo;

    @Autowired
    public VirementService(VirementRepo virementRepo,CompteRepo cr) {
        this.virementRepo = virementRepo;this.compteRepo =cr;
    }

    public Virement addVirement(Virement virement){
        Optional<Compte> c_deb = compteRepo.findCompteById(virement.getCompte_deb().getId());
        Optional<Compte> c_cre = compteRepo.findCompteById(virement.getCompte_cred().getId());
        if(c_deb.get().getSolde() >= virement.getMontant()) {
            Float solde = c_deb.get().getSolde();
            Float montant = virement.getMontant();
            c_deb.get().setSolde(solde - montant);

            c_cre.get().setSolde(c_cre.get().getSolde() + montant);
            return virementRepo.save(virement);
        }
        else{
            throw new SoldeInsuffisant("Le solde du crediteur est insuffisent");
        }
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

