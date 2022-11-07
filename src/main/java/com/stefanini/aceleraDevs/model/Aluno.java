package com.stefanini.aceleraDevs.model;
//modelos das classes da tabela 

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.persistence.*;


@NoArgsConstructor
@Entity
@Data
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String matricula;

    @OneToOne
    private DadosPessoais dadosPessoais;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "turma_id")
    private Turma turma;
    
    
    public Aluno() {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.dadosPessoais = dadosPessoais;
        this.turma = turma;
        
    }

    //*
	public Aluno(Object object, String nome, String matricula, DadosPessoais save, Turma turma) {
		
	}


	public String getNome() {
		
		return nome;
	}


	public String getMatricula() {
		
		return matricula;
	}


	public Long getId() {
		
		return id;
	}


	public void setNome(String nome) {
		this.nome=nome;
		
		
	}


	public void setMatricula(String matricula) {
		this.matricula=matricula;
		
	}


	public void setId(Long id) {
		this.id=id;
		
	}








	
}


    

  




