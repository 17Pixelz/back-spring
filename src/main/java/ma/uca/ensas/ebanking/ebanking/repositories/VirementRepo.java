package ma.uca.ensas.ebanking.ebanking.repositories;

import ma.uca.ensas.ebanking.ebanking.models.Virement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")



public interface VirementRepo extends JpaRepository<Virement,Long> {
    void deleteVirementById(Long id);

    Optional<Virement> findVirementById(Long id);
}
