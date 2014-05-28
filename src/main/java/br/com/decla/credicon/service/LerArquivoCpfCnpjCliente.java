package br.com.decla.credicon.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.decla.credicon.to.CpfCnpj;

public class LerArquivoCpfCnpjCliente extends LerArquivosService {

	private static LerArquivoCpfCnpjCliente S_INSTANCE;
	private static String PATH_CLIENTES = "cliente-crediron.txt";
	
	private LerArquivoCpfCnpjCliente() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @return
	 */
	public static LerArquivoCpfCnpjCliente getInstance() {
		if(S_INSTANCE==null){
			S_INSTANCE = new LerArquivoCpfCnpjCliente();
		}
		return S_INSTANCE;
	}

	/**
	 * Mapa de dados 
	 * @return
	 */
	public Map<String, String> lerArquivoClienteTxt(){
		List<?> lerArquivoTxt = lerArquivoTxt(PATH_CLIENTES, CpfCnpj.class);
		Map<String, String> clientes = new HashMap<>();
		
		for (Object o : lerArquivoTxt) {
			CpfCnpj cpfCnpj = (CpfCnpj)o;
			clientes.put(cpfCnpj.getCpfCnpj().substring(0, 8), cpfCnpj.getCpfCnpj());
		}
		
		return clientes;
	}
	
}
