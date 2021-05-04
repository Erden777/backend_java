package KinoPoisk.demo.models;

import KinoPoisk.demo.entities.Actors;
import KinoPoisk.demo.entities.Country;
import KinoPoisk.demo.entities.Genre;
import KinoPoisk.demo.entities.Movies;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieListModel implements Serializable {
    private static final long serialVersionUID = 123456789L;

    private List<Movies> movies;
    private List<Actors> actors;
    private List<Genre> genres;
    private List<Country> countries;

}
