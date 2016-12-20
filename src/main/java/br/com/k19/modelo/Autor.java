package br.com.k19.modelo;

import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Autor {

	@Id @GeneratedValue
	private Long id;
	
	private String name;
	
	@Lob //Um objeto muito grande
	private byte[] avatar;
	
	@Temporal(TemporalType.DATE) //Serve para formatar qual o tipo de de data que será armazenada
	private Calendar nascimento;
	
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

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", avatar=" + Arrays.toString(avatar) +
                ", nascimento=" + nascimento +
                ", idade=" + idade +
                '}';
    }
}
