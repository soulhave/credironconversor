package br.com.decla.credicon.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import br.com.decla.credicon.generated.Doc3040;
import br.com.decla.credicon.generated.Doc3040.Cli;
import br.com.decla.credicon.generated.Doc3040.Cli.Op;
import br.com.decla.credicon.generated.Doc3040.Cli.Op.Gar;
import br.com.decla.credicon.generated.Doc3040.Cli.Op.Inf;
import br.com.decla.credicon.generated.Doc3040.Cli.Op.Venc;
import br.com.decla.credicon.to.GarantiaTO;
import br.com.decla.credicon.to.InformacaoAdicionalTO;
import br.com.decla.credicon.to.OperacaoTO;
import br.com.decla.credicon.util.Utiliarios;

/**
 * Classe responsável por gerar o arquivo de 
 * clientes para o bancoob.
 * @author ramon
 *
 */
public class CriarArquivosOperacaoService extends CriarArquivosService {
	
	protected static final String REGIAO_BACEN = "10093";
	private static final String OPERACAO_HEADER_FILE = "OPERACOES";
	private static final String OPERACAO_OUTPUT_GARANTIA_TMP = "Garantia_tmp.txt";
	private static final String OPERACAO_OUTPUT_OPERACAO_TMP = "Operacao_tmp.txt";
	private static final String OPERACAO_OUTPUT_INF_AD_TMP = "Agregacao_tmp.txt";
	private static CriarArquivosOperacaoService S_INSTANCE;
	
	/**
	 * 
	 * @return
	 */
	public static CriarArquivosOperacaoService getInstance() {
		if(S_INSTANCE==null){
			S_INSTANCE = new CriarArquivosOperacaoService();
		}
		return S_INSTANCE;
	}
	
	private CriarArquivosOperacaoService() {
	}
	
	/**
	 * Criar arquivo de Clientes
	 * @param doc3040
	 * @param arquivoCliente 
	 */
	public void criarArquivoOperacao(Doc3040 doc3040, Map<String, String> arquivoCliente) {
		String fileOutput = Constants.OPERACAO_OUTPUT;

		//Criar arquivo Reader
		String header = headerOfFile(doc3040.getDtBase(),OPERACAO_HEADER_FILE,633);
		
		List<OperacaoTO> lista = criarOperacoes(doc3040, arquivoCliente);
		
		//Gerar arquivo
		criarArquivoTxt(OPERACAO_OUTPUT_OPERACAO_TMP, lista, OperacaoTO.class, header, null);

		//Gera  o arquivo de garantia
		Constants.i = criarArquivoGarantia(doc3040, Constants.i, arquivoCliente);

		//Gera  o arquivo de garantia
		Constants.i = criarArquivoInfAdicional(doc3040, Constants.i, arquivoCliente);
		
		Utiliarios.mergeFiles(new String[]{
				OPERACAO_OUTPUT_OPERACAO_TMP,
				OPERACAO_OUTPUT_GARANTIA_TMP,
				OPERACAO_OUTPUT_INF_AD_TMP}, 
				fileOutput);
		
		//Criar arquivo trailler
		String trailler = traillerOfFile(String.format(PATTERN_6_ZEROS_ESQUERDA, ++Constants.i),652);
		
		writeFooter(fileOutput, trailler);
	}

