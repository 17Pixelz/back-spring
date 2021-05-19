package ma.uca.ensas.ebanking.ebanking.repositories;

import ma.uca.ensas.ebanking.ebanking.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Long> {
}
