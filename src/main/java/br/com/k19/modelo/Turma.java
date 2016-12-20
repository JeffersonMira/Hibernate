package br.com.k19.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Turma {

	@Id @GeneratedValue
	private Long id;
	
	@Enumerated(EnumType.STRING)//Caso não seja especificado, será guardado o valor numérico - ou seja, zero, um, dois...
	private PeriodoEnum periodo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PeriodoEnum getPeriodo() {
		return periodo;
	}

	public void setPeriodo(PeriodoEnum periodo) {
		this.periodo = periodo;
	}
	
}
