package repository;


import model.Country;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


public class CountryRepository implements ICountryRepository{

    private EntityManagerFactory managerFactory;
    private EntityManager entityManager;

    public CountryRepository() {
        managerFactory = Persistence.createEntityManagerFactory("examplePersistenceUnit");
        entityManager = managerFactory.createEntityManager();
    }

    @Override
    public List<Country> findMediumCountry(int min, int max) {
        List<Country> country = new ArrayList<>();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createQuery("SELECT co from Country co WHERE co.population between :min and :max");
            query.setParameter("min", min);
            query.setParameter("max", max);
            country= query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
        return  country;
    }

    @Override
    public Country findCountryToCity(String city) {
        Country country = new Country();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createQuery("SELECT co from Country co INNER JOIN co.cities l where l.name = :name");
            query.setParameter("name",city);
            country = (Country) query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
        return country;
    }

    @Override
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

    @Override
    public List<Country> showAllCountries() {
        List<Country> countries = new ArrayList<>();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("County.findAll");
            countries = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
        return countries;
    }

    @Override
    public Country findTheBiggestSurfaceArea() {
        Country surface = null;
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<Country> typedQuery = entityManager.createNamedQuery("findTheBiggestSurfaceArea", Country.class);
            surface = typedQuery.getResultList().get(0);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
        return surface;
    }

    @Override
    public Double findAvgLifeExpectancyInEurope() {
        Double result = null;
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("findAvgLifeExpectancyInEurope");
            result = (Double) query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
        return result;
    }

    @Override
    public List<Country> findAllWithOfficialEnglish() {
        List<Country> countries = new ArrayList<>();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("findAllWithOfficialEnglish");
            countries = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
        return countries;
    }




    @Override
    public Country findCountryTheBiggestSurfaceArea(Integer integer) {
        Country country = new Country();
        Double surface =  Double.valueOf(integer);
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            String query = "SELECT co from Country co  where co.surfaceArea = :surface";
            TypedQuery<Country> typedQuery = entityManager.createQuery(query,Country.class);
            typedQuery.setParameter("surface",surface);
            country = typedQuery.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
        return country;
    }
}
