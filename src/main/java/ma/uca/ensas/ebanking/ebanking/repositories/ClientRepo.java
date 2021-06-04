package ma.uca.ensas.ebanking.ebanking.repositories;

import ma.uca.ensas.ebanking.ebanking.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin("*")
public interface ClientRepo extends JpaRepository<Client, Long> {
    void deleteClientById(Long id);

    Optional<Client> findClientById(Long id);
}
