package model;

import javax.persistence.*;
import java.util.List;


@NamedQueries({
        @NamedQuery(name = "County.findAll",
                query = "select c from Country c"),
        @NamedQuery(name = "findTheBiggest (SurfaceArea)",
                query = "select max(c.surfaceArea) FROM Country c"),
        @NamedQuery(name = "findAvgLifeExpectancyInEurope",
                query = "select avg (c.surfaceArea) FROM Country c"),
        @NamedQuery(name = ".findAllWithOfficialEnglish ",
                query = "select c FROM Country c INNER JOIN c.languages l where l.isOfficial ='T' AND l.language = 'English'"),
                })

        @Entity
        public class Country{

        @Id
        private String code;

        private String name;

        private String continent;

        private String region;

        private Float surfaceArea;

        @Column(nullable = false)
        private Integer indepYear;

        private Integer population;

        @Column(nullable = false)
        private Float lifeExpectancy;

        @Column(nullable = false)
        private Float gNP;

        @Column(nullable = false)
        private Float gnpOld;

        private String LocalName;

        private String governmentForm;

        @Column(nullable = false)
        private String headOfState;

        @Column(nullable = false)
        private Integer capital;

        @Column(nullable = false)
        private String code2;

        @OneToMany(mappedBy = "countryCode")
        private List<City> cities;

        @OneToMany(mappedBy = "countryCode")
        private List<CountryLanguage>languages;

        public String getCode(){
        return code;
        }

        public void setCode(String code) {
        this.code=code;
        }

public String getName(){
        return name;
        }

public void setName(String name){
        this.name=name;
        }

public String getContinent(){
        return continent;
        }

public void setContinent(String continent){
        this.continent=continent;
        }

public String getRegion(){
        return region;
        }

public void setRegion(String region){
        this.region=region;
        }

public Float getSurfaceArea(){
        return surfaceArea;
        }

public void setSurfaceArea(Float surfaceArea){
        this.surfaceArea=surfaceArea;
        }

public Integer getIndepYear(){
        return indepYear;
        }

public void setIndepYear(Integer indepYear){
        this.indepYear=indepYear;
        }

public Integer getPopulation(){
        return population;
        }

public void setPopulation(Integer population){
        this.population=population;
        }

public Float getLifeExpectancy(){
        return lifeExpectancy;
        }

public void setLifeExpectancy(Float lifeExpectancy){
        this.lifeExpectancy=lifeExpectancy;
        }

public Float getgNP(){
        return gNP;
        }

public void setgNP(Float gNP){
        this.gNP=gNP;
        }

public Float getGnpOld(){
        return gnpOld;
        }

public void setGnpOld(Float gnpOld){
        this.gnpOld=gnpOld;
        }

public String getLocalName(){
        return LocalName;
        }

public void setLocalName(String localName){
        LocalName=localName;
        }

public String getGovernmentForm(){
        return governmentForm;
        }

public void setGovernmentForm(String governmentForm){
        this.governmentForm=governmentForm;
        }

public String getHeadOfState(){
        return headOfState;
        }

public void setHeadOfState(String headOfState){
        this.headOfState=headOfState;
        }

public Integer getCapital(){
        return capital;
        }

public void setCapital(Integer capital){
        this.capital=capital;
        }

public String getCode2(){
        return code2;
        }

public void setCode2(String code2){
        this.code2=code2;
        }
        }
