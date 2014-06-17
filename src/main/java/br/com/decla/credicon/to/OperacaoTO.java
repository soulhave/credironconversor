package br.com.decla.credicon.to;

import java.util.Date;

import org.coury.jfilehelpers.annotations.FieldAlign;
import org.coury.jfilehelpers.annotations.FieldConverter;
import org.coury.jfilehelpers.annotations.FieldFixedLength;
import org.coury.jfilehelpers.annotations.FixedLengthRecord;
import org.coury.jfilehelpers.enums.AlignMode;
import org.coury.jfilehelpers.enums.ConverterKind;

@FixedLengthRecord()
public class OperacaoTO {
	
	@FieldFixedLength(6)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String sequencial; //Tipo N - Tamanho 6 - Decimais  # Posição 1-6 #
	@FieldFixedLength(1)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String iDRegistro; //Tipo N - Tamanho 1 - Decimais  # Posição 7-7 #Identificação Registro
	@FieldFixedLength(2)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String iDProduto; //Tipo N - Tamanho 2 - Decimais  # Posição 8-9 #Código de Identificação do produto
	@FieldFixedLength(14)
	@FieldAlign(alignMode=AlignMode.Left)
	private String cpfCnpjCliente; //Tipo A - Tamanho 14 - Decimais  # Posição 10-23 # Identificação do cliente (CPF, CNPJ)
	@FieldFixedLength(1)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String origemImportacao; //Tipo N - Tamanho 1 - Decimais  # Posição 24-24 # Origem da Informação
	@FieldFixedLength(40)
	@FieldAlign(alignMode=AlignMode.Left)
	private String numeroContrato; //Tipo A - Tamanho 40 - Decimais  # Posição 25-64 #Código de identificação do contrato. 
	@FieldFixedLength(2)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String taxaReferencial; //Tipo N - Tamanho 2 - Decimais  # Posição 65-66 #Taxa referencial ou Indexador
	@FieldFixedLength(1)
	@FieldAlign(alignMode=AlignMode.Left)
	private String autorizacao; //Tipo A - Tamanho 1 - Decimais  # Posição 67-67 #Autorização para consulta na central de risco
	@FieldFixedLength(1)
	@FieldAlign(alignMode=AlignMode.Left)
	private String filler; //Tipo A - Tamanho 1 - Decimais  # Posição 68-68 #Espaços em branco
	@FieldFixedLength(5)
	@FieldAlign(alignMode=AlignMode.Left)
	private String regiaoBAcen; //Tipo A - Tamanho 5 - Decimais  # Posição 69-73 #Código identificador da Unidade da Federação da dependência de concessão das operações
	@FieldFixedLength(8)
	@FieldAlign(alignMode=AlignMode.Left)
	private String cEP; //Tipo A - Tamanho 8 - Decimais  # Posição 74-81 #Código de Endereçamento Postal da dependência de concessão da operação
	@FieldFixedLength(4)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String iDOrigemRecursoOpCred; //Tipo N - Tamanho 4 - Decimais  # Posição 82-85 #Código identificador da origem dos recursos da operação
	@FieldFixedLength(2)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String iDModOperacao; //Tipo N - Tamanho 2 - Decimais  # Posição 86-87 #Domínio da Modalidade da operação
	@FieldFixedLength(2)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String iDSubModOperacao; //Tipo N - Tamanho 2 - Decimais  # Posição 88-89 #SubDomínio da Modalidade da operação
	@FieldFixedLength(2)
	@FieldAlign(alignMode=AlignMode.Left)
	private String iDNivelRisco; //Tipo A - Tamanho 2 - Decimais  # Posição 90-91 #Classificação de risco da operação, nos níveis previstos na Res. 2682/99 e 'HH' para créditos baixados como prejuízo
	@FieldFixedLength(7)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String percTaxaJuros; //Tipo N - Tamanho 7 - Decimais 4 # Posição 92-98 #Taxa efetiva equivalente aos juros pré-fixados incidentes no curso normal da operação, calculada considerando-se dias corridos
    @FieldFixedLength(8)
    @FieldConverter(converter = ConverterKind.Date, format = "yyyyMMdd")
	private Date dataContratacao; //Tipo D - Tamanho 8 - Decimais  # Posição 99-106 #Data de contratação da operação.
    @FieldFixedLength(8)
    @FieldConverter(converter = ConverterKind.Date, format = "yyyyMMdd")
    private Date dataVencimento; //Tipo D - Tamanho 8 - Decimais  # Posição 107-114 #Data de pagamento da última parcela ou de expiração do contrato. Quando não informado indica data de vencimento indeterminada (Formato AAAA-MM-DD) no intervalo > 31/12/1900 e < 01/01/2050
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String saldoDevedor; //Tipo N - Tamanho 15 - Decimais 2 # Posição 115-129 #Saldo devedor contábil, deve ser igual a soma dos vencimentos informados excetuando limites e credito a liberar
	@FieldFixedLength(2)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String naturezaOperacao; //Tipo N - Tamanho 2 - Decimais  # Posição 130-131 #Código identificador da natureza da operação
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String provisaoRisco; //Tipo N - Tamanho 15 - Decimais 2 # Posição 132-146 #Valor da provisão constituída. Será pedida para todas as operações. Informar inclusive o valor Zero (0) quando for o caso
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String vencerAte30 ; //Tipo N - Tamanho 15 - Decimais 2 # Posição 147-161 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String vencerAte31a60; //Tipo N - Tamanho 15 - Decimais 2 # Posição 162-176 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String vencerAte61a90; //Tipo N - Tamanho 15 - Decimais 2 # Posição 177-191 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String vencerAte91a180; //Tipo N - Tamanho 15 - Decimais 2 # Posição 192-206 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String vencerAte181a360; //Tipo N - Tamanho 15 - Decimais 2 # Posição 207-221 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String vencerAte361a720; //Tipo N - Tamanho 15 - Decimais 2 # Posição 222-236 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String vencerAte721a1080; //Tipo N - Tamanho 15 - Decimais 2 # Posição 237-251 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String vencerAte1081a1440; //Tipo N - Tamanho 15 - Decimais 2 # Posição 252-266 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String vencerAte1441a1800; //Tipo N - Tamanho 15 - Decimais 2 # Posição 267-281 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String vencerAte1801a5400; //Tipo N - Tamanho 15 - Decimais 2 # Posição 282-296 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')	
	private String vencerAcima5400; //Tipo N - Tamanho 15 - Decimais 2 # Posição 297-311 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')	
	private String vencerIndeterminado; //Tipo N - Tamanho 15 - Decimais 2 # Posição 312-326 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String vencidosde1a14; //Tipo N - Tamanho 15 - Decimais 2 # Posição 327-341 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String vencidosde15a30; //Tipo N - Tamanho 15 - Decimais 2 # Posição 342-356 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String vencidosde31a60; //Tipo N - Tamanho 15 - Decimais 2 # Posição 357-371 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String vencidosde61a90; //Tipo N - Tamanho 15 - Decimais 2 # Posição 372-386 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String vencidosde91a120; //Tipo N - Tamanho 15 - Decimais 2 # Posição 387-401 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String vencidosde121a150; //Tipo N - Tamanho 15 - Decimais 2 # Posição 402-416 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String vencidosde151a180; //Tipo N - Tamanho 15 - Decimais 2 # Posição 417-431 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String vencidosde181a240; //Tipo N - Tamanho 15 - Decimais 2 # Posição 432-446 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String vencidosde241a300; //Tipo N - Tamanho 15 - Decimais 2 # Posição 447-461 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String vencidosde301a360; //Tipo N - Tamanho 15 - Decimais 2 # Posição 462-476 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String vencidosde361a540; //Tipo N - Tamanho 15 - Decimais 2 # Posição 477-491 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String vencidoAcima540; //Tipo N - Tamanho 15 - Decimais 2 # Posição 492-506 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String valbaixadosprejate12; //Tipo N - Tamanho 15 - Decimais 2 # Posição 507-521 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String valbaixadosprejde12a48; //Tipo N - Tamanho 15 - Decimais 2 # Posição 522-536 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String valbaixadosprejMaior48; //Tipo N - Tamanho 15 - Decimais 2 # Posição 537-551 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String limiteAte360Dias; //Tipo N - Tamanho 15 - Decimais 2 # Posição 552-566 #Limite de crédito com vencimento até 360 dias 
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String limiteAcima360Dias; //Tipo N - Tamanho 15 - Decimais 2 # Posição 567-581 #Limite de crédito com vencimento acima de 360 dias 
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String creditoALiberarAte360Dias; //Tipo N - Tamanho 15 - Decimais 2 # Posição 582-596 #Créditos a liberar até 360 dias 
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String creditoALiberarAcima360; //Tipo N - Tamanho 15 - Decimais 2 # Posição 597-611 #Créditos a liberar acima de 360 dias 
	@FieldFixedLength(8)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String cosif; //Tipo N - Tamanho 8 - Decimais  # Posição 612-619 #Conta cosif
	@FieldFixedLength(5)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String percIndexador; //Tipo N - Tamanho 5 - Decimais 2 # Posição 620-624 #Percentual praticado pela instituição em relação ao indexador da operação de crédito.
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String valorContratado; //Tipo N - Tamanho 15 - Decimais 2 # Posição 625-639 #Valor contratado da operação 
	@FieldFixedLength(6)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String diasAtraso; //Tipo N - Tamanho 6 - Decimais  # Posição 640-645 #Saldo devedor (parcelas ainda não pagas) do PRINCIPAL do contrato sem correção (incluindo créditos a liberar, se houver).
	@FieldFixedLength(7)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String taxaEfetivaAnual; //Tipo N - Tamanho 7 - Decimais 4 # Posição 646-652 #Taxa efetiva anualizada equivalente aos juros pré-fixados incidentes no curso normal da operação, calculada considerando-se dias corridos
	@FieldFixedLength(8)
	@FieldAlign(alignMode=AlignMode.Left)
	private String filler_end; //Tipo A - Tamanho 8 - Decimais  # Posição 653-660 #Espaços em branco
	
