package br.com.decla.credicon.controller;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.decla.credicon.generated.Doc3040;
import br.com.decla.credicon.generated.Doc3040.Agreg;

public class Principal {

	public static void main(String[] args) {
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(Doc3040.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			File xml = new File("src/main/resources/xml/0061201402_3040.xml");
			Doc3040 doc3040 = (Doc3040) unmarshaller.unmarshal(xml);
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			List<Agreg> agreg = doc3040.getAgreg();
			for (Agreg agreg2 : agreg) {
				System.out.println("OP="+agreg2.getClassOp());
			}
			//marshaller.marshal(doc3040, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