	/**
	 * Cria as operações
	 * @param doc3040
	 * @param arquivoCliente
	 * @return
	 */
	private List<OperacaoTO> criarOperacoes(Doc3040 doc3040, Map<String, String> arquivoCliente) {
		/*Lista de Operacoes*/
		List<OperacaoTO> lista = new ArrayList<OperacaoTO>();
		List<Cli> clientes = doc3040.getCli();
		
		for (Cli cli : clientes) {
			for (Op op : cli.getOp()) {
				OperacaoTO operacao = new OperacaoTO();
				operacao.setSequencial((++Constants.i).toString());
				operacao.setiDRegistro(_1);
				operacao.setCpfCnpjCliente(obterClienteByKey(cli.getCd().toString(),arquivoCliente));
				operacao.setOrigemImportacao(_4);
				operacao.setNumeroContrato(op.getContrt());
				operacao.setTaxaReferencial(doubleToStrWithoutDot(op.getIndx().doubleValue()));
				operacao.setAutorizacao(cli.getAutorzc());
				operacao.setFiller(FILLER);
				operacao.setRegiaoBAcen(REGIAO_BACEN);
				operacao.setcEP(op.getCEP().toString());
				operacao.setiDOrigemRecursoOpCred(op.getOrigemRec().toString());
				String modulo = op.getMod().toString();
				operacao.setiDModOperacao(modulo.substring(0, 2));
				operacao.setiDSubModOperacao(modulo.substring(2, 4));
				operacao.setiDNivelRisco(op.getClassOp());
				operacao.setPercTaxaJuros(FILLER); //Vazio pois não encontrei.
				operacao.setDataContratacao(op.getDtContr().toGregorianCalendar().getTime());
				operacao.setDataVencimento(op.getDtVencOp().toGregorianCalendar().getTime());
				operacao.setSaldoDevedor("0"); //Somar os valores dos vencimentos.
				operacao.setNaturezaOperacao(op.getNatuOp().toString());
				operacao.setProvisaoRisco(doubleToStrWithoutDot(op.getProvConsttd()));
				
				List<Object> vencOrGarOrInf = op.getVencOrGarOrInf();
				
				for (Object object : vencOrGarOrInf) {
					if(object instanceof Venc){
						Venc v = (Venc)object;
						operacao.setVencerAte30(doubleToStrWithoutDot(v.getV110()));
						operacao.setVencerAte31a60(doubleToStrWithoutDot(v.getV120()));
						operacao.setVencerAte61a90(doubleToStrWithoutDot(v.getV130()));
						operacao.setVencerAte91a180(doubleToStrWithoutDot(v.getV140()));
						operacao.setVencerAte361a720(doubleToStrWithoutDot(v.getV160()));
						operacao.setVencerAte721a1080(doubleToStrWithoutDot(v.getV165()));						
						operacao.setVencerAte1081a1440(doubleToStrWithoutDot(v.getV170()));
						operacao.setVencerAte1441a1800(_0);
						operacao.setVencerAte1801a5400(_0);
						operacao.setVencerAcima5400(_0);
						operacao.setVencerIndeterminado(_0);
						operacao.setVencidosde1a14(doubleToStrWithoutDot(v.getV205()));
						operacao.setVencidosde15a30(doubleToStrWithoutDot(v.getV210()));
						operacao.setVencidosde31a60(doubleToStrWithoutDot(v.getV220()));
						operacao.setVencidosde61a90(doubleToStrWithoutDot(v.getV230()));
						operacao.setVencidosde91a120(doubleToStrWithoutDot(v.getV240()));
						operacao.setVencidosde121a150(doubleToStrWithoutDot(v.getV245()));
						operacao.setVencidosde151a180(doubleToStrWithoutDot(v.getV250()));
						operacao.setVencidosde181a240(doubleToStrWithoutDot(v.getV255()));
						operacao.setVencidosde241a300(doubleToStrWithoutDot(v.getV260()));
						operacao.setVencidosde301a360(doubleToStrWithoutDot(v.getV270()));
						operacao.setVencidosde361a540(_0);
						operacao.setVencidoAcima540(_0);
						operacao.setValbaixadosprejate12(_0);
						operacao.setValbaixadosprejde12a48(doubleToStrWithoutDot(v.getV320()));
						operacao.setValbaixadosprejMaior48(doubleToStrWithoutDot(v.getV330()));
					}
				}
				
				operacao.setLimiteAte360Dias(_0);
				operacao.setLimiteAcima360Dias(_0);
				operacao.setCreditoALiberarAte360Dias(_0);
				operacao.setCreditoALiberarAcima360(_0);
				operacao.setCosif((op.getCosif().split(";").length>0?op.getCosif().split(";")[0]:op.getCosif()));
				operacao.setPercIndexador(doubleToStrWithoutDot(op.getPercIndx().doubleValue()));
				operacao.setValorContratado(doubleToStrWithoutDot(op.getVlrContr()));
				operacao.setDiasAtraso((op.getDiaAtraso()==null?_0:op.getDiaAtraso().toString()));
				operacao.setTaxaEfetivaAnual(doubleToStrWithoutDot(op.getTaxEft()));
				operacao.setFiller_end(FILLER);
				lista.add(operacao);
			}
			
		}
		return lista;
	}
	
