package com.example.demospringjpa.repository;

import com.example.demospringjpa.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class PersonRepository {

    @Autowired
    private EntityManager sessionFactory;

    public List<Person> get() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sessionFactory.createQuery("from Person", Person.class).getResultList();
    }
}
