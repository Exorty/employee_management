package com.miller.gerenciamentoFuncionarios.models;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="tb_departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    private List<Funcionario> Funcionario;

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

  

    

    public Departamento(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    
    }

    public Departamento() {
    }

    @Override
    public String toString() {
        return  nome;
    }

   

    
    

    
    
}