package com.github.molodtsov.russianRoulette.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;


public class UpdateDAOImpl<T> {
    protected  EntityManager em;

    public UpdateDAOImpl(EntityManager em) {
        this.em = em;
    }

    public void updatePersist(T obj) {
        em.getTransaction().begin();
        try {
            em.persist(obj);
            em.getTransaction().commit();

        } catch (PersistenceException e){
            em.getTransaction().rollback();
            throw e;

        }

    }
}
