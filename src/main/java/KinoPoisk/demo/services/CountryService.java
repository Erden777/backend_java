package KinoPoisk.demo.services;

import KinoPoisk.demo.entities.Actors;
import KinoPoisk.demo.entities.Country;

import java.util.List;

public interface CountryService {

    List<Country> getAllCountries();

    Country addCountry(Country country);
    Country getCountry(Long id);
    void deleteCountry(Country country);
}
