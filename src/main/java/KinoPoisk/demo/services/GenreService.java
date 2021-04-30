package KinoPoisk.demo.services;

import KinoPoisk.demo.entities.Country;
import KinoPoisk.demo.entities.Genre;

import java.util.List;

public interface GenreService {

    List<Genre> getAllGenre();

    Genre addGenre(Genre genre);
    Genre getGenre(Long id);
    void deleteGenre(Genre Genre);
}
