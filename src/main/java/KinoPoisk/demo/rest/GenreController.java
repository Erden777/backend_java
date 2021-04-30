package KinoPoisk.demo.rest;

import KinoPoisk.demo.entities.Genre;
import KinoPoisk.demo.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/genre")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping(value = "/allgenre")
    public ResponseEntity<?> allgenre(){
        List<Genre> genres = genreService.getAllGenre();
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }
    @GetMapping(value = "/getGenre/{id}")
    public ResponseEntity<?> getGenre(@PathVariable(name = "id")Long id){
        System.out.println("Get genre");
        Genre genre = genreService.getGenre(id);
        System.out.println(genre);
        return ResponseEntity.ok(genre);
    }

    @PostMapping(value = "/saveGenre")
    public ResponseEntity<?> addGenre(@RequestBody Genre genre){
        System.out.println(genre);
        genreService.addGenre(genre);
        return ResponseEntity.ok(genre);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> delete(@RequestBody Genre genre){
        genreService.deleteGenre(genre);
        return ResponseEntity.ok(genre.getId());
    }

}
