package br.com.decla.credicon.service;

import java.util.ArrayList;
import java.util.List;

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
	
	private static final String CLIENTE_OUTPUT = "Cliente-%1.txt";
	private static final String OUT = "src/main/resources/out/";
	private static CriarArquivosClienteService S_INSTANCE;
	private static final String HEADER = "0000010CLIENTE  9999YYYYMM                             0";
	private static final String TRAILLER = "%14                                                0";
	
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
	 */
	public void criarArquivoCliente(Doc3040 doc3040) {
		Integer i = 1;
		String outputFile = OUT+CLIENTE_OUTPUT.replace("%1", getDateStr());

		//Criar arquivo Reader
		String header = headerOfFile(outputFile,doc3040.getDtBase());
		
		/*Lista de Clientes*/
		List<ClienteTO> lista = new ArrayList<ClienteTO>();
		List<Cli> clientes = doc3040.getCli();
		
		for (Cli cli : clientes) {
			ClienteTO cliente = new ClienteTO();
			
			cliente.setSequencial((++i).toString());
			cliente.setiDRegistro(_1);
			cliente.setCpfCnpjCliente(cli.getCd().toString());
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
		String trailler = traillerOfFile(outputFile,String.format("%06d", ++i));
		
		//Gerar arquivo
		criarArquivoTxt(outputFile, lista, ClienteTO.class, header, trailler);
	}

	/**
	 * 
	 * @param outputFile
	 */
	private String traillerOfFile(String outputFile, String length) {
		return TRAILLER.replaceAll("%1", length);
	}

	/**
	 * Alterar os dados do cabecalho
	 * @param outputFile
	 * @param dt 
	 */
	private String headerOfFile(String outputFile, String dt) {
		return HEADER.replaceAll("YYYYMM", dt.replace("-", ""));
	}
}
