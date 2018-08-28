package model;

import java.io.Serializable;
import java.util.Objects;

public class CountryLanguageKeyId implements Serializable {
    //encja do robienia klucza złozonego

    private String countryCode;
    private Country language;


    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Country getLanguage() {
        return language;
    }

    public void setLanguage(Country language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryLanguageKeyId that = (CountryLanguageKeyId) o;
        return Objects.equals(countryCode, that.countryCode) &&
                Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {

        return Objects.hash(countryCode, language);
    }
}
