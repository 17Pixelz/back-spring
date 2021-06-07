package ma.uca.ensas.ebanking.ebanking.repositories;

import ma.uca.ensas.ebanking.ebanking.models.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;
@CrossOrigin("*")
public interface AgentRepo extends JpaRepository<Agent,Long> {
    void deleteAgentById(Long id);
    Optional<Agent> findAgentById(Long id);
}
