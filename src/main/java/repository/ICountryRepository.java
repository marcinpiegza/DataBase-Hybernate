package repository;

import model.City;
import model.Country;

import java.util.List;

public interface ICountryRepository {

    List<Country> findMediumCountry(int min, int max);

    Country findCountryToCity(String City) ;

    List<Country> findCountryOnLanguage(String language);
}
