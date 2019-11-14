package br.com.ufc.model;

public class Unidade {
	private int idLivro;
	private String matricula;
	private String dataEmprestimo;
	private String dataDevolucao;
	private int qtdRenovacao;
	
	public int getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public String getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public int getQtdRenovacao() {
		return qtdRenovacao;
	}
	public void setQtdRenovacao(int qtdRenovacao) {
		this.qtdRenovacao = qtdRenovacao;
	}	
}
