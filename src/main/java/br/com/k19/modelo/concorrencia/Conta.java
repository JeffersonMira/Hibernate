package br.com.k19.modelo.concorrencia;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * Created by jeffersonMira on 09/11/2016.
 */

@Entity
public class Conta {

    @Id @GeneratedValue
    private Long id;

    private Double saldo;

//    Locking otimista
    @Version
    private Long versao;

    public Long getId() {
        return id;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void setVersao(Long versao) {
        this.versao = versao;
    }

    public Long getVersao() {
        return versao;
    }
}
