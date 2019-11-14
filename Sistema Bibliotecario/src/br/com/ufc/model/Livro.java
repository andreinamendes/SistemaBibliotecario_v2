package br.com.ufc.model;

import java.util.List;
import java.util.ArrayList;

public class Livro {
	private int isbn;
	private String titulo;
	private String ano_lançamento;
	private List<Unidade> unidades;
	private int edicao;
	
	public int getIsbn() {
		return isbn;
	}
	
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAno_lançamento() {
		return ano_lançamento;
	}
	
	public void setAno_lançamento(String ano_lançamento) {
		this.ano_lançamento = ano_lançamento;
	}
	
	public List<Unidade> getUnidades() {
		return unidades;
	}
	
	public void setUnidades(List<Unidade> unidades) {
		this.unidades = unidades;
	}
	
	public int getEdicao() {
		return edicao;
	}
	
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
}
