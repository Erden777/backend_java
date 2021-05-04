package KinoPoisk.demo.models;

import KinoPoisk.demo.entities.Actors;
import KinoPoisk.demo.entities.Country;
import KinoPoisk.demo.entities.Genre;
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

    private String name;
    private String description;
    private String income;
    private String url_video;
    private String picture_url;
    private String large_pictureUrl;
    private String small_picture_url;
    private Country country;
    private List<Actors> actors;
    private List<Genre> genres;
    private Date year;
}
