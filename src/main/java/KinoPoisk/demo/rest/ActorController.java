package KinoPoisk.demo.rest;

import KinoPoisk.demo.entities.Actors;
import KinoPoisk.demo.services.ActorService;
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

    @GetMapping(value = "/allActors")
    public ResponseEntity<?> getAllActors(){
        System.out.println("all actors");
        List<Actors> actors = actorService.getAllActors();
        System.out.println(actors);
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }

    @GetMapping(value = "/getActor/{id}")
    public ResponseEntity<?> getActor(@PathVariable(name = "id")Long id){
        Actors actors = actorService.getActor(id);
        return ResponseEntity.ok(actors);
    }

    @PostMapping(value = "/saveActor")
    public ResponseEntity<?> addcard(@RequestBody Actors actors){
        actorService.addActors(actors);
        return ResponseEntity.ok(actors);
    }

    @DeleteMapping(value = "/delete/actor")
    public ResponseEntity<?> delete(@RequestBody Actors actors){
        actorService.deleteActors(actors);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
