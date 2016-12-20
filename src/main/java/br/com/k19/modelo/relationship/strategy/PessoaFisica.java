package br.com.k19.modelo.relationship.strategy;

import javax.persistence.Entity;

@Entity
public class PessoaFisica extends PessoaStrategy{

	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
