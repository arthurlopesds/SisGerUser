package br.com.service;

import java.util.ArrayList;
import java.util.List;

import br.com.model.Cliente;

public class ClienteService {

	private static List<Cliente> lista = new ArrayList<>();
	

	public void cadastrar(Cliente cliente) {
		lista.add(cliente);	
		
	}
	public List<Cliente> getTodosclientes(){
		return lista;
	}
	
	public void excluir(int indice) {
		lista.remove(indice);
	}
	
	
	public List<String> buscar(String st){
		
		List<String> sts = new ArrayList<>();
		
		for (Cliente c : lista) {
			if (c.getStatus().equalsIgnoreCase(st)) {
				sts.add(c.getLogin());
				System.out.println(sts.size());

			}
		}
		
		return sts;
	
	}
	
	public String statusBusc(String st) {
		return st;
	}
	
}
