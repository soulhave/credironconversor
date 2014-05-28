package br.com.decla.credicon.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.coury.jfilehelpers.engines.FileHelperEngine;

/**
 * 
 * @author ramon
 *
 */
public abstract class CriarArquivosService {
	
	protected static final String PATTERN_9_ESPACOS_DIREITA = "%1$-9s";
	protected static final String PATTERN_2_ZEROS_ESQUERDA = "%02d";
	protected static final String PATTERN_4_ZEROS_ESQUERDA = "%04d";
	protected static final String PATTERN_6_ZEROS_ESQUERDA = "%06d";
	protected static final String _0 = "0";
	protected static final String _1 = "1";
	protected static final String _2 = "2";
	protected static final String _3 = "3";
	protected static final String _4 = "4";
	protected static final String FILLER = "";
	protected static final String PATTERN_DATE = "yyyy-MM-dd-HHmmss";
	protected static final String HEADER = "0000010%19999YYYYMM%20";
	protected static final String TRAILLER = "%14%20";

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
			fileHelperEngine.writeFile(Constants.OUT+outputFile, list);
			
			if(trailler!=null && !trailler.isEmpty())
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
	protected void writeFooter(String file, String footer){
		try {
		    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(Constants.OUT+file, true)));
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
	

	/**
	 * 
	 * @param outputFile
	 * @param i 
	 */
	protected String traillerOfFile(String length, int i) {
		return TRAILLER.replaceAll("%1", length).
				replaceAll("%2", String.format("%1$"+i+"s", ""));
	}

	/**
	 * Alterar os dados do cabecalho
	 * @param outputFile
	 * @param dt 
	 * @param i 
	 */
	protected String headerOfFile(String dt, String s, int i) {
		return HEADER.
				replaceAll("YYYYMM", dt.replace("-", "")).
				replaceAll("%1", String.format(PATTERN_9_ESPACOS_DIREITA, s)).
				replaceAll("%2", String.format("%1$"+i+"s", ""));
	}
	
	/**
	 * Metodo sobrecarrega merge files e realiza o merge dos arquivos
	 * @param strings
	 * @param fileOutput
	 */
	protected void mergeFiles(String[] pathFiles, String fileOutput) {
		
		if(pathFiles==null || pathFiles.length == 0 || fileOutput == null || fileOutput.isEmpty()){
			System.out.println("Dados inválidos para merge");
			return;
		}
		
		int i = 0;
		File[] files = new File[pathFiles.length];
		
		for (String s : pathFiles) {
			files[i++] = new File(Constants.OUT+s);
		}
		
		File fileOutPut = new File(Constants.OUT+fileOutput);
		
		mergeFiles(files, fileOutPut);
	}
	
	/**
	 * Merge de arquivos
	 * @param files
	 * @param mergedFile
	 */
	protected void mergeFiles(File[] files, File mergedFile) {
		 
		FileWriter fstream = null;
		BufferedWriter out = null;
		try {
			fstream = new FileWriter(mergedFile, true);
			 out = new BufferedWriter(fstream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
 
		for (File f : files) {
			System.out.println("merging: " + f.getName());
			FileInputStream fis;
			try {
				fis = new FileInputStream(f);
				BufferedReader in = new BufferedReader(new InputStreamReader(fis));
 
				String aLine;
				while ((aLine = in.readLine()) != null) {
					out.write(aLine);
					out.newLine();
				}
 
				in.close();
				f.delete();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
 
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
 
	}
	
	/**
	 * Obtem o cliente pela chave
	 * @param key
	 * @return 
	 */
	protected String obterClienteByKey(String key, Map<String, String> clientes) {
		String string = null;
		if(clientes!=null && !clientes.isEmpty()) {
			string = clientes.get(key);
		}
		return (string==null?key:string);
	}
}
