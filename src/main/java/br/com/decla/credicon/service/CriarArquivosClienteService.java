package br.com.decla.credicon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.decla.credicon.generated.Doc3040;
import br.com.decla.credicon.generated.Doc3040.Cli;
import br.com.decla.credicon.to.ClienteTO;

/**
 * Classe responsável por gerar o arquivo de 
 * clientes para o bancoob.
 * @author ramon
 *
 */
public class CriarArquivosClienteService extends CriarArquivosService {

	private static final String CLIENTE_HEADER_FILE = "CLIENTE";
	private static final String CLIENTE_OUTPUT = "Cliente-%1.txt";
	private static CriarArquivosClienteService S_INSTANCE;
	
	/**
	 * 
	 * @return
	 */
	public static CriarArquivosClienteService getInstance() {
		if(S_INSTANCE==null){
			S_INSTANCE = new CriarArquivosClienteService();
		}
		return S_INSTANCE;
	}
	
	private CriarArquivosClienteService() {
	}
	
	/**
	 * Criar arquivo de Clientes
	 * @param doc3040
	 * @param arquivoCliente 
	 */
	public void criarArquivoCliente(Doc3040 doc3040, Map<String, String> arquivoCliente) {
		Integer i = 1;
		String outputFile = CLIENTE_OUTPUT.replace("%1", getDateStr());

		//Criar arquivo Reader
		String header = headerOfFile(doc3040.getDtBase(),CLIENTE_HEADER_FILE,29);
		
		/*Lista de Clientes*/
		List<ClienteTO> lista = new ArrayList<ClienteTO>();
		List<Cli> clientes = doc3040.getCli();
		
		for (Cli cli : clientes) {
			ClienteTO cliente = new ClienteTO();
			
			cliente.setSequencial((++i).toString());
			cliente.setiDRegistro(_1);
			cliente.setCpfCnpjCliente(obterClienteByKey(cli.getCd().toString(),arquivoCliente));
			cliente.setPorteCliente(cli.getPorteCli().toString());
			cliente.setFiller(FILLER);
			cliente.setTipoControle((cli.getTpCtrl()!=null?cli.getTpCtrl().toString():"01"));
			cliente.setTipoPessoa((cli.getTp()!=null?cli.getTp().toString():"1"));
			cliente.setDataIncioRelacionamento(cli.getIniRelactCli().toGregorianCalendar().getTime());
			cliente.setNivelRiscoCliente(cli.getClassCli());
			cliente.setAutorizacao(cli.getAutorzc());
			cliente.setFaturamentoAnual(doubleToStrWithoutDot(cli.getFatAnual()));
			
			lista.add(cliente);
		}
		
		//Criar arquivo trailler
		String trailler = traillerOfFile(String.format(PATTERN_6_ZEROS_ESQUERDA, ++i),48);
		
		//Gerar arquivo
		criarArquivoTxt(outputFile, lista, ClienteTO.class, header, trailler);
	}
	
}
