package KinoPoisk.demo.rest;
import KinoPoisk.demo.entities.Movies;
import KinoPoisk.demo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/allMovies")
    public ResponseEntity<?> allMovies(){
        List<Movies> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    @GetMapping(value = "/getMovie/{id}")
    public ResponseEntity<?> getMovie(@PathVariable(name = "id")Long id){
        Movies movie = movieService.getMovie(id);
        return ResponseEntity.ok(movie);
    }

    @PostMapping(value = "/saveMovie")
    public ResponseEntity<?> addGenre(@RequestBody Movies movie){
        movieService.addMovie(movie);
        return ResponseEntity.ok(movie);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> delete(@RequestBody Movies movie){
        movieService.deleteMovie(movie);
        return ResponseEntity.ok(movie.getId());
    }


}
