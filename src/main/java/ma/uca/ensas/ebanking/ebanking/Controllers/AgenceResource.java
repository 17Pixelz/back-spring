package ma.uca.ensas.ebanking.ebanking.Controllers;


import ma.uca.ensas.ebanking.ebanking.models.Agence;
import ma.uca.ensas.ebanking.ebanking.models.Agent;
import ma.uca.ensas.ebanking.ebanking.models.Client;
import ma.uca.ensas.ebanking.ebanking.models.Virement;
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

    @GetMapping("/find/{id}")
    public ResponseEntity<Agence> getClientById (@PathVariable("id") Long id){
        Agence agence = agenceService.findAgenceById(id);
        return new ResponseEntity<>(agence,HttpStatus.OK);
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

    @PutMapping("/update")
    public ResponseEntity<Agence> updateAgence(@RequestBody Agence agence){
        Agence agent1 = agenceService.updateAgence(agence);
        return new ResponseEntity<>(agent1,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAgence(@PathVariable("id") Long id){
        agenceService.deleteAgence(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/clients/{id}")
    public ResponseEntity<List<Client>> getClients (@PathVariable("id") Long id){
        List<Client> clients = agenceService.findClientsAgence(id);
        return new ResponseEntity<>(clients,HttpStatus.OK);
    }

    @GetMapping("/find/agents/{id}")
    public ResponseEntity<List<Agent>> getAgents (@PathVariable("id") Long id){
        List<Agent> agents = agenceService.findAgentsAgence(id);
        return new ResponseEntity<>(agents,HttpStatus.OK);
    }

}
