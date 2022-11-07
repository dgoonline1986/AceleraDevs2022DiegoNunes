package com.stefanini.aceleraDevs.dto;

import com.stefanini.aceleraDevs.model.Aluno;

// aqui passa somente o que sera transitado e que precisa (é replicaod as classes da entiade)


public class AlunoDTO {

    private String nome;

    private String matricula;

    private String cpf;

    private String email;

    private Long idTurma;

    public AlunoDTO() {
    
    }

    public AlunoDTO(String nome, String matricula, String cpf, String email, Long idTurma) {
        this.nome = nome;
        this.matricula = matricula;
        this.cpf = cpf;
        this.email = email;
        this.idTurma = idTurma;
    }
    
    /*//vai receber argumento do tipo Aluno
    public AlunoDTO(Aluno aluno) {
    	idTurma=aluno.getId();
    	nome = aluno.getNome();
        matricula = aluno.getMatricula();
    }
    
   public Aluno toAluno() {
    	Aluno aluno= new Aluno();
    	aluno.setId(idTurma);
    	aluno.setNome(nome);
    	aluno.setMatricula(matricula);
    	return aluno;
    	
    }*/
    
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Long idTurma) {
        this.idTurma = idTurma;
    }
}
