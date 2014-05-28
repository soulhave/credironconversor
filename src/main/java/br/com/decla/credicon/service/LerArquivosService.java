package br.com.decla.credicon.service;

import java.io.IOException;
import java.util.List;

import org.coury.jfilehelpers.engines.FileHelperEngine;

public abstract class LerArquivosService {

	/**
	 * Ler arquivo texto.
	 * @param outputFile
	 * @param list
	 * @param clazz
	 * @param trailler 
	 * @param header 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected List<?> lerArquivoTxt(String outputFile, Class clazz){
		try {
			FileHelperEngine<Class> fileHelperEngine = new FileHelperEngine<Class>(clazz);
			return fileHelperEngine.readFile(Constants.IN+outputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
