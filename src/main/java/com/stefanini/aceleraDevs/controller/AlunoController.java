package com.stefanini.aceleraDevs.controller;
//responde a interações com usuario e integage com service  e com html

import com.stefanini.aceleraDevs.dto.AlunoDTO;
import com.stefanini.aceleraDevs.exception.TurmaNotFoundException;
import com.stefanini.aceleraDevs.model.Aluno;
import com.stefanini.aceleraDevs.repository.AlunoRepository;
import com.stefanini.aceleraDevs.mapper.AlunoDTOService;
import com.stefanini.aceleraDevs.service.AlunoService;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ViewNameMethodReturnValueHandler;
import org.thymeleaf.engine.AttributeName;


@Controller(value="/aluno")
public class AlunoController {

	@Autowired
    private final AlunoService alunoService;
    private final AlunoDTOService alunoDTOService;
    
   /*@GetMapping(value="/{id}")// o que vai ser usado no html
    public AlunoDTO findById(@PathVariable Long id) {
    	return alunoDTOService.findById(id);
    }*/
   
    // criando objeto com a dependencia
    @Autowired
    public AlunoController(AlunoService alunoService, AlunoDTOService alunoDTOService) {
        this.alunoService = alunoService;
        this.alunoDTOService = alunoDTOService;
    }

     @Autowired
    AlunoRepository alunoRepository; 
    
	

    @RequestMapping(path = "/aluno")
    public ModelAndView loadHtml() {

        ModelAndView mv = new ModelAndView("aluno");
        AlunoDTO alunoDTO = new AlunoDTO();

        mv.addObject("alunoDTO", alunoDTO);

        return mv;
    }

    @PostMapping(value = "/aluno")// inserindo valores, quando acionado ativa RequestMapping
    public String saveAluno(AlunoDTO aluno) throws TurmaNotFoundException {

        Aluno newAluno = alunoDTOService.mapAluno(aluno);

        alunoService.save(newAluno);
        
        System.out.println(newAluno);

        return "redirect:/aluno";
    }
   
    /*
    @GetMapping("/aluno")
    public String aluno() {
    	return "/aluno";
    }
    
    @GetMapping("/aluno")
	public List<Aluno> list() {
	System.out.println("listando Alunos");
	return alunoRepository.findAll();
    }*/
    
    @GetMapping("/alunoIndex")
    public String alunoIndex() {
    System.out.println("listando Alunos");
	List<Aluno> alunos= this.alunoRepository.findAll();
	

	 return "/alunoIndex";
	    
    }
    
    
  
    

	@ExceptionHandler(ConstraintViolationException.class)
    public String onError() {
    	return "redirect:/aluno";// se acontecer algum erro no CPF ele joga para home 
    }
	

}
