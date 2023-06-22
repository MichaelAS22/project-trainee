package com.teste.job.model;


import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

// classe referente a tabela contratos
@Table(name = "contratos")
@Entity
public class Cliente {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "pessoa_nome")
    private String nome;

    @Column(name = "pessoa_cpf_cnpj")
    private String cpfCnpj;

    @NotNull
    @Column(name = "data_inicio")
    private LocalDateTime inicio;

    @NotNull
    @Column(name = "data_validade")
    private LocalDateTime validade;

    public Cliente(String id, String nome, String cpfCnpj, LocalDateTime inicio, LocalDateTime validade) {
        this.id = id;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.inicio = inicio;
        this.validade = validade;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getValidade() {
        return validade;
    }

    public void setValidade(LocalDateTime validade) {
        this.validade = validade;
    }

    public Cliente(){
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
