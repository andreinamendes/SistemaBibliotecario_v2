package br.com.ufc.model;

public class Telefone {
	private int ddd;
	private int numero;
	private int constante = 9;
	
	public int getDdd() {
		return ddd;
	}
	
	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getConstante() {
		return constante;
	}
}