	public String getSequencial() {
		return sequencial;
	}
	public void setSequencial(String sequencial) {
		this.sequencial = sequencial;
	}
	public String getiDRegistro() {
		return iDRegistro;
	}
	public void setiDRegistro(String iDRegistro) {
		this.iDRegistro = iDRegistro;
	}
	public String getiDProduto() {
		return iDProduto;
	}
	public void setiDProduto(String iDProduto) {
		this.iDProduto = iDProduto;
	}
	public String getCpfCnpjCliente() {
		return cpfCnpjCliente;
	}
	public void setCpfCnpjCliente(String cpfCnpjCliente) {
		this.cpfCnpjCliente = cpfCnpjCliente;
	}
	public String getOrigemImportacao() {
		return origemImportacao;
	}
	public void setOrigemImportacao(String origemImportacao) {
		this.origemImportacao = origemImportacao;
	}
	public String getNumeroContrato() {
		return numeroContrato;
	}
	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}
	public String getTaxaReferencial() {
		return taxaReferencial;
	}
	public void setTaxaReferencial(String taxaReferencial) {
		this.taxaReferencial = taxaReferencial;
	}
	public String getAutorizacao() {
		return autorizacao;
	}
	public void setAutorizacao(String autorizacao) {
		this.autorizacao = autorizacao;
	}
	public String getFiller() {
		return filler;
	}
	public void setFiller(String filler) {
		this.filler = filler;
	}
	public String getRegiaoBAcen() {
		return regiaoBAcen;
	}
	public void setRegiaoBAcen(String regiaoBAcen) {
		this.regiaoBAcen = regiaoBAcen;
	}
	public String getcEP() {
		return cEP;
	}
	public void setcEP(String cEP) {
		this.cEP = cEP;
	}
	public String getiDOrigemRecursoOpCred() {
		return iDOrigemRecursoOpCred;
	}
	public void setiDOrigemRecursoOpCred(String iDOrigemRecursoOpCred) {
		this.iDOrigemRecursoOpCred = iDOrigemRecursoOpCred;
	}
	public String getiDModOperacao() {
		return iDModOperacao;
	}
	public void setiDModOperacao(String iDModOperacao) {
		this.iDModOperacao = iDModOperacao;
	}
	public String getiDSubModOperacao() {
		return iDSubModOperacao;
	}
	public void setiDSubModOperacao(String iDSubModOperacao) {
		this.iDSubModOperacao = iDSubModOperacao;
	}
	public String getiDNivelRisco() {
		return iDNivelRisco;
	}
	public void setiDNivelRisco(String iDNivelRisco) {
		this.iDNivelRisco = iDNivelRisco;
	}
	public String getPercTaxaJuros() {
		return percTaxaJuros;
	}
	public void setPercTaxaJuros(String percTaxaJuros) {
		this.percTaxaJuros = percTaxaJuros;
	}
	public Date getDataContratacao() {
		return dataContratacao;
	}
	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public String getSaldoDevedor() {
		return saldoDevedor;
	}
	public void setSaldoDevedor(String saldoDevedor) {
		this.saldoDevedor = saldoDevedor;
	}
	public String getNaturezaOperacao() {
		return naturezaOperacao;
	}
	public void setNaturezaOperacao(String naturezaOperacao) {
		this.naturezaOperacao = naturezaOperacao;
	}
	public String getProvisaoRisco() {
		return provisaoRisco;
	}
	public void setProvisaoRisco(String provisaoRisco) {
		this.provisaoRisco = provisaoRisco;
	}
	public String getVencerAte30() {
		return vencerAte30;
	}
	public void setVencerAte30(String vencerAte30) {
		this.vencerAte30 = vencerAte30;
	}
	public String getVencerAte31a60() {
		return vencerAte31a60;
	}
	public void setVencerAte31a60(String vencerAte31a60) {
		this.vencerAte31a60 = vencerAte31a60;
	}
	public String getVencerAte61a90() {
		return vencerAte61a90;
	}
	public void setVencerAte61a90(String vencerAte61a90) {
		this.vencerAte61a90 = vencerAte61a90;
	}
	public String getVencerAte91a180() {
		return vencerAte91a180;
	}
	public void setVencerAte91a180(String vencerAte91a180) {
		this.vencerAte91a180 = vencerAte91a180;
	}
	public String getVencerAte181a360() {
		return vencerAte181a360;
	}
	public void setVencerAte181a360(String vencerAte181a360) {
		this.vencerAte181a360 = vencerAte181a360;
	}
	public String getVencerAte361a720() {
		return vencerAte361a720;
	}
	public void setVencerAte361a720(String vencerAte361a720) {
		this.vencerAte361a720 = vencerAte361a720;
	}
	public String getVencerAte721a1080() {
		return vencerAte721a1080;
	}
	public void setVencerAte721a1080(String vencerAte721a1080) {
		this.vencerAte721a1080 = vencerAte721a1080;
	}
	public String getVencerAte1081a1440() {
		return vencerAte1081a1440;
	}
	public void setVencerAte1081a1440(String vencerAte1081a1440) {
		this.vencerAte1081a1440 = vencerAte1081a1440;
	}
	public String getVencerAte1441a1800() {
		return vencerAte1441a1800;
	}
	public void setVencerAte1441a1800(String vencerAte1441a1800) {
		this.vencerAte1441a1800 = vencerAte1441a1800;
	}
	public String getVencerAte1801a5400() {
		return vencerAte1801a5400;
	}
	public void setVencerAte1801a5400(String vencerAte1801a5400) {
		this.vencerAte1801a5400 = vencerAte1801a5400;
	}
	public String getVencerAcima5400() {
		return vencerAcima5400;
	}
	public void setVencerAcima5400(String vencerAcima5400) {
		this.vencerAcima5400 = vencerAcima5400;
	}
	public String getVencerIndeterminado() {
		return vencerIndeterminado;
	}
	public void setVencerIndeterminado(String vencerIndeterminado) {
		this.vencerIndeterminado = vencerIndeterminado;
	}
	public String getVencidosde1a14() {
		return vencidosde1a14;
	}
	public void setVencidosde1a14(String vencidosde1a14) {
		this.vencidosde1a14 = vencidosde1a14;
	}
	public String getVencidosde15a30() {
		return vencidosde15a30;
	}
	public void setVencidosde15a30(String vencidosde15a30) {
		this.vencidosde15a30 = vencidosde15a30;
	}
	public String getVencidosde31a60() {
		return vencidosde31a60;
	}
	public void setVencidosde31a60(String vencidosde31a60) {
		this.vencidosde31a60 = vencidosde31a60;
	}
	public String getVencidosde61a90() {
		return vencidosde61a90;
	}
	public void setVencidosde61a90(String vencidosde61a90) {
		this.vencidosde61a90 = vencidosde61a90;
	}
	public String getVencidosde91a120() {
		return vencidosde91a120;
	}
	public void setVencidosde91a120(String vencidosde91a120) {
		this.vencidosde91a120 = vencidosde91a120;
	}
	public String getVencidosde121a150() {
		return vencidosde121a150;
	}
	public void setVencidosde121a150(String vencidosde121a150) {
		this.vencidosde121a150 = vencidosde121a150;
	}
	public String getVencidosde151a180() {
		return vencidosde151a180;
	}
	public void setVencidosde151a180(String vencidosde151a180) {
		this.vencidosde151a180 = vencidosde151a180;
	}
	public String getVencidosde181a240() {
		return vencidosde181a240;
	}
	public void setVencidosde181a240(String vencidosde181a240) {
		this.vencidosde181a240 = vencidosde181a240;
	}
	public String getVencidosde241a300() {
		return vencidosde241a300;
	}
	public void setVencidosde241a300(String vencidosde241a300) {
		this.vencidosde241a300 = vencidosde241a300;
	}
	public String getVencidosde301a360() {
		return vencidosde301a360;
	}
	public void setVencidosde301a360(String vencidosde301a360) {
		this.vencidosde301a360 = vencidosde301a360;
	}
	public String getVencidosde361a540() {
		return vencidosde361a540;
	}
	public void setVencidosde361a540(String vencidosde361a540) {
		this.vencidosde361a540 = vencidosde361a540;
	}
	public String getVencidoAcima540() {
		return vencidoAcima540;
	}
	public void setVencidoAcima540(String vencidoAcima540) {
		this.vencidoAcima540 = vencidoAcima540;
	}
	public String getValbaixadosprejate12() {
		return valbaixadosprejate12;
	}
	public void setValbaixadosprejate12(String valbaixadosprejate12) {
		this.valbaixadosprejate12 = valbaixadosprejate12;
	}
	public String getValbaixadosprejde12a48() {
		return valbaixadosprejde12a48;
	}
	public void setValbaixadosprejde12a48(String valbaixadosprejde12a48) {
		this.valbaixadosprejde12a48 = valbaixadosprejde12a48;
	}
	public String getValbaixadosprejMaior48() {
		return valbaixadosprejMaior48;
	}
	public void setValbaixadosprejMaior48(String valbaixadosprejMaior48) {
		this.valbaixadosprejMaior48 = valbaixadosprejMaior48;
	}
	public String getLimiteAte360Dias() {
		return limiteAte360Dias;
	}
	public void setLimiteAte360Dias(String limiteAte360Dias) {
		this.limiteAte360Dias = limiteAte360Dias;
	}
	public String getLimiteAcima360Dias() {
		return limiteAcima360Dias;
	}
	public void setLimiteAcima360Dias(String limiteAcima360Dias) {
		this.limiteAcima360Dias = limiteAcima360Dias;
	}
	public String getCreditoALiberarAte360Dias() {
		return creditoALiberarAte360Dias;
	}
	public void setCreditoALiberarAte360Dias(String creditoALiberarAte360Dias) {
		this.creditoALiberarAte360Dias = creditoALiberarAte360Dias;
	}
	public String getCreditoALiberarAcima360() {
		return creditoALiberarAcima360;
	}
	public void setCreditoALiberarAcima360(String creditoALiberarAcima360) {
		this.creditoALiberarAcima360 = creditoALiberarAcima360;
	}
	public String getCosif() {
		return cosif;
	}
	public void setCosif(String cosif) {
		this.cosif = cosif;
	}
	public String getPercIndexador() {
		return percIndexador;
	}
	public void setPercIndexador(String percIndexador) {
		this.percIndexador = percIndexador;
	}
	public String getValorContratado() {
		return valorContratado;
	}
	public void setValorContratado(String valorContratado) {
		this.valorContratado = valorContratado;
	}
	public String getDiasAtraso() {
		return diasAtraso;
	}
	public void setDiasAtraso(String diasAtraso) {
		this.diasAtraso = diasAtraso;
	}
	public String getTaxaEfetivaAnual() {
		return taxaEfetivaAnual;
	}
	public void setTaxaEfetivaAnual(String taxaEfetivaAnual) {
		this.taxaEfetivaAnual = taxaEfetivaAnual;
	}
	public String getFiller_end() {
		return filler_end;
	}
	public void setFiller_end(String filler_end) {
		this.filler_end = filler_end;
	}

}
