package br.com.decla.credicon.controller;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.decla.credicon.generated.Doc3040;
import br.com.decla.credicon.service.CriarArquivosClienteService;

public class Principal {

	private static final String XML_PATH = "src/main/resources/xml/0061201402_3040.xml";

	public static void main(String[] args) {
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(Doc3040.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			File xml = new File(XML_PATH);
			Doc3040 doc3040 = (Doc3040) unmarshaller.unmarshal(xml);
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			//marshaller.marshal(doc3040, System.out);
			CriarArquivosClienteService instance = CriarArquivosClienteService.getInstance();
			instance.criarArquivoCliente(doc3040);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
