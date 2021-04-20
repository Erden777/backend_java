package KinoPoisk.demo.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="t_actors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "picture_url")
    private String picture_url;

    @Column(name = "age")
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;

    @Column(name = "full_name")
    private String full_name;
}