	/**
	 * Metodo gera a Criação da Garantia
	 * 
	 * @param doc3040
	 * @param arquivoCliente 
	 */
	private Integer criarArquivoGarantia(Doc3040 doc3040,Integer y, Map<String, String> arquivoCliente) {
		/* Lista de Operacoes */
		List<GarantiaTO> lista = new ArrayList<GarantiaTO>();
		List<Cli> clientes = doc3040.getCli();

		for (Cli cli : clientes) {
			for (Op op : cli.getOp()) {
				for (Object object : op.getVencOrGarOrInf()) {
					if (object instanceof Gar) {
						Gar g = (Gar) object;
						GarantiaTO garantia = new GarantiaTO();
						
						garantia.setSequencial((++y).toString());
						garantia.setiDRegistro(_2);
						garantia.setiDTipoGarantia(String.format(PATTERN_4_ZEROS_ESQUERDA,g.getTp()).substring(0, 2));
						garantia.setiDSubTipoGarantia(String.format(PATTERN_4_ZEROS_ESQUERDA,g.getTp()).substring(2, 4));
						garantia.setCpfCnpjCliente(g.getIdent().toString());
						garantia.setDescNomeGarantidor(FILLER); //Não tinha nome no xml
						garantia.setPercGarantia(doubleToStrWithoutDot(g.getPercGar()));
						garantia.setValorOriGarantia(_0);
						garantia.setValorAtualGarantia(_0);
						garantia.setDataReavaliacao(new Date(0));
						garantia.setCpfCnpjCliente(obterClienteByKey(cli.getCd().toString(),arquivoCliente));
						garantia.setNumeroContrato(op.getContrt());
						garantia.setFiller(FILLER);
						garantia.setFiller_end(_0);
						
						lista.add(garantia);
					}
				}
			}
		}
		
		//Gerar arquivo
		criarArquivoTxt( OPERACAO_OUTPUT_GARANTIA_TMP, lista, GarantiaTO.class, null, null);
		
		return y;
	}

	/**
	 * Metodo gera a Criação das Informações adicionais
	 * 
	 * @param doc3040
	 * @param arquivoCliente 
	 */
	private Integer criarArquivoInfAdicional(Doc3040 doc3040,Integer y, Map<String, String> arquivoCliente) {
		/* Lista de Operacoes */
		List<InformacaoAdicionalTO> lista = new ArrayList<InformacaoAdicionalTO>();
		List<Cli> clientes = doc3040.getCli();
		
		for (Cli cli : clientes) {
			for (Op op : cli.getOp()) {
				for (Object object : op.getVencOrGarOrInf()) {
					if (object instanceof Inf) {
						Inf f = (Inf) object;
						InformacaoAdicionalTO infAd = new InformacaoAdicionalTO();
						
						infAd.setSequencial((++y).toString());
						infAd.setiDRegistro(_3);
						infAd.setiDTipoInformacao(String.format(PATTERN_4_ZEROS_ESQUERDA,f.getTp()).substring(0, 2));
						infAd.setiDSubTipoInformacao(String.format(PATTERN_4_ZEROS_ESQUERDA,f.getTp()).substring(2, 4));
						infAd.setDescCodigo(f.getCd());
						infAd.setDescIdentifi(FILLER); //Nenhuma tag do xml tem está informação.
						infAd.setValor(_0); //Não tem no xml
						infAd.setPercentual(_0); //Não tem no xml
						infAd.setQtdRegistros(_0); //Não tem no xml está vazio
						infAd.setCpfCnpjCliente(obterClienteByKey(cli.getCd().toString(),arquivoCliente));
						infAd.setNumeroContrato(op.getContrt());
						infAd.setFiller(FILLER);
						infAd.setFiller_end(_0);
						
						lista.add(infAd);
					}
				}
			}
		}
		
		//Gerar arquivo
		criarArquivoTxt( OPERACAO_OUTPUT_INF_AD_TMP, lista, InformacaoAdicionalTO.class, null, null);
		
		return y;
	}
}
