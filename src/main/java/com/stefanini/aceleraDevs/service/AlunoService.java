package com.stefanini.aceleraDevs.service;
//se comunica com controller e realiza operações de negocio
//chama camada repository

import com.stefanini.aceleraDevs.dto.AlunoDTO;
import com.stefanini.aceleraDevs.exception.AlunoNotFoundException;
import com.stefanini.aceleraDevs.model.Aluno;
import com.stefanini.aceleraDevs.repository.AlunoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
	
	//injeção de dependencia
	@Autowired
    private final AlunoRepository alunoRepository;
	
	/*/Busca usuario retorna objeto dto
	public AlunoDTO findById(Long idTurma) {
		Aluno entity=alunoRepository.findById(idTurma).get();
		AlunoDTO dto=new AlunoDTO(entity);
		return dto;
		
	}*/

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> findAllAlunos(){
        return alunoRepository.findAll();
    }

    public Aluno findById(Long id) throws AlunoNotFoundException {
        return alunoRepository.findById(id)
                .orElseThrow(()-> new AlunoNotFoundException(id));
    }

    public Aluno save(Aluno aluno){
        return alunoRepository.save(aluno);
    }

}
