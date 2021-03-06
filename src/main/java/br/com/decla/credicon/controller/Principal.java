//marshaller.marshal(doc3040, System.out);
package br.com.decla.credicon.controller;

import java.io.File;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import br.com.decla.credicon.generated.Doc3040;
import br.com.decla.credicon.service.Constants;
import br.com.decla.credicon.service.CriarArquivosClienteService;
import br.com.decla.credicon.service.CriarArquivosOperacaoService;
import br.com.decla.credicon.service.LerArquivoCpfCnpjCliente;
import br.com.decla.credicon.util.Utiliarios;

public class Principal {

	private static final String XML_PATH = "src/main/resources/xml/0061201402_3040.xml";
	
	public static void main(String[] args) {
		try {
			Doc3040 doc3040 = lerArquivoXml();
			
			//Le o arquivo de Clientes
			Map<String, String> arquivoCliente = LerArquivoCpfCnpjCliente.getInstance().lerArquivoClienteTxt();
			
			//Criação do arquivo de Clientes
			CriarArquivosClienteService cliente = CriarArquivosClienteService.getInstance();
			cliente.criarArquivoCliente(doc3040,arquivoCliente);
			
			//Criação do arquivo de operacoes.
			CriarArquivosOperacaoService operacao = CriarArquivosOperacaoService.getInstance();
			operacao.criarArquivoOperacao(doc3040,arquivoCliente);
			
			Utiliarios.mergeFiles(new String[]{
					Constants.CLIENTE_OUTPUT,
					Constants.OPERACAO_OUTPUT},
					Constants.ARQUIVOBANCOOB_TXT.replaceAll(Constants.R1, Utiliarios.getDateStr()));
			
			Constants.i = 0;
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Ler arquivo XML.
	 * @return
	 * @throws JAXBException
	 * @throws PropertyException
	 */
	public static Doc3040 lerArquivoXml() throws JAXBException, PropertyException {
		JAXBContext jc;
		jc = JAXBContext.newInstance(Doc3040.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		File xml = new File(XML_PATH);
		Doc3040 doc3040 = (Doc3040) unmarshaller.unmarshal(xml);
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		return doc3040;
	}

	static class TestCVS{
		/**
		 * 
		 * @param args
		 */
//		public static void main(String[] args) {
//			try {
//				//Le o arquivo
//				Doc3040 doc3040 = Principal.lerArquivoXml();
//				
//				//Le o arquivo de Clientes
//				Map<String, String> arquivoCliente = LerArquivoCpfCnpjCliente.getInstance().lerArquivoClienteTxt();
//				
//				//Criação do arquivo de operacoes.
//				CriarArquivosOperacaoService operacao = CriarArquivosOperacaoService.getInstance();
////				operacao.criarArquivoOperacaoCSV(doc3040,arquivoCliente);
//				
//			} catch (PropertyException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (JAXBException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}
}

