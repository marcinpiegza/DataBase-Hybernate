package repository;


import model.City;
import model.Country;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class CityRepository implements ICityRepository {

    private EntityManagerFactory managerFactory;
    private EntityManager entityManager;

    public CityRepository() {
        managerFactory = Persistence.createEntityManagerFactory("examplePersistenceUnit");
        entityManager = managerFactory.createEntityManager();
    }


    @Override
    public List<City> findCityToDistrict(String district) {
        List<City> city = new ArrayList<>();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            String query = ("select cit from City cit where cit.district = :name");
            TypedQuery<City> typedQuery = entityManager.createQuery(query,City.class);
            typedQuery.setParameter("name",district);
            city = typedQuery.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
        return city;
    }

    @Override
    public List<City> findCountryToCountry(String country) {
        List<City> cities = new ArrayList<>();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            String query = ("select cit from City cit INNER JOIN cit.countryCode c where c.name = :name");
            TypedQuery<City> typeQuery = entityManager.createQuery(query,City.class);
            typeQuery.setParameter("name",country);
            cities = typeQuery.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
        return cities;
    }

    @Override
    public List<City> findCityToOfficialLanguage(String language) {
        List<City> cities = new ArrayList<>();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            String query = ("select c from City c INNER JOIN c.countryCode cc INNER JOIN cc.languages ccc where ccc.language = :name");
            TypedQuery<City> typedQuery = entityManager.createQuery(query,City.class);
            typedQuery.setParameter("name",language);
            cities = typedQuery.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
        return cities;
    }

    public List<Country> findCountryOnLanguage(String language){
        List<Country> languages = new ArrayList<>();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            String query = ("select co from Country co INNER JOIN co.languages l where l.language = :name");
            TypedQuery<Country> typedQuery = entityManager.createQuery(query, Country.class);
            typedQuery.setParameter("name", language);
            languages = typedQuery.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
        return languages;
    }
}
