package com.stefanini.aceleraDevs.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class DadosPessoais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @CPF
    private String cpf;
    @Column(nullable = false)
    private String email;

    public DadosPessoais(Long id,  String cpf, String email) {
        this.id = id;
        this.cpf = cpf;
        this.email = email;
    }
    
   /*
    @Column(nullable = true)
    private String telefone;
    @Column(nullable = true)
    private String rg;
    @Column(nullable = true)
    private String rua;
    @Column(nullable = true)
    private String numero;
    @Column(nullable = true)
    private String cidade;
    @Column(nullable = true)
    private String estado;
    @Column(nullable = true)
    private String cep;
    */


}
