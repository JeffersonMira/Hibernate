package br.com.k19.modelo.relationship.embedded;

import java.util.Calendar;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pessoa {

	@Id @GeneratedValue
	private Long id;
	
	private String nome;
	
	@Temporal(TemporalType.DATE) //Isto é utilizado para formatar a data que será arquivada
	private Calendar nascimento;
	
//	@OneToOne  //Como esta entidade faz parte da tabela pessoa, não existe relacionamento
//	É possível marcar a variavel com a anotação @Embedded, mas como a entidade já foi marcada com esta anotação
//	Acaba não sendo necessário.
	@Embedded
	private Endereco endereco;

	public Pessoa() {
		super();
	}
	
	public Pessoa(String nome, Calendar nascimento, Endereco endereco) {
		super();
		this.nome = nome;
		this.nascimento = nascimento;
		this.endereco = endereco;
	}

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

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
