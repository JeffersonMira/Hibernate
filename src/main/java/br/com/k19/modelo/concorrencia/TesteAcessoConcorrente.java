package br.com.k19.modelo.concorrencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

/**
 * Created by jeffersonMira on 09/11/2016.
 */
public class TesteAcessoConcorrente{
    public static void main(String[]args){
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("K21_entity_manager_pu");

        EntityManager manager1=factory.createEntityManager();
        EntityManager manager2=factory.createEntityManager();

        manager1.getTransaction().begin();
        manager2.getTransaction().begin();

        Conta conta1=manager1.find(Conta.class,1L, LockModeType.PESSIMISTIC_WRITE);

        conta1.setSaldo(conta1.getSaldo()+500);

        Conta conta2=manager2.find(Conta.class,1L);

        conta2.setSaldo(conta2.getSaldo()-500);

        manager1.getTransaction().commit();
        manager2.getTransaction().commit();

        manager1.close();
        manager2.close();
        factory.close();
    }
}