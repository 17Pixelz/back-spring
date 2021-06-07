package ma.uca.ensas.ebanking.ebanking.repositories;

import ma.uca.ensas.ebanking.ebanking.models.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompteRepo extends JpaRepository<Compte,Long> {
    void deleteCompteById(Long id);

    Optional<Compte> findCompteById(Long id);
}
