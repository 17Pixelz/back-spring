package ma.uca.ensas.ebanking.ebanking.repositories;

import ma.uca.ensas.ebanking.ebanking.models.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepo extends JpaRepository<Compte,Long> {
}
