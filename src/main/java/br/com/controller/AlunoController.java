package br.com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.model.Aluno;
import br.com.model.AlunoDAO;
import br.com.model.Mensagens;

@Controller
public class AlunoController {
	private AlunoDAO dao;
	
	
	@Autowired
	public AlunoController(AlunoDAO dao) {
		this.dao = dao;
	}

	
	@RequestMapping("/home")
	public String home(){
		return "home";
	}
	
	/**
	 * controller que chama a view gestão alunos
	 * @return
	 */
	@RequestMapping("/gestao-alunos")
	public ModelAndView gestaoAlunos(Mensagens msg){
		List<Aluno> alunos = dao.selectAll();
		
		if(alunos.size() <= 0){
			msg.setExisteRegistro(false);
		}else{
			msg.setExisteRegistro(true);
		}
		
		ModelAndView mav = new ModelAndView("cadastro");
		mav.addObject("alunos", alunos);	
		mav.addObject("msg", msg);	

		return mav;
	}
	
	/**
	 * insere  aluno e devolve confirmação para view
	 * @param aluno
	 * @return
	 */
	@RequestMapping("/cadastrar")
	public String cadastrar(@Valid Aluno aluno, BindingResult result){
		
		if(result.hasErrors()){
			System.out.println("deu erro");
			return "redirect:/gestao-alunos";
		}
		
		List<Aluno> alunos = dao.selectAll();
		
		dao.insert(aluno);
				
		return "redirect:/gestao-alunos?cadastrado=true";
	}
	
	/**
	 * deleta aluno e devolve confirmação para view
	 * @param aluno
	 * @return
	 */
	@RequestMapping("/deletar")
	public String deletar(Aluno aluno){
		
		dao.delete(aluno);
		
		Mensagens msg = new Mensagens();				
		
		return "redirect:/gestao-alunos?excluido=true";
	}
}
