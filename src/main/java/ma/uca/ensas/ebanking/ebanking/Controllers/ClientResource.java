package ma.uca.ensas.ebanking.ebanking.Controllers;


import ma.uca.ensas.ebanking.ebanking.models.Agence;
import ma.uca.ensas.ebanking.ebanking.models.Client;
import ma.uca.ensas.ebanking.ebanking.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
public class ClientResource {
    private final ClientService clientService;
    private final AgenceResource AgenceService;

    public ClientResource(ClientService clientService,AgenceResource AgenceService) {
        this.clientService = clientService;
        this.AgenceService=AgenceService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients(){
        List<Client> l = clientService.findAllClients();
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Client> getClientById (@PathVariable("id") Long id){
        Client client = clientService.findClientById(id);
        return new ResponseEntity<>(client,HttpStatus.OK);
    }

    @PostMapping("/add/{id_agence}")
    public ResponseEntity<Client> addClient(@RequestBody Client client,@PathVariable("id_agence") Long id_agence){
        Agence ag=AgenceService.getAgenceById(id_agence);
        client.agence=ag;
        Client client1 = clientService.addClient(client);
        return new ResponseEntity<>(client1,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Client> updateClient(@RequestBody Client client){
        Client client1 = clientService.updateClient(client);
        return new ResponseEntity<>(client1,HttpStatus.OK);
    }
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable("id") Long id){
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
