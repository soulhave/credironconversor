package br.com.decla.credicon.to;

import org.coury.jfilehelpers.annotations.FieldAlign;
import org.coury.jfilehelpers.annotations.FieldFixedLength;
import org.coury.jfilehelpers.annotations.FixedLengthRecord;
import org.coury.jfilehelpers.enums.AlignMode;

@FixedLengthRecord()
public class InformacaoAdicionalTO {
	@FieldFixedLength(6)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String sequencial; //Tipo N - Tamanho 6 - Decimais  # Posição 1-6 #
	@FieldFixedLength(1)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String iDRegistro; //Tipo N - Tamanho 1 - Decimais  # Posição 7-7 #
	@FieldFixedLength(2)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String iDTipoInformacao; //Tipo N - Tamanho 2 - Decimais  # Posição 8-9 #
	@FieldFixedLength(2)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String iDSubTipoInformacao; //Tipo N - Tamanho 2 - Decimais  # Posição 10-11 #
	@FieldFixedLength(40)
	@FieldAlign(alignMode=AlignMode.Left)
	private String descCodigo; //Tipo A - Tamanho 40 - Decimais  # Posição 12-51 #
	@FieldFixedLength(8)
	@FieldAlign(alignMode=AlignMode.Left)
	private String descIdentifi; //Tipo A - Tamanho 8 - Decimais  # Posição 52-59 #
	@FieldFixedLength(19)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String valor; //Tipo N - Tamanho 19 - Decimais 2 # Posição 60-78 #
	@FieldFixedLength(7)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String percentual; //Tipo N - Tamanho 7 - Decimais 2 # Posição 79-85 #
	@FieldFixedLength(9)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String qtdRegistros; //Tipo N - Tamanho 9 - Decimais  # Posição 86-94 #
	@FieldFixedLength(14)
	@FieldAlign(alignMode=AlignMode.Left)
	private String cpfCnpjCliente; //Tipo A - Tamanho 14 - Decimais  # Posição 95-108 #
	@FieldFixedLength(40)
	@FieldAlign(alignMode=AlignMode.Left)
	private String numeroContrato; //Tipo A - Tamanho 40 - Decimais  # Posição 109-148 #
	@FieldFixedLength(511)
	@FieldAlign(alignMode=AlignMode.Left)
	private String filler; //Tipo A - Tamanho 511 - Decimais  # Posição 149-659 #
	@FieldFixedLength(1)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String filler_end; //Tipo N - Tamanho 1 - Decimais  # Posição 660-660 #
	
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
	public String getiDTipoInformacao() {
		return iDTipoInformacao;
	}
	public void setiDTipoInformacao(String iDTipoInformacao) {
		this.iDTipoInformacao = iDTipoInformacao;
	}
	public String getiDSubTipoInformacao() {
		return iDSubTipoInformacao;
	}
	public void setiDSubTipoInformacao(String iDSubTipoInformacao) {
		this.iDSubTipoInformacao = iDSubTipoInformacao;
	}
	public String getDescCodigo() {
		return descCodigo;
	}
	public void setDescCodigo(String descCodigo) {
		this.descCodigo = descCodigo;
	}
	public String getDescIdentifi() {
		return descIdentifi;
	}
	public void setDescIdentifi(String descIdentifi) {
		this.descIdentifi = descIdentifi;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getPercentual() {
		return percentual;
	}
	public void setPercentual(String percentual) {
		this.percentual = percentual;
	}
	public String getQtdRegistros() {
		return qtdRegistros;
	}
	public void setQtdRegistros(String qtdRegistros) {
		this.qtdRegistros = qtdRegistros;
	}
	public String getCpfCnpjCliente() {
		return cpfCnpjCliente;
	}
	public void setCpfCnpjCliente(String cpfCnpjCliente) {
		this.cpfCnpjCliente = cpfCnpjCliente;
	}
	public String getNumeroContrato() {
		return numeroContrato;
	}
	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}
	public String getFiller() {
		return filler;
	}
	public void setFiller(String filler) {
		this.filler = filler;
	}
	public String getFiller_end() {
		return filler_end;
	}
	public void setFiller_end(String filler_end) {
		this.filler_end = filler_end;
	}

}
