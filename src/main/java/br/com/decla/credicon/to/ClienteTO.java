package br.com.decla.credicon.to;

import java.util.Date;

import org.coury.jfilehelpers.annotations.FieldAlign;
import org.coury.jfilehelpers.annotations.FieldConverter;
import org.coury.jfilehelpers.annotations.FieldFixedLength;
import org.coury.jfilehelpers.annotations.FieldTrim;
import org.coury.jfilehelpers.annotations.FixedLengthRecord;
import org.coury.jfilehelpers.enums.AlignMode;
import org.coury.jfilehelpers.enums.ConverterKind;
import org.coury.jfilehelpers.enums.TrimMode;

@FixedLengthRecord()
public class ClienteTO {
	
	@FieldFixedLength(6)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String sequencial; //Tipo N - Tamanho 6 - Decimais  # Posicao 1-6 #
	@FieldFixedLength(1)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String iDRegistro; //Tipo N - Tamanho 1 - Decimais  # Posicao 7-7 #Identificacao Registro
	@FieldFixedLength(2)
	@FieldAlign(alignMode=AlignMode.Left)
	private String filler; //Tipo A - Tamanho 2 - Decimais  # Posicao 8-9 #Espaços em branco
	@FieldFixedLength(14)
	@FieldAlign(alignMode=AlignMode.Left)
	private String cpfCnpjCliente; //Tipo A - Tamanho 14 - Decimais  # Posicao 10-23 #Identificacao do cliente (CPF, CNPJ)
	@FieldFixedLength(1)
	@FieldAlign(alignMode=AlignMode.Left)
	private String porteCliente; //Tipo A - Tamanho 1 - Decimais  # Posicao 24-24 #Porte do Cliente
	@FieldFixedLength(2)
	@FieldAlign(alignMode=AlignMode.Left)
	private String filler_2; //Tipo A - Tamanho 2 - Decimais  # Posicao 25-26 #Espaços em branco
	@FieldFixedLength(2)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String tipoControle; //Tipo A - Tamanho 2 - Decimais  # Posicao 27-28 #identificador do tipo de controlador
	@FieldFixedLength(1)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String tipoPessoa; //Tipo N - Tamanho 1 - Decimais  # Posicao 29-29 #Tipo de Pessoa
	@FieldTrim(trimMode=TrimMode.Right)
    @FieldFixedLength(8)
    @FieldConverter(converter = ConverterKind.Date, format = "yyyyMMdd")
	private Date dataIncioRelacionamento; //Tipo D - Tamanho 8 - Decimais  # Posicao 30-37 #Data de abertura de conta corrente ou outra data considerada relevante para avaliacao do risco do crédito
	@FieldFixedLength(2)
	@FieldAlign(alignMode=AlignMode.Left)
	private String nivelRiscoCliente; //Tipo A - Tamanho 2 - Decimais  # Posicao 38-39 #Classificacao de Risco do Cliente
	@FieldFixedLength(1)
	@FieldAlign(alignMode=AlignMode.Left)
	private String autorizacao; //Tipo A - Tamanho 1 - Decimais  # Posicao 40-40 #Autorizacao para a consulta das informações do cliente no SCR
	@FieldFixedLength(16)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String faturamentoAnual; //Tipo N - Tamanho 16 - Decimais 2 # Posicao 41-56 #Faturamento anual PJ
	
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
	public String getFiller() {
		return filler;
	}
	public void setFiller(String filler) {
		this.filler = filler;
	}
	public String getCpfCnpjCliente() {
		return cpfCnpjCliente;
	}
	public void setCpfCnpjCliente(String cpfCnpjCliente) {
		this.cpfCnpjCliente = cpfCnpjCliente;
	}
	public String getPorteCliente() {
		return porteCliente;
	}
	public void setPorteCliente(String porteCliente) {
		this.porteCliente = porteCliente;
	}
	public String getFiller_2() {
		return filler_2;
	}
	public void setFiller_2(String filler_2) {
		this.filler_2 = filler_2;
	}
	public String getTipoControle() {
		return tipoControle;
	}
	public void setTipoControle(String tipoControle) {
		this.tipoControle = tipoControle;
	}
	public String getTpoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	public Date getDataIncioRelacionamento() {
		return dataIncioRelacionamento;
	}
	public void setDataIncioRelacionamento(Date dataIncioRelacionamento) {
		this.dataIncioRelacionamento = dataIncioRelacionamento;
	}
	public String getNivelRiscoCliente() {
		return nivelRiscoCliente;
	}
	public void setNivelRiscoCliente(String nivelRiscoCliente) {
		this.nivelRiscoCliente = nivelRiscoCliente;
	}
	public String getAutorizacao() {
		return autorizacao;
	}
	public void setAutorizacao(String autorizacao) {
		this.autorizacao = autorizacao;
	}
	public String getFaturamentoAnual() {
		return faturamentoAnual;
	}
	public void setFaturamentoAnual(String faturamentoAnual) {
		this.faturamentoAnual = faturamentoAnual;
	}

}
