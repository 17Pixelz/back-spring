package ma.uca.ensas.ebanking.ebanking.services;

import ma.uca.ensas.ebanking.ebanking.exceptions.AgenceNotFoundException;
import ma.uca.ensas.ebanking.ebanking.exceptions.SiegeNotFoundException;
import ma.uca.ensas.ebanking.ebanking.models.Agence;
import ma.uca.ensas.ebanking.ebanking.models.Siege;
import ma.uca.ensas.ebanking.ebanking.repositories.AgenceRepo;
import ma.uca.ensas.ebanking.ebanking.repositories.SiegeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiegeService {
    private final SiegeRepo siegeRepo;

    @Autowired
    public SiegeService(SiegeRepo siegeRepo) {
        this.siegeRepo = siegeRepo;
    }

    public Siege addSiege(Siege siege){
        return siegeRepo.save(siege);
    }

    public List<Siege> findAllSieges(){
        return siegeRepo.findAll();
    }

    public Siege updateSiege(Siege siege){
        return siegeRepo.save(siege);
    }

    public Siege findSiegeById(Long id){
        return siegeRepo.findSiegeById(id).orElseThrow(()-> new SiegeNotFoundException("Siege " + id + " Not Found"));
    }

    public void deleteSiege(Long id){
        siegeRepo.deleteSiegeById(id);
    }
}
