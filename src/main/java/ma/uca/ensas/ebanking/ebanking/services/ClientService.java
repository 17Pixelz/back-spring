package ma.uca.ensas.ebanking.ebanking.services;

import ma.uca.ensas.ebanking.ebanking.exceptions.ClientNotFoundException;
import ma.uca.ensas.ebanking.ebanking.models.Client;
import ma.uca.ensas.ebanking.ebanking.repositories.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepo clientRepo;

    @Autowired
    public ClientService(ClientRepo clientRepository) {
        this.clientRepo = clientRepository;
    }

    public Client addClient(Client client){
        return clientRepo.save(client);
    }

    public List<Client> findAllClients(){
        return clientRepo.findAll();
    }

    public Client updateClient(Client client){
        return clientRepo.save(client);
    }

    public Client findClientById(Long id){
        return clientRepo.findClientById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client with " + id + " does not exist :("));
    }

    public void deleteClient(Long id){
        clientRepo.deleteClientById(id);
    }
}
