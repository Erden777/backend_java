package KinoPoisk.demo.rest;
import KinoPoisk.demo.entities.Actors;
import KinoPoisk.demo.entities.Country;
import KinoPoisk.demo.entities.Genre;
import KinoPoisk.demo.entities.Movies;
import KinoPoisk.demo.models.MovieListModel;
import KinoPoisk.demo.services.ActorService;
import KinoPoisk.demo.services.CountryService;
import KinoPoisk.demo.services.GenreService;
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

    @Autowired
    private ActorService actorService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private GenreService genreService;

    @GetMapping(value = "/allMovies")
    public ResponseEntity<?> allMovies(){
        List<Movies> movies = movieService.getAllMovies();
        List<Actors> actors = actorService.getAllActors();
        List<Genre> genres = genreService.getAllGenre();
        List<Country> countries = countryService.getAllCountries();
        MovieListModel movieListModel = new MovieListModel(movies, actors, genres, countries);
        System.out.println(movieListModel);
        return new ResponseEntity<>(movieListModel, HttpStatus.OK);
    }
    @GetMapping(value = "/getMovie/{id}")
    public ResponseEntity<?> getMovie(@PathVariable(name = "id")Long id){
        Movies movie = movieService.getMovie(id);
        return ResponseEntity.ok(movie);
    }

    @PostMapping(value = "/saveMovie")
    public ResponseEntity<?> addGenre(@RequestBody Movies movie){
        System.out.println(movie);
        movieService.addMovie(movie);
        return ResponseEntity.ok(movie);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> delete(@RequestBody Movies movie){
        movieService.deleteMovie(movie);
        return ResponseEntity.ok(movie.getId());
    }
}
