package KinoPoisk.demo.rest;
import KinoPoisk.demo.entities.Actors;
import KinoPoisk.demo.entities.Country;
import KinoPoisk.demo.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping(value = "/allcountries")
    public ResponseEntity<?> getAllCountries(){
        List<Country> countries = countryService.getAllCountries();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }
    @GetMapping(value = "/getCountry/{id}")
    public ResponseEntity<?> getActor(@PathVariable(name = "id")Long id){
        Country country = countryService.getCountry(id);
        return ResponseEntity.ok(country);
    }

    @PostMapping(value = "/saveActor")
    public ResponseEntity<?> addCountry(@RequestBody Country country){
        countryService.addCountry(country);
        return ResponseEntity.ok(country);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> delete(@RequestBody Country country){
        System.out.println(country);
        countryService.deleteCountry(country);
        return ResponseEntity.ok(country.getId());
    }

}
