package ma.uca.ensas.ebanking.ebanking.repositories;

import ma.uca.ensas.ebanking.ebanking.models.Virement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VirementRepo extends JpaRepository<Virement,Long> {
}
