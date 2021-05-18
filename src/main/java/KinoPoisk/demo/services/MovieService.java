package KinoPoisk.demo.services;

import KinoPoisk.demo.entities.Genre;
import KinoPoisk.demo.entities.Movies;

import java.util.List;

public interface MovieService {

    List<Movies> getAllMovies();
    List<Movies> getPopularMovies();
    List<Movies> getNewMovies();
    List<Movies> getMoviesByGenre(Genre genre);
    Movies addMovie(Movies movie);
    Movies getMovie(Long id);
    void deleteMovie(Movies movie);
}
