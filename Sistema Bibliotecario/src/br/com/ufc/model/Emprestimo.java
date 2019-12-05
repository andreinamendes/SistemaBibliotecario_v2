package br.com.ufc.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Emprestimo {
	int numReg;
	int matricula;
    String dataEmp;
    String dataDevo;
    int qtdReno;
    
	public int getNumReg() {
		return numReg;
	}
	public void setNumReg(int numReg) {
		this.numReg = numReg;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public Date getDataEmp() throws ParseException {
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmp);
		return date;
	}
	public void setDataEmp(String dataEmp) {
		this.dataEmp = dataEmp;
	}
	public Date getDataDevo() throws ParseException {
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataDevo);
		return date;
	}
	public void setDataDevo(String dataDevo) {
		this.dataDevo = dataDevo;
	}
	public int getQtdReno() {
		return qtdReno;
	}
	public void setQtdReno(int qtdReno) {
		this.qtdReno = qtdReno;
	}
}
