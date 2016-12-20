package br.com.k19.modelo.caching;

import br.com.k19.modelo.Editora;
import com.jefferson.Hibernate.GerarTabelas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

/*
* Caching é manter uma cópia dos dados para evitar que fique lendo os dados a todos os momentos.
* Todos entity manager tem um 'cache de primeiro nível', que é o Persistence Context.
*
* Caching de segundo nível é habilitado atravéz do <shared-cache-mode> no persistence.xml
*
*/
public class MainCaching {

    public static void main(String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_livraria_pu");
        EntityManager manager = factory.createEntityManager();
        Cidade c = new Cidade();

        c.setNomeDaCidade("Jacarépagua");
        c.setNomeDoEstado("NumSei");

        manager.getTransaction().begin();
        manager.persist(c);
        manager.getTransaction().commit();

        System.out.println("----------------- PRIMEIRO NÍVEL -----------------------");
        Cidade c2 = manager.find(Cidade.class, 1L);
        System.out.println("----------------- SEGUNDO NÍVEL -----------------------");
        Editora e1 = manager.find(Editora.class, 1L);
        /*Testing code here*/

        factory.close();
    }

}
