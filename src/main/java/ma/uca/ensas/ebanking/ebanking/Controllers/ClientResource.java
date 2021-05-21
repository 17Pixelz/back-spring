package ma.uca.ensas.ebanking.ebanking.Controllers;


import ma.uca.ensas.ebanking.ebanking.models.Client;
import ma.uca.ensas.ebanking.ebanking.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
public class ClientResource {

    private final ClientService clientService;

    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
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

@PostMapping("/add")        
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        Client client1 = clientService.addClient(client);
        return new ResponseEntity<>(client1,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Client> updateClient(@RequestBody Client client){
        Client client1 = clientService.updateClient(client);
        return new ResponseEntity<>(client1,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable("id") Long id){
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
