package ma.uca.ensas.ebanking.ebanking.services;

import ma.uca.ensas.ebanking.ebanking.models.Client;
import ma.uca.ensas.ebanking.ebanking.repositories.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
