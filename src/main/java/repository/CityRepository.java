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
            Query query = entityManager.createQuery("select cit from City cit INNER JOIN cit.countryCode c where c.name = :name");
            query.setParameter("name",district);
            city = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
        return city;
    }

    @Override
    public City findCountryToCountry(String country) {
        City city = new City();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createQuery("select cit from City cit INNER JOIN cit.countryCode c where c.name = :name");
            //lub inaczej bez rzutowania
            //TypedQuery<City> query2 = entityManager.createQuery("select cit from City cit INNER JOIN cit.countryCode c where c.name = :name",City.class);
            query.setParameter("name",country);
            city = (City) query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
        return city;
    }

    @Override
    public List<City> findCityToOfficialLanguage(String language) {
        List<City> cities = new ArrayList<>();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createQuery("select cit from City cit INNER JOIN cit.languages l where l.name = :name");
            query.setParameter("name",language);
            cities = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
        return cities;
    }
}
