package br.com.k19.modelo.JPQL;

import javax.persistence.*;
import java.util.Calendar;

/**
 * As Named Queries são carregadas na hora que o sistema é carregado, economizando assim tempo.
 * É diferente das queries dinâmicas.
 */
@Entity
//@Table(name="")
@NamedQueries({
		@NamedQuery(name="AutorJpql.findAll", query="Select a From AutorJpql a"),
        @NamedQuery(name="AutorJpql.count", query="Select count(a) From AutorJpql a"),
		@NamedQuery(name="AutorJpql.findByName",query="select a from AutorJpql a WHERE a.name = :name")
})
public class AutorJpql {

	@Id @GeneratedValue
	private Long id;
	
	private String name;

	@Transient //Não vai ser armazenado na base de dados
	private Integer idade;
	
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

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

    @Override
    public String toString() {
        return "AutorJpql{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idade=" + idade +
                '}';
    }
}
