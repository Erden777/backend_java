package KinoPoisk.demo.rest;

import KinoPoisk.demo.entities.Actors;
import KinoPoisk.demo.entities.Country;
import KinoPoisk.demo.models.ActorsModel;
import KinoPoisk.demo.services.ActorService;
import KinoPoisk.demo.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/actor")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @Autowired
    private CountryService countryService;

    @GetMapping(value = "/allActors")
    public ResponseEntity<?> getAllActors(){
        System.out.println("all actors");
        List<Actors> actors = actorService.getAllActors();
        System.out.println(actors);
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }

    @GetMapping(value = "/getActor/{id}")
    public ResponseEntity<?> getActor(@PathVariable(name = "id")Long id){
        List<Country> countries = countryService.getAllCountries();
        Actors actors = actorService.getActor(id);

        ActorsModel actorsModel = new ActorsModel(actors.getId(),actors.getFull_name(), actors.getPicture_url(), actors.getAge(), actors.getCountry(), countries);
        System.out.println(actorsModel);
        return ResponseEntity.ok(actorsModel);
    }

    @PostMapping(value = "/saveActor")
    public ResponseEntity<?> addcard(@RequestBody Actors actors){
        System.out.println("save actor");
        System.out.println(actors);
        actorService.addActors(actors);
        return ResponseEntity.ok(actors);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> delete(@RequestBody Actors actors){
        System.out.println("delete");
        System.out.println(actors);
        actorService.deleteActors(actors);
        return ResponseEntity.ok(actors.getId());
    }
}
