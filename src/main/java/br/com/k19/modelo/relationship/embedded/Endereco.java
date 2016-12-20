package br.com.k19.modelo.relationship.embedded;

import javax.persistence.Embeddable;

//@Entity
@Embeddable 
public class Endereco {

//	Como é uma entidade que não serve para criar uma tabela, e sim fazer parte de outra, não existe ID.
//	@Id @GeneratedValue
//	private Long id;

	private String pais;
	
	private String estado;
	
	private String cidade;
	
	private String logradouro;
	
	private int numero;
	
	private String complemento;
	
	private int cep;

	public Endereco() {
		super();
	}
	
	public Endereco(String pais, String estado, String cidade, String logradouro, int numero, String complemento,
			int cep) {
		super();
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}
	
}
