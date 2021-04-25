package KinoPoisk.demo.models;

import KinoPoisk.demo.entities.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorsModel implements Serializable {
    private static final long serialVersionUID = 123456789L;
    private Long id;
    private String full_name;
    private String picture_url;
    private int age;
    private Country country;
    private List<Country> all_countries;
}
