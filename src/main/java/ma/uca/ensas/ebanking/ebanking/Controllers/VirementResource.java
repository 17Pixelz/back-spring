package ma.uca.ensas.ebanking.ebanking.Controllers;

import ma.uca.ensas.ebanking.ebanking.exceptions.SoldeInsuffisant;
import ma.uca.ensas.ebanking.ebanking.models.Compte;
import ma.uca.ensas.ebanking.ebanking.models.Virement;
import ma.uca.ensas.ebanking.ebanking.services.CompteService;
import ma.uca.ensas.ebanking.ebanking.services.VirementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.NotActiveException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/virement")

public class VirementResource {
    private final VirementService virementService;

    public VirementResource(VirementService virementService) {
        this.virementService = virementService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Virement>> getAllVirements(){
        List<Virement> l = virementService.findAllVirements();
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Virement> getVirementById (@PathVariable("id") Long id){
        Virement virement = virementService.findVirementById(id);
        return new ResponseEntity<>(virement,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Virement> addVirement(@RequestBody Virement virement){
            Virement virement1 = virementService.addVirement(virement);
            return new ResponseEntity<>(virement1, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Virement> updateVirement(@RequestBody Virement virement){

        Virement virement1 = virementService.updateVirement(virement);
        return new ResponseEntity<>(virement1,HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public ResponseEntity<?> deleteVirement(@PathVariable("id") Long id){
        virementService.deleteVirementById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
