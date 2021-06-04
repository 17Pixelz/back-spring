package ma.uca.ensas.ebanking.ebanking.services;

import ma.uca.ensas.ebanking.ebanking.exceptions.NotFoundException;
import ma.uca.ensas.ebanking.ebanking.models.Agence;
import ma.uca.ensas.ebanking.ebanking.repositories.AgenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenceService {
    private final AgenceRepo agenceRepo;

    @Autowired
    public AgenceService(AgenceRepo agenceRepo) {
        this.agenceRepo = agenceRepo;
    }

    public Agence addAgence(Agence agence){
        return agenceRepo.save(agence);
    }

    public List<Agence> findAllAgences(){
        return agenceRepo.findAll();
    }

    public Agence updateAgence(Agence agence){
        return agenceRepo.save(agence);
    }

    public Agence findAgenceById(Long id){
        return agenceRepo.findAgenceById(id).orElseThrow(()-> new NotFoundException("Agence " + id + " Not Found"));
    }

    public void deleteAgence(Long id){
        agenceRepo.deleteAgenceById(id);
    }

}
