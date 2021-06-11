package ma.uca.ensas.ebanking.ebanking.services;

import ma.uca.ensas.ebanking.ebanking.exceptions.NotFoundException;
import ma.uca.ensas.ebanking.ebanking.models.Compte;
import ma.uca.ensas.ebanking.ebanking.models.Virement;
import ma.uca.ensas.ebanking.ebanking.repositories.CompteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompteService {
    private final CompteRepo compteRepo;

    @Autowired
    public CompteService(CompteRepo compteRepo) {
        this.compteRepo = compteRepo;
    }

    public Compte addCompte(Compte compte ){
        return compteRepo.save(compte);
    }

    public List<Compte> findAllComptes(){
        return compteRepo.findAll();
    }

    public Compte updateCompte(Compte compte){
        return compteRepo.save(compte);
    }

    public Compte findCompteById(String id){
        return compteRepo.findCompteById(id)
                .orElseThrow(() -> new NotFoundException("Account with " + id + " does not exist :("));
    }

    public void deleteCompteById(Long id){
        compteRepo.deleteCompteById(id);
    }
    public List<Virement> findVirementsRecus(String id){
        Compte compte = compteRepo.findCompteById(id)
                .orElseThrow(() -> new NotFoundException("Account with " + id + " does not exist :("));
        return compte.getVirements_recus();
    }

    public List<Virement> findVirementsEnvoyés(String id){
        Compte compte = compteRepo.findCompteById(id)
                .orElseThrow(() -> new NotFoundException("Account with " + id + " does not exist :("));
        return compte.getVirements_envoyé();
    }

}
