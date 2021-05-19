package ma.uca.ensas.ebanking.ebanking.Controllers;


import ma.uca.ensas.ebanking.ebanking.models.Agence;
import ma.uca.ensas.ebanking.ebanking.services.AgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/agence")
public class AgenceResource {
    private final AgenceService agenceService;

    public AgenceResource(AgenceService agenceService) {
        this.agenceService = agenceService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Agence>> getAllAgences(){
        List<Agence> l = agenceService.findAllAgences();
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Agence> addAgence(@RequestBody Agence agence){
        Agence agence1 = agenceService.addAgence(agence);
        return new ResponseEntity<>(agence1,HttpStatus.OK);
    }


}