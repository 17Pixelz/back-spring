package ma.uca.ensas.ebanking.ebanking.Controllers;

import ma.uca.ensas.ebanking.ebanking.models.Compte;
import ma.uca.ensas.ebanking.ebanking.models.Virement;
import ma.uca.ensas.ebanking.ebanking.services.CompteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/compte")
public class CompteResource {
    private final CompteService compteService;

    public CompteResource(CompteService compteService) {
        this.compteService = compteService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Compte>> getAllComptes(){
        List<Compte> l = compteService.findAllComptes();
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Compte> getCompteById (@PathVariable("id") Long id){
        Compte compte = compteService.findCompteById(id);
        return new ResponseEntity<>(compte,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Compte> addCompte(@RequestBody Compte compte){
        Compte compte1 = compteService.addCompte(compte);
        return new ResponseEntity<>(compte1,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Compte> updateCompte(@RequestBody Compte compte){
        Compte compte1 = compteService.updateCompte(compte);
        return new ResponseEntity<>(compte1,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCompte(@PathVariable("id") Long id){
        compteService.deleteCompteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/virement/recu/{id}")
    public ResponseEntity<List<Virement>> getVirementsRecus (@PathVariable("id") Long id){
        List<Virement> virRecus = compteService.findVirementsRecus(id);
        return new ResponseEntity<>(virRecus,HttpStatus.OK);
    }

    @GetMapping("/find/virement/envoye/{id}")
    public ResponseEntity<List<Virement>> getVirementsEnvoyés (@PathVariable("id") Long id){
        List<Virement> virEnv = compteService.findVirementsEnvoyés(id);
        return new ResponseEntity<>(virEnv,HttpStatus.OK);
    }
}
