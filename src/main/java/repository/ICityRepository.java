package repository;

import model.City;
import model.Country;

import java.util.List;

public interface ICityRepository {

    List<City> findCityToDistrict(String district );

    City findCountryToCountry(String country) ;

    List <City> findCityToOfficialLanguage (String language);

}
