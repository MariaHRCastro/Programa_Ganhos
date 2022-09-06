package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.NivelFuncionario;

public class Funcionario {

	private String nome;
	private NivelFuncionario nivel;
	private Double salarioBase;
	
	private Departamento departamento;
	private List <HoraContrato> contratos = new ArrayList<>();
	
	
	// CONSTRUTORES
	
	public Funcionario() {}


	public Funcionario(String nome, NivelFuncionario nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

//GETTERS E SETTERS
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public NivelFuncionario getNivel() {
		return nivel;
	}


	public void setNivel(NivelFuncionario nivel) {
		this.nivel = nivel;
	}


	public Double getSalarioBase() {
		return salarioBase;
	}


	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}


	public Departamento getDepartamento() {
		return departamento;
	}


	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}


	public List<HoraContrato> getContratos() {
		return contratos;
	}


	// MÉTODOS
	
	public void addContrato(HoraContrato contrato) {
		contratos.add(contrato);
	}
	
	public void removeContrato(HoraContrato contrato) {
		contratos.remove(contrato);
	}
	
	public Double ganhos(int mes,int ano) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		for (HoraContrato c: contratos) {
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1+cal.get(Calendar.MONTH);
			if (mes == c_mes && ano == c_ano) {
				soma += c.valorTotal();
			}
		}
		return soma;
	}
	
	}
