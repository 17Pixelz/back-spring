package ma.uca.ensas.ebanking.ebanking.Controllers;

import ma.uca.ensas.ebanking.ebanking.models.Siege;
import ma.uca.ensas.ebanking.ebanking.services.SiegeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class SiegeResource {
    private final SiegeService siegeService;

    public SiegeResource(SiegeService siegeService) {
        this.siegeService = siegeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Siege>> getAllSieges(){
        List<Siege> l = siegeService.findAllSieges();
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Siege> addSiege(@RequestBody Siege siege){
        Siege siege1 = siegeService.addSiege(siege);
        return new ResponseEntity<>(siege1,HttpStatus.OK);
    }
}
