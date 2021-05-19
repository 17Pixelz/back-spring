package ma.uca.ensas.ebanking.ebanking.services;

import ma.uca.ensas.ebanking.ebanking.exceptions.AgenceNotFoundException;
import ma.uca.ensas.ebanking.ebanking.exceptions.AgentNotFoundException;
import ma.uca.ensas.ebanking.ebanking.models.Agence;
import ma.uca.ensas.ebanking.ebanking.models.Agent;
import ma.uca.ensas.ebanking.ebanking.repositories.AgentRepo;

import java.util.List;

public class AgentService {
    private final AgentRepo agentRepo;
    AgentService(AgentRepo repo){
        this.agentRepo = repo;
    }
        public Agent addAgent(Agent agent){
            return agentRepo.save(agent);
        }

        public List<Agent> findAllAgents(){
            return agentRepo.findAll();
        }

        public Agent updateAgent(Agent agent){
            return agentRepo.save(agent);
        }

        public Agent findAgentById(Long id){
            return agentRepo.findAgentById(id).orElseThrow(()-> new AgentNotFoundException("Agent " + id + " Not Found"));
        }

        public void deleteAgent(Long id){
            agentRepo.deleteAgentById(id);
        }
    }

