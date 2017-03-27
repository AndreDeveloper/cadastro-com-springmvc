package br.com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RequestInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		String uri = request.getRequestURI();
		if(uri.endsWith("cadastrar-usuario") 
				|| uri.endsWith("logar") 
				|| uri.endsWith("login") 
				|| uri.contains("resources")
				|| uri.endsWith("cadastraUsuario")){
			return true;
		}
		
		if(request.getSession().getAttribute("login") != null){
			return true;
		}else{
			response.sendRedirect("login");
			return false;
		}		
	}

}
