package br.com.decla.credicon.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.decla.credicon.service.Constants;

public class Utiliarios {
	/**
	 * Metodo sobrecarrega merge files e realiza o merge dos arquivos
	 * @param strings
	 * @param fileOutput
	 */
	public static void mergeFiles(String[] pathFiles, String fileOutput) {
		
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
	public static void mergeFiles(File[] files, File mergedFile) {
		 
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
	 * Obtem data e hora em um pattern determinado
	 * @return
	 */
	public static String getDateStr() {
		return new SimpleDateFormat(Constants.PATTERN_DATE).format(new Date(System.currentTimeMillis()));
	}
}
