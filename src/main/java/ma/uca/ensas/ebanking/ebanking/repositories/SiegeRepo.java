package ma.uca.ensas.ebanking.ebanking.repositories;

import ma.uca.ensas.ebanking.ebanking.models.Siege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin("*")
public interface SiegeRepo extends JpaRepository<Siege,Long> {
    Optional<Siege> findSiegeById(Long id);
    void deleteSiegeById(Long id);
}
