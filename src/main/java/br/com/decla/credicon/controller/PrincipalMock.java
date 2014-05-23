package br.com.decla.credicon.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.coury.jfilehelpers.engines.FileHelperEngine;

import br.com.decla.credicon.to.MockTO;


public class PrincipalMock {

	public static void main(String[] args) {
		List<MockTO> mocks = new ArrayList<MockTO>();
		FileHelperEngine<MockTO> engine = new FileHelperEngine<MockTO>(MockTO.class);	
		for (int j = 0; j < 1000; j++) {
			MockTO mockTO = new MockTO();
			mockTO.setId(j);
			mockTO.setNome("sdfadfasdfasdfa");
			mockTO.setNumero(2.05D);
			mockTO.setDataNasc(new Date());
			mocks.add(mockTO);
		}
		
		try {
			engine.writeFile("src/main/resources/out/output.txt", mocks);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
