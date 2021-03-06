package init;

import View.MenuView;
import View.OptionView;
import model.City;
import model.Country;
import repository.CityRepository;
import repository.CountryRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CityRepository cityRepository = new CityRepository();
        CountryRepository countryRepository = new CountryRepository();
        Scanner sc = new Scanner(System.in);
        State state = State.INIT;

        while (state != State.STOP) {
            switch (state) {
                case INIT: {
                    MenuView.showMenu();
                    String answer = sc.next();
                    switch (answer) {
                        case ("1"): {
                            state = State.ONEOPTION;
                            break;
                        }
                        case ("2"): {
                            state = State.TWOOPTION;
                            break;
                        }
                        case ("3"): {
                            state = State.THREEOPTION;
                            break;
                        }
                        case ("4"): {
                            state = State.FOUROPTION;
                            break;
                        }
                        case ("5"): {
                            state = State.FIVEOPTION;
                            break;
                        }
                        case ("6"): {
                            state = State.SIXOPTION;
                            break;
                        }
                        case ("7"): {
                            state = State.SEVENOPTION;
                            break;
                        }
                        case ("8"): {
                            state = State.EIGHTOPTION;
                            break;
                        }
                        case ("9"): {
                            state = State.NINEOPTION;
                            break;
                        }
                        case ("10"): {
                            state = State.TENOPTION;
                            break;
                        }

                        case ("11"): {
                            state = State.STOP;
                            break;
                        }
                        default:
                            MenuView.showMenuWrontAnswer();
                            state = State.INIT;
                            break;
                    }
                    break;
                }
                //countryOption
                case ONEOPTION: {
                    OptionView.CountryAskAboutRange();
                    OptionView.CountryAskAboutRangeMin();
                    Integer min = sc.nextInt();
                    OptionView.CountryAskAboutRangeMax();
                    Integer max = sc.nextInt();

                    List<Country> country = new ArrayList<>();
                    country = countryRepository.findMediumCountry(min, max);
                    for (Country co : country) {
                        System.out.println(co.getName());
                    }
                    MenuView.separator();
                    state = State.INIT;
                    break;
                }

                case TWOOPTION: {
                    OptionView.CountryAskAboutLanguage();
                    String language = sc.next();

                    List<Country> country = new ArrayList<>();
                    country = countryRepository.findCountryOnLanguage(language);
                    for (Country co : country) {
                        System.out.println(co.getName());
                    }
                    MenuView.separator();
                    state = State.INIT;
                    break;
                }

                case THREEOPTION: {
                    OptionView.CountryAskAboutCity();
                    String city = sc.next();
                    Country country = new Country();
                    country = countryRepository.findCountryToCity(city);
                    System.out.println(country.getName());
                    MenuView.separator();
                    state = State.INIT;
                    break;
                }

                //city option
                case FOUROPTION: {
                    OptionView.CityAskAboutDistrict();
                    String district = sc.next();
                    List<City> city = new ArrayList<>();
                    city = cityRepository.findCityToDistrict(district);
                    for (City cit : city) {
                        System.out.println(cit.getName());
                    }
                    MenuView.separator();
                    state = State.INIT;
                    break;
                }

                case FIVEOPTION: {
                    OptionView.CityAskAboutCoutry();
                    String country = sc.next();
                    List<City> cities = new ArrayList<>();
                    cities = cityRepository.findCountryToCountry(country);
                    for (City cit : cities) {
                        System.out.println(cit.getName());
                    }
                    MenuView.separator();
                    state = State.INIT;
                    break;
                }
                case SIXOPTION: {
                    OptionView.CountryAskAboutLanguage();
                    String language = sc.next();
                    List<City> city = new ArrayList<>();
                    city = cityRepository.findCityToOfficialLanguage(language);
                    for (City cit : city) {
                        System.out.println(cit.getName());
                    }
                    MenuView.separator();
                    state = State.INIT;
                    break;
                }

                case SEVENOPTION: {
                    List<Country> countries = new ArrayList<>();
                    countries = countryRepository.showAllCountries();
                    for (Country con : countries) {
                        System.out.println(con.getName());
                    }
                    MenuView.separator();
                    state = State.INIT;
                    break;
                }

                case EIGHTOPTION: {
                    Country surface = null;
                    surface = countryRepository.findTheBiggestSurfaceArea();
                    Country country = new Country();
                   // country = countryRepository.findCountryTheBiggestSurfaceArea(surface);
                    System.out.println(surface.getName());
                    MenuView.separator();
                    state = State.INIT;
                    break;
                }

                case NINEOPTION: {
                    Double result = null;
                    result = countryRepository.findAvgLifeExpectancyInEurope();
                    System.out.println(result);
                    MenuView.separator();
                    state = State.INIT;
                    break;
                }

                case TENOPTION: {
                    List<Country> countries = new ArrayList<>();
                    countries = countryRepository.findAllWithOfficialEnglish();
                    for (Country con : countries) {
                        System.out.println(con.getName());
                    }
                    MenuView.separator();
                    state = State.INIT;
                    break;
                }
            }

        }
    }
}


