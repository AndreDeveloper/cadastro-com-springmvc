package br.com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.model.Usuario;
import br.com.model.UsuarioDao;

@Controller
public class loginController {
	private UsuarioDao dao;
	
	
	@Autowired
	public loginController(UsuarioDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/logar")
	public ModelAndView logar(Usuario usuario, HttpSession session){
		String nome = dao.existe(usuario);
		if (nome != null){
			session.setAttribute("nome", nome);
			session.setAttribute("login", usuario.getLogin());
			ModelAndView mv = new ModelAndView("home");
			return mv;
		}else{
			ModelAndView mv = new ModelAndView("login");
			mv.addObject("erro", true);
			
			return mv;
		}
	}
	
	@RequestMapping("/sair")
	public String sair(HttpSession session){
		
		session.setAttribute("login", null);
		session.setAttribute("nome", null);
	
		return "login";
	}

	
	@RequestMapping("/cadastrar-usuario")
	public String cadastrarUsuario(){
		return "cadastro-usuario";
	}
	
	@RequestMapping("/cadastraUsuario")
	public ModelAndView cadastraUsuario(Usuario usuario, HttpSession session){
		dao.insert(usuario);
		session.setAttribute("nome", usuario.getNome());
		session.setAttribute("login", usuario.getLogin());
		ModelAndView mv = new ModelAndView("home");
					
		return mv;
	}
}
