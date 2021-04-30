package KinoPoisk.demo.services.impl;
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
    public Movies addMovie(Movies movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movies getMovie(Long id) {
        return movieRepository.findById(id).get();
    }

    @Override
    public void deleteMovie(Movies movie) {
        movieRepository.delete(movie);
    }
}
