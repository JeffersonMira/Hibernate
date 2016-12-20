package br.com.k19.modelo.relationship.oneToMany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Departamento {

	@Id @GeneratedValue
	private Long id;

	/*Neste caso, caso um departamento seja deletado, todos os funcionários ligados a ele também serão.
	* Não é necessário marcar cascadetype=remove se já estiver com o orphan removal.*/
	@OneToMany(orphanRemoval = true)		//Cria automágicamente uma join_table, no caso Departamento_funcion
	@JoinTable(							
			name="DEP_FUNC",								//Alterando o nome da table
			joinColumns=@JoinColumn(name="DEP_ID"),			//Muda a coluna de join 			
			inverseJoinColumns=@JoinColumn(name="FUNC_ID"))	
	private Collection<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Collection<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
}
