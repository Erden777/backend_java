package KinoPoisk.demo.services.impl;

import KinoPoisk.demo.entities.Genre;
import KinoPoisk.demo.repositories.GenreRepository;
import KinoPoisk.demo.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;
    @Override
    public List<Genre> getAllGenre() {
        return genreRepository.findAll();
    }

    @Override
    public Genre addGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Genre getGenre(Long id) {
        return genreRepository.findById(id).get();
    }

    @Override
    public void deleteGenre(Genre genre) {
        genreRepository.delete(genre);
    }
}
