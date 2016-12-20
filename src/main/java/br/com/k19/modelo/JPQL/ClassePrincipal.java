package br.com.k19.modelo.JPQL;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jeffersonMira on 10/11/2016.
 */
public class ClassePrincipal {

    public static void main(String[]args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_livraria_pu");
        EntityManager manager =factory.createEntityManager();

//        insertAutor(manager);
//        namedQuery(manager);
        namedQueryParameter(manager);

        manager.close();
        factory.close();
    }

    public static void insertAutor(EntityManager manager){
        manager.getTransaction().begin();

        AutorJpql autorJpql = new AutorJpql();
        autorJpql.setName("Eu outro mesmo");

        manager.persist(autorJpql);
        manager.getTransaction().commit();
    }

    public static void queryDinamica(EntityManager manager ){
        /*Esta é uma consulta dinâmica.*/
        String sql = "Select e FROM Editora e";
        Query query = manager.createQuery(sql);
    }

    public static void namedQuery(EntityManager manager){
        Query query = manager.createNamedQuery("AutorJpql.findAll");

        /*TODO verificar o que estes métodos fazem certinho!!*/
        query.setFirstResult(10);
        query.setMaxResults(20);

        List<AutorJpql> autores = query.getResultList();
        for (AutorJpql autor : autores) {
            System.out.println(autor);
        }
    }

    public static void namedQueryParameter(EntityManager manager){
        Query query = manager.createNamedQuery("AutorJpql.findByName", AutorJpql.class); //Define o tipo de retorno esperado.
        query.setParameter("name", "Eu outro mesmo");

        List<AutorJpql> autores = query.getResultList();

        for(AutorJpql autor : autores){
            System.out.println(autor);
        }
    }

    /*Nesta função é retornado apenas o nome do cara. Mas é necessário especificar que eu quero apenas um retorno
    * do tipo String*/
    public static void returningListOfString(EntityManager manager){
        Query query = manager.createQuery("Select a.name From AutorJpql a", String.class);

        List<String> autores = query.getResultList();

        for(String autor : autores){
            System.out.println(autor);
        }
    }


    /* Retorna apenas uma valor do tipo numérico, no caso um Long.*/
    public static void returningSingleResult(EntityManager manager){
        TypedQuery<Long> query = manager.createQuery("Select count(a) From AutorJpql a", Long.class);
        Long numberOfAutors= query.getSingleResult();
    }

    /* Nesca caso é um array de objetos.
    *  Cada linha é retornada em um array.*/
    public static void returningComplexResult(EntityManager manager){

        /**
         * TAmbém é possível passar qual objeto eu quero que ele preencha e de qual forma, direto na pesquisa:
         * String query = " SELECT NEW
         * resultado . FuncionarioDepartamento (f.nome ,f. departamento . nome ) FROM Funcionario f";
         */

        Query query = manager.createQuery("Select a.name, a.id From AutorJpql a");
        List<Object[]> result = query.getResultList();

        for(Object[] array : result){
            System.out.println("Nome : "+array[0]);
            System.out.println("Id : "+array[1]);
        }
    }


}
