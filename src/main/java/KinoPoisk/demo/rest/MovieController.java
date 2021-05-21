package KinoPoisk.demo.rest;
import KinoPoisk.demo.entities.Actors;
import KinoPoisk.demo.entities.Country;
import KinoPoisk.demo.entities.Genre;
import KinoPoisk.demo.entities.Movies;
import KinoPoisk.demo.models.MovieListModel;
import KinoPoisk.demo.models.MovieModel;
import KinoPoisk.demo.services.ActorService;
import KinoPoisk.demo.services.CountryService;
import KinoPoisk.demo.services.GenreService;
import KinoPoisk.demo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping(value = "/search/{text}")
    public ResponseEntity<?> search(@PathVariable(name = "text")String text) {
        List<Movies> movies = movieService.search(text);

        return ResponseEntity.ok(movies);
    }
    @GetMapping(value = "/getMovie/{id}")
    public ResponseEntity<?> getMovie(@PathVariable(name = "id")Long id){
        Movies movie = movieService.getMovie(id);
        MovieModel movieModel = new MovieModel();
        List<Movies> similar_movies = new ArrayList<>();
        System.out.println(movie.getGenres().get(0));
        similar_movies = movieService.getMoviesByGenre(movie.getGenres().get(0));
        System.out.println(similar_movies);
        movieModel.setActors(movie.getActors());
        movieModel.setCountry(movie.getCountry());
        movieModel.setGenres(movie.getGenres());
        movieModel.setDescription(movie.getDescription());
        movieModel.setLarge_picture(movie.getLarge_picture());
        movieModel.setPicture_3(movie.getPicture_3());
        movieModel.setSmall_picture(movie.getSmall_picture());
        movieModel.setIncome(movie.getIncome());
        movieModel.setRating(movie.getRating());
        movieModel.setRating_movies(movie.getRating_movies());
        movieModel.setYear(movie.getYear());
        movieModel.setId(movie.getId());
        movieModel.setName(movie.getName());
        movieModel.setProducer(movie.getProducer());
        movieModel.setDirector(movie.getDirector());
        movieModel.setUrl_video(movie.getUrl_video());
        movieModel.setSimilar_products(similar_movies);
        return ResponseEntity.ok(movieModel);
    }

    @GetMapping(value = "/getByGenre{id}")
    public ResponseEntity<?> getByGenre(@PathVariable(name = "id")Long id){
        Genre genre = genreService.getGenre(id);
        List<Movies> movies = movieService.getMoviesByGenre(genre);
        return ResponseEntity.ok(movies);
    }
    @PostMapping(value = "/saveMovie")
    public ResponseEntity<?> addGenre(@RequestBody Movies movie){
        System.out.println(movie.getRating());
        movieService.addMovie(movie);
        return ResponseEntity.ok(movie);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> delete(@RequestBody Movies movie){
        movieService.deleteMovie(movie);
        return ResponseEntity.ok(movie.getId());
    }
}
