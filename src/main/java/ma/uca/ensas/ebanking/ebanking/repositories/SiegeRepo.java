package ma.uca.ensas.ebanking.ebanking.repositories;

import ma.uca.ensas.ebanking.ebanking.models.Siege;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SiegeRepo extends JpaRepository<Siege,Long> {
    Optional<Siege> findSiegeById(Long id);
    void deleteSiegeById(Long id);
}
