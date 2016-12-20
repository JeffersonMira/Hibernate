package com.jefferson.Hibernate;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.*;

import br.com.k19.modelo.Autor;
import br.com.k19.modelo.Editora;
import br.com.k19.modelo.PeriodoEnum;
import br.com.k19.modelo.Turma;
import br.com.k19.modelo.relationship.embedded.Endereco;
import br.com.k19.modelo.relationship.embedded.Pessoa;
import br.com.k19.modelo.relationship.oneToMany.Departamento;
import br.com.k19.modelo.relationship.oneToMany.Funcionario;
import br.com.k19.modelo.relationship.oneToOne.Estado;
import br.com.k19.modelo.relationship.oneToOne.Governador;
import br.com.k19.modelo.relationship.strategy.PessoaFisica;
import br.com.k19.modelo.relationship.strategy.PessoaJuridica;

public class GerarTabelas {

	/*
	* Existem dois modos de carregar e atualizar as instancias dos objetos, LAZY e EAGER:
	* No LAZY o provedor posterga ao máximo a consulta. No EAGER isso acontece o quanto antes.
	* */
	public static void main(String[] args) {
		 // Este código verifica a conexão definida no persistence.xml e atualiza o db conforme as entities definidas no programa. 
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_livraria_pu");
		EntityManager manager = factory.createEntityManager();   //Este é o cara que controla todas as transações.

		/* As atualizações são feitas automáticamente antes de cada conssulta na base de cados. */
		//manager.setFlushMode(FlushModeType.AUTO);
		/* O comportamento não é especificado, ficando na dependencia de cada provedor
		* especificar como */
		manager.setFlushMode(FlushModeType.COMMIT);

		GerarTabelas g = new GerarTabelas();
//		g.relationshipsStrategy(manager);
//		g.insertOneToOne(manager);
		g.insertAutor(manager);

		factory.close();
	}
	
	public void persistir(EntityManager manager){
		
		manager.getTransaction().begin();
		
		Editora novaEditora = new Editora();
		novaEditora.setName("K19 - Livros");
		novaEditora.setEmail("contato@k19.com.br");

		/*
		* A entity passa do estado NEw para o estado Managed quando a entity é
		* persisted. Antes disso ela não existe no DB.
		* */
		manager.persist(novaEditora);

		/*
		* Remove o objeto do gerenciamento do entityManager.
		*/
		manager.detach(novaEditora);

		/*
		* Remove todos os objetos do entityManager
		*/
		manager.clear();

		/*Atualiza o objeto.*/
		manager.refresh(novaEditora);

		manager.getTransaction().commit(); //commit permanente
//		manager.flush(); //sincroniza parcial
	}
	
	public void buscando(EntityManager manager){
		// Para o find não é necessário abrir transaction.
		//EAGER
		Editora editora1 = manager.find(Editora.class, 1L); 		//Recupera os dados imediatamente
		//LAZY
		Editora editora2 = manager.getReference(Editora.class, 2L);	//posterga o find até o primeiro get ser chamado.
	}
	
	public void remove(EntityManager manager){
		manager.getTransaction().begin();
		
		Editora editora = manager.find(Editora.class,1L);
		manager.remove(editora);
		
		manager.getTransaction().commit();
	}
	
	public void update(EntityManager manager){
		manager.getTransaction().begin();
		
		Editora editora = manager.find(Editora.class,1L);
		//Apenas atualizando a entidade o manager atualiza. 
		editora.setName("K19 - Livros e Publicações "); 
		
		manager.getTransaction().commit();
	}


	//JPQL - Linguagem de banco de dados do JPA
	public void Listing(EntityManager manager){
		Query query = manager.createQuery("SELECT e FROM editora e");
		List<Editora> editoras = query.getResultList();
	}
	
	//*//////
	
	public void insertAutor(EntityManager manager){
		manager.getTransaction().begin();
		
		Autor autor = new Autor();
		autor.setName("Eu mesmo");

		manager.persist(autor);
		manager.getTransaction().commit();
	}
	
	
	public void insertTurma(EntityManager manager){
		manager.getTransaction().begin();
		
		Turma t = new Turma();
		t.setPeriodo(PeriodoEnum.MATUTINO);
		manager.persist(t);
		manager.getTransaction().commit();
	}
	
	public void insertEditora(EntityManager manager){
		manager.getTransaction().begin();
		
		Turma t = new Turma();
		t.setPeriodo(PeriodoEnum.MATUTINO);
		manager.persist(t);
		manager.getTransaction().commit();
	}
	
	public void insertOneToOne(EntityManager manager){
		manager.getTransaction().begin();
		
		Governador g = new Governador();
		
		Estado e = new Estado();
		e.setGovernador(g);
		
		manager.persist(g);
//		manager.persist(e);  Não é necessário, pois o cascade está como como persist na classe Governador

		manager.getTransaction().commit();
	}
	
	public void insertOneToMany(EntityManager manager){
		manager.getTransaction().begin();
		
		Funcionario f = new Funcionario();
		f.setNome("John Constantine");
		
		Departamento d = new Departamento();
		d.getFuncionarios().add(f);
		
		manager.persist(f);
		manager.persist(d);

		manager.getTransaction().commit();
	}
	
	public void embeddedTable(EntityManager manager){
		manager.getTransaction().begin();
		
		Endereco e = new Endereco("Brasil", "Paraná","Curitiba","Barão do Rio Branco", 199,"NA",66666699);
		Pessoa p = new Pessoa("Jack", new GregorianCalendar(), e);
		
		//Se persiste apenas o objeto que é dono, não o objeto "Embedded"
		manager.persist(p);
		
		manager.getTransaction().commit();
	}
	
    public void relationshipsStrategy(EntityManager manager){
    	manager.getTransaction().begin();

		PessoaFisica pf = new PessoaFisica();
		pf.setCpf("06933421961");
		pf.setName("Jefferson da Silva Mira");

		PessoaJuridica pj = new PessoaJuridica();
		pj.setCnpj("06933421961");
		pj.setName("Dog do Tiao");

		manager.persist(pf);
		manager.persist(pj);

		manager.getTransaction().commit();
    }

    /*Atualiza todos os registros de uma vez só. Isso é chamado de bulk update.*/
	public void bulk(EntityManager manager){
		manager.getTransaction().begin();

		Query query = manager.createQuery("UPDATE Editora e SET e.email='this is a new email'");
		query.executeUpdate();

		manager.getTransaction().commit();
	}
}
