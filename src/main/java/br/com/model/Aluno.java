package br.com.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Aluno implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4656276890581515442L;
	
	private int id;
	@NotNull @Size(min=5, max=5, message="aluno.formulario.matricula")
	private long matricula;
	@NotNull @Size(min=2)
	private String nome;
	@NotNull 
	@Pattern(regexp="(^(\\d{2}\\x2E\\d{3}\\x2E\\d{3}[-]\\d{1})$|^(\\d{2}\\x2E\\d{3}\\x2E\\d{3})$)",
			message="aluno.formulario.rg")
	private String rg;
	@NotNull 
	@Pattern(regexp="[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}",
			message="aluno.formulario.cpf")
	private String cpf;
	@NotNull
	private String dataNascimento;
	
	public Aluno() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Aluno(int id, long matricula, String nome, String rg, String cpf, String dataNascimento) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", matricula=" + matricula + ", nome=" + nome + ", rg=" + rg + ", cpf=" + cpf
				+ ", dataNascimento=" + dataNascimento + "]";
	}
	
	

}
