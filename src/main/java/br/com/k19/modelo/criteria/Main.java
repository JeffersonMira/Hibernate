package br.com.k19.modelo.criteria;

import br.com.k19.modelo.Autor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by jeffersonMira on 17/11/2016.
 */
public class Main {

    public static void main(String[] args){
        EntityManagerFactory factory  = Persistence.createEntityManagerFactory("K21_livraria_pu");
        EntityManager manager = factory.createEntityManager();


        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Autor> criteria = criteriaBuilder.createQuery(Autor.class);

    }
}
