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
                    //TODO
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
                    //TODO
                    OptionView.CountryAskAboutCity();
                    String city = sc.next();
                    Country country = new Country();
                    country = countryRepository.findCountryToCity(city);
                    country.getName().toString();
                    System.out.println(country.getName());
                    MenuView.separator();
                    state = State.INIT;
                    break;
                }

                //city option
                case FOUROPTION: {
                    //TODO
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
                    //TODO
                    MenuView.separator();
                    state = State.INIT;
                    break;
                }

                case SIXOPTION: {
                    //TODO
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
                    //TODO
                    MenuView.separator();
                    state = State.INIT;
                    break;
                }

                case EIGHTOPTION: {
                    //TODO
                    MenuView.separator();
                    state = State.INIT;
                    break;
                }

                case NINEOPTION: {
                    //TODO
                    MenuView.separator();
                    state = State.INIT;
                    break;
                }

                case TENOPTION: {
                    //TODO
                    MenuView.separator();
                    state = State.INIT;
                    break;
                }

            }

        }


//countryRepository.findCountryOnLanguage();
        // countryRepository.findCountryToCity();

    }
}


