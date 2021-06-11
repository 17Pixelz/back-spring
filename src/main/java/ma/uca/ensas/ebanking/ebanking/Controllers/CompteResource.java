package ma.uca.ensas.ebanking.ebanking.Controllers;

import ma.uca.ensas.ebanking.ebanking.models.*;
import ma.uca.ensas.ebanking.ebanking.services.AgentService;
import ma.uca.ensas.ebanking.ebanking.services.ClientService;
import ma.uca.ensas.ebanking.ebanking.services.CompteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/compte")



public class CompteResource {
    private final CompteService compteService;
    private final ClientService clientService;
    private final AgentService AgentService;
    public CompteResource(CompteService compteService,ClientService clientService,AgentService AgentService) {
        this.clientService = clientService;
        this.AgentService=AgentService;
        this.compteService = compteService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Compte>> getAllComptes(){
        List<Compte> l = compteService.findAllComptes();
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Compte> getCompteById (@PathVariable("id") String id){
        Compte compte = compteService.findCompteById(id);
        return new ResponseEntity<>(compte,HttpStatus.OK);
    }

    @PostMapping("/add/{id_clients}/{id_agent}")
    public ResponseEntity<Compte> addCompte(@RequestBody Compte compte,@PathVariable("id_clients") Long id_clients,@PathVariable("id_agent") Long id_agent){
        Agent ag=AgentService.findAgentById(id_agent);
        Client cl=clientService.findClientById(id_clients);
        UUID uid = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
        compte.setId("BMCE"+uid.randomUUID().toString()+cl.getId());
        compte.setAgent(ag);
        compte.setClient(cl);
        compte.setEtat("Actif");
        Compte compte1 = compteService.addCompte(compte);
        return new ResponseEntity<>(compte1,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Compte> updateCompte(@RequestBody Compte cpte){
        Compte compte =compteService.findCompteById(cpte.getId());
        compte.setSolde(compte.getSolde()+cpte.getSolde());
        compte.setId("BMCEac95f62b-f615-46fe-aa73-bbc325a7e1a030");
        Compte compte1 = compteService.updateCompte(compte);
        return new ResponseEntity<>(compte1,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCompte(@PathVariable("id") Long id){
        compteService.deleteCompteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/virement/recu/{id}")
    public ResponseEntity<List<Virement>> getVirementsRecus (@PathVariable("id") String id){
        List<Virement> virRecus = compteService.findVirementsRecus(id);
        return new ResponseEntity<>(virRecus,HttpStatus.OK);
    }

    @GetMapping("/find/virement/envoye/{id}")
    public ResponseEntity<List<Virement>> getVirementsEnvoyés (@PathVariable("id") String id){
        List<Virement> virEnv = compteService.findVirementsEnvoyés(id);
        return new ResponseEntity<>(virEnv,HttpStatus.OK);
    }
}
