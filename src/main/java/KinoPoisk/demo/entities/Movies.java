package KinoPoisk.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="t_movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "producer")
    private String producer;

    @Column(name = "director")
    private String director;

    @Column(name = "income")
    private String income;

    @Column(name = "small_picture")
    private String small_picture;

    @Column(name = "large_picture")
    private String large_picture;

    @Column(name = "pricture_3")
    private String picture_3;

    @Column(name = "url_video")
    private String url_video;

    @ManyToOne(fetch = FetchType.EAGER)
    private Country country;

    @Column(name = "rating")
    private double rating;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Actors> actors;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Genre> genres;

    @OneToMany
    private List<Rating_Movie> rating_movies;

    @Column(name = "year")
    private Date year;

}
