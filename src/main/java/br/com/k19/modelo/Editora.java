package br.com.k19.modelo;

import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="Editora")
public class Editora {
	
	@Id 
	@GeneratedValue  //Gera a chave primaria automaticamente (Basicamente o autoincrement)
	private Long id;
	
//	POSSÍVEIS VALORES PARA AS RESTRIÇÕES
//	length Limita a quantidade de caracteres de uma string
//	nullable Determina se o campo pode possuir valores null ou não
//	unique Determina se uma coluna pode ter valores repetidos ou não
//	precision Determina a quantidade de dígitos de umnúmero decimal a serem armazenadas
//	scale Determina a quantidade de casas decimais de um número decimal
	@Column(name="name", length=250, nullable=false, unique=true)
	private String name;

    /*Declara que este tipo de dados será provavelmente carregado apenas quando necessário.*/
	@Basic(fetch = FetchType.LAZY)
	private String email;
	
	@ElementCollection //cria uma tablea chamada editora_telefones por default
	@CollectionTable(
			name="editora_telefone",					//customiza a nova tabela criada com este nome
			joinColumns=@JoinColumn(name="edit_id")		//nesta nova tabela, o campo de ligação terá este nome
			)
	@Column(name="telefones")
	private Collection<String> telefones;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Collection<String> telefones) {
		this.telefones = telefones;
	}
	
}

