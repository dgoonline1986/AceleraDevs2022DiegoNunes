package com.stefanini.aceleraDevs.repository;
                           //quem faz a persistencia( salva, busca..etc)
//se comunica com service
import com.stefanini.aceleraDevs.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
															//tipo chave primaria
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
