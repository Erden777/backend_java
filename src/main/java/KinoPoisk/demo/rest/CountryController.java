package KinoPoisk.demo.rest;


import KinoPoisk.demo.entities.Country;
import KinoPoisk.demo.repositories.CountryRepository;
import KinoPoisk.demo.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping(value = "/allcountries")
    public ResponseEntity<?> getAllCountries(){
        List<Country> countries = countryService.getAllCountries();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }
//
//    @GetMapping(value = "/getTasks/{id}")
//    public ResponseEntity<?> getTasks(@PathVariable(name = "id")Long id){
//        List<CardTasks> cardTasks = cardTaskService.getTasksbycardId(id);
//        return new ResponseEntity<>(cardTasks, HttpStatus.OK);
//    }
//
//    @GetMapping(value = "/getCard/{id}")
//    public ResponseEntity<?> getCard(@PathVariable(name = "id")Long id){
//        Cards cards = cardService.getOneCard(id);
//        return ResponseEntity.ok(cards);
//    }

}
