package ma.uca.ensas.ebanking.ebanking.Controllers;

import ma.uca.ensas.ebanking.ebanking.models.Agent;
import ma.uca.ensas.ebanking.ebanking.models.Client;
import ma.uca.ensas.ebanking.ebanking.services.AgentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/agent")
public class AgentResource {

    private final AgentService agentService;

    public AgentResource(AgentService agentService) {
        this.agentService = agentService;
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Agent> getClientById (@PathVariable("id") Long id){
        Agent agent = agentService.findAgentById(id);
        return new ResponseEntity<>(agent,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Agent>> getAllAgents(){
        List<Agent> l = agentService.findAllAgents();
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Agent> addAgent(@RequestBody Agent agent){
        Agent agent1 = agentService.addAgent(agent);
        return new ResponseEntity<>(agent1,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Agent> updateAgent(@RequestBody Agent agent){
        Agent agent1 = agentService.updateAgent(agent);
        return new ResponseEntity<>(agent1,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAgent(@PathVariable("id") Long id){
        agentService.deleteAgent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
