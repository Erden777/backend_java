package KinoPoisk.demo.services.impl;
import KinoPoisk.demo.entities.Genre;
import KinoPoisk.demo.entities.Movies;
import KinoPoisk.demo.repositories.MovieRepository;
import KinoPoisk.demo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movies> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movies> getPopularMovies() {
        return movieRepository.findAllByOrderByRatingDesc();
    }

    @Override
    public List<Movies> getNewMovies() {
        return movieRepository.findAllByOrderByYearDesc();
    }

    @Override
    public List<Movies> getMoviesByGenre(Genre genre) {
        return movieRepository.findAllByGenres(genre);
    }

    @Override
    public Movies addMovie(Movies movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movies getMovie(Long id) {
        return movieRepository.findById(id).get();
    }

    @Override
    public List<Movies> search(String name) {
        return movieRepository.findAllByNameContainsOrderByYearDesc(name);
    }

    @Override
    public void deleteMovie(Movies movie) {
        movieRepository.delete(movie);
    }
}
