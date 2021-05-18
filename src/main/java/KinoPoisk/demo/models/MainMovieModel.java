package KinoPoisk.demo.models;

import KinoPoisk.demo.entities.Genre;
import KinoPoisk.demo.entities.Movies;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainMovieModel implements Serializable {
    private static final long serialVersionUID = 123456789L;
    private List<Movies> popular_movies;
    private List<Movies> serials;
    private List<Movies> new_movie;
    private List<Genre> genres;
    private Movies last_movie;


}

