package br.com.k19.modelo.concorrencia;

import br.com.k19.modelo.Editora;
import com.jefferson.Hibernate.GerarTabelas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

/**
 * Created by jeffersonMira on 09/11/2016.
 */
public class AdicionaConta {
    public static void main(String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_livraria_pu");
        EntityManager manager = factory.createEntityManager();   //Este é o cara que controla todas as transações.

        Conta c = new Conta();
        c.setSaldo(new Double(2000));
        manager.persist(c);

        manager.close();
        factory.close();
    }

}
