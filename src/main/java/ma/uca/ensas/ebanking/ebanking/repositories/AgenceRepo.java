package ma.uca.ensas.ebanking.ebanking.repositories;

import ma.uca.ensas.ebanking.ebanking.models.Agence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgenceRepo extends JpaRepository<Agence,Long> {
    Optional<Agence> findAgenceById(Long id);

    void deleteAgenceById(Long id);
}
