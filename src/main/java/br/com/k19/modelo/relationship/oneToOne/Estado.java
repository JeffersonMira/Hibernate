package br.com.k19.modelo.relationship.oneToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Estado {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	//Neste caso, não vão ser criados dois relacionamentos one to one entre governador e estado, 
	//e sim apenas um relacionamento, sendo que apenas a tabela estado vai ter uma referência ao id 
	//do do governador. A tabela do governador não vai ter o ID do estado. 
	//Existe apenas um relacionamento, mesmo que ambos os objetos tenham acesso aos outros objetos. 
	@OneToOne(mappedBy="estado")
	private Governador governador;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Governador getGovernador() {
		return governador;
	}

	public void setGovernador(Governador governador) {
		this.governador = governador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
