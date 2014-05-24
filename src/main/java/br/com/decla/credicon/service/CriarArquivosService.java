package br.com.decla.credicon.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.coury.jfilehelpers.engines.FileHelperEngine;

/**
 * 
 * @author ramon
 *
 */
public abstract class CriarArquivosService {
	
	protected static final String _0 = "0";
	protected static final String _1 = "1";
	protected static final String FILLER = "";
	protected static final String PATTERN_DATE = "yyyy-MM-dd-HHmmss";

	/**
	 * Criar arquivo texto.
	 * @param outputFile
	 * @param list
	 * @param clazz
	 * @param trailler 
	 * @param header 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void criarArquivoTxt(String outputFile, List list, Class clazz, String header, String trailler){
		try {
			FileHelperEngine<Class> fileHelperEngine = new FileHelperEngine<Class>(clazz);
			fileHelperEngine.setHeaderText(header);
			fileHelperEngine.writeFile(outputFile, list);
			writeFooter(outputFile, trailler);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Escrever footer no final do arquivo
	 * @param file
	 * @param footer
	 */
	private void writeFooter(String file, String footer){
		try {
		    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
		    out.println(footer);
		    out.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

	
	/**
	 * Retira os pontos do ponto flutuante. 
	 * @param d
	 * @return
	 */
	protected String doubleToStrWithoutDot(Double d){
		if(d==null)
			return _0;
		DecimalFormat df = new DecimalFormat("#######");
		String replace = df.format(d.doubleValue()*100);
		return replace;
	}

	/**
	 * Sobrecarga de double to str sem ponto flutuante.
	 * @param d
	 * @return
	 */
	protected String doubleToStrWithoutDot(Float d){
		if(d==null)
			return _0;
		return doubleToStrWithoutDot(d.doubleValue());
	}
	
	/**
	 * Obtem data e hora em um pattern determinado
	 * @return
	 */
	protected String getDateStr() {
		return new SimpleDateFormat(PATTERN_DATE).format(new Date(System.currentTimeMillis()));
	}
}
