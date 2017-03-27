package br.com.model;

import java.io.Serializable;

public class Mensagens implements Serializable{
	
	boolean cadastrado;
	boolean alterado;
	boolean excluido;
	boolean existeRegistro;
	
	public Mensagens(boolean cadastrado, boolean alterado, boolean excluido, boolean existeRegistro) {
		super();
		this.cadastrado = cadastrado;
		this.alterado = alterado;
		this.excluido = excluido;
		this.existeRegistro = existeRegistro;
	}
	
	public Mensagens() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean isCadastrado() {
		return cadastrado;
	}
	public void setCadastrado(boolean cadastrado) {
		this.cadastrado = cadastrado;
	}
	public boolean isAlterado() {
		return alterado;
	}
	public void setAlterado(boolean alterado) {
		this.alterado = alterado;
	}
	public boolean isExcluido() {
		return excluido;
	}
	public void setExcluido(boolean excluido) {
		this.excluido = excluido;
	}
	public boolean isExisteRegistro() {
		return existeRegistro;
	}
	public void setExisteRegistro(boolean existeRegistro) {
		this.existeRegistro = existeRegistro;
	}
	
	@Override
	public String toString() {
		return "Mensagens [cadastrado=" + cadastrado + ", alterado=" + alterado + ", excluido=" + excluido
				+ ", existeRegistro=" + existeRegistro + "]";
	}
	

}
