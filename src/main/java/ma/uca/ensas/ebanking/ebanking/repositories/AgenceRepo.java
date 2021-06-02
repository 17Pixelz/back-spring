package ma.uca.ensas.ebanking.ebanking.repositories;

import ma.uca.ensas.ebanking.ebanking.models.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin("*")
public interface AgenceRepo extends JpaRepository<Agence,Long> {
    Optional<Agence> findAgenceById(Long id);

    void deleteAgenceById(Long id);
}
