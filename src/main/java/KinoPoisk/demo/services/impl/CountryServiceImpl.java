package KinoPoisk.demo.services.impl;

import KinoPoisk.demo.entities.Country;
import KinoPoisk.demo.repositories.CountryRepository;
import KinoPoisk.demo.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country getCountry(Long id) {
        return countryRepository.findById(id).get();
    }

    @Override
    public void deleteCountry(Country country) {
        countryRepository.delete(country);
    }
}
