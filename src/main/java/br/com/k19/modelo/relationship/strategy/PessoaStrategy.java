package br.com.k19.modelo.relationship.strategy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * SINGLE_TABLE
 * Neste caso apenas uma tabela será criada, com todos os campos das tabelas que herdam. 
 * Um campo será criado com o nome DTYPE para saber de qual objeto foi criado. 
 * O problema é que muito espaço é disperdiçado. 
 * 
 * JOINED
 * Cria uma tabela para cada classe da hierarquia, sendo que as tabelas filhas tem um id (FK) que liga com 
 * a classe (tabela) pai.
 * Utiliza menos memória, porém as consultas são mais lentas
 * 
 * TABLE_PER_CLASS
 * Cria uma tabela para cada classe, mas os campos da classe pai são simplesmente copiados para as classes filhas.
 * Não existe um link entre as tabelas pai e filha, sendo que cada tabela funciona de forma única. 
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class PessoaStrategy {
	
	@Id @GeneratedValue
	private Long id;
	
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
