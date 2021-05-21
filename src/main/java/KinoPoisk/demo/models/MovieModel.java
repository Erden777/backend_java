package KinoPoisk.demo.models;

import KinoPoisk.demo.entities.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieModel implements Serializable {
    private static final long serialVersionUID = 123456789L;
    private Long id;
    private String name;
    private String description;
    private String income;
    private String url_video;
    private String picture_3;
    private String large_picture;
    private String small_picture;
    private String producer;
    private String director;
    private Country country;
    private double rating;
    private List<Rating_Movie> rating_movies;
    private List<Actors> actors;
    private List<Genre> genres;
    private Date year;
    private List<Movies> similar_products;
}
