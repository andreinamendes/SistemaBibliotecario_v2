package br.com.ufc.dao;

import java.util.ArrayList;

public interface InterfaceDAO<Model> {
	
	public boolean inserir(Model t);
	public boolean atualizar(Model t);
	public Model remover(Model t);
	public ArrayList<Model> buscar(String t);

}
