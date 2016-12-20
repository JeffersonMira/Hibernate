package br.com.k19.modelo.relationship.oneToOne;

import javax.persistence.*;

@Entity
public class Governador {

	@Id @GeneratedValue
	private Long id;
	
	private String nome;

    //https://rafaelsakurai.gitbooks.io/desenvolvimento-distribuido/content/chapter2.2.html
    /*    Tipos de cascade :
        PERSIST – Quando salvar a Entidade A, também será salvo todas as Entidades B associadas.
        MERGE – Quando atual as informações da Entidade A, também será atualizado no banco de dados todas as informações das Entidades B associadas.
        REMOVE – Quando remover a Entidade A, também será removida todas as entidades B associadas.
        REFRESH – Quando houver atualização no banco de dados na Entidade A, todas as entidades B associadas serão atualizadas.
        ALL – Corresponde a todas as operações acima (MERGE, PERSIST, REFRESH e REMOVE).
     */
	@OneToOne(fetch = FetchType.LAZY,
			cascade = CascadeType.PERSIST) //Marcando com isto, o objeto estado será persistido junto com o governador
	private Estado estado;

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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	/*
	    This method will be called before any object be persisted. It is a CALLBACK method
	    It is possible to create a method for each callback
	 */
//	@PrePersist
//	@PostPersist
//	@PreRemove
//	@PostRemove
//	@PreUpdate
//	@PostUpdate
//	@PostLoad
	public void prePersist(){
		System.out.println("Persistindo o objeto - "+this.toString());
	}

	@Override
	public String toString() {
		return "["+this.getId()+", "+this.getNome()+"]";
	}
}

