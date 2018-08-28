package model;

import javax.persistence.*;


@Entity
@IdClass(CountryLanguageKeyId.class)
public class CountryLanguage {

    @Id
    @ManyToOne
    @JoinColumn(name = "countryCode")
    private Country countryCode;

    @Id
    private String language;


    private CountryLanguageEnum isOfficial;

    @Column(nullable = false)
    private Float percentage;




    public Country getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Country countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public CountryLanguageEnum getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(CountryLanguageEnum isOfficial) {
        this.isOfficial = isOfficial;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }
}
