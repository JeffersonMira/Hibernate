package br.com.k19.modelo.ConsultaNativa7;

import br.com.k19.modelo.Autor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by jeffersonMira on 17/11/2016.
 */
public class Main {

    public static void main(String[] args){
        EntityManagerFactory factory  = Persistence.createEntityManagerFactory("K21_livraria_pu");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM autor";

        Query nativeQuery = manager.createNativeQuery(sql, Autor.class);

        List<Autor> list = nativeQuery.getResultList();

        for (Autor aut : list) {
            System.out.print(aut);
        }

    }
}
