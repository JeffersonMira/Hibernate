package br.com.k19.modelo.relationship.strategy;

import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends PessoaStrategy{

	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
}
