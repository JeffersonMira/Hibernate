package br.com.k19.modelo.relationship.oneToMany;

import br.com.k19.modelo.relationship.oneToOne.Governador;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@EntityListeners(Governador.class) //It makes this same class uses the callback methods of the other class.
public class Funcionario {

	@Id @GeneratedValue
	private Long id;
	
	private String nome;

	public Funcionario(String nome) {
		this.nome = nome;
	}

	public Funcionario(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
