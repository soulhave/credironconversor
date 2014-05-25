package br.com.decla.credicon.to;

import java.util.Date;

import org.coury.jfilehelpers.annotations.FieldAlign;
import org.coury.jfilehelpers.annotations.FieldConverter;
import org.coury.jfilehelpers.annotations.FieldFixedLength;
import org.coury.jfilehelpers.annotations.FieldNullValue;
import org.coury.jfilehelpers.annotations.FieldTrim;
import org.coury.jfilehelpers.annotations.FixedLengthRecord;
import org.coury.jfilehelpers.enums.AlignMode;
import org.coury.jfilehelpers.enums.ConverterKind;
import org.coury.jfilehelpers.enums.TrimMode;

@FixedLengthRecord()
public class GarantiaTO {
	
	@FieldFixedLength(6)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')	
	private String sequencial; //Tipo N - Tamanho 6 - Decimais  # Posição 1-6 #
	@FieldFixedLength(1)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')	
	private String iDRegistro; //Tipo N - Tamanho 1 - Decimais  # Posição 7-7 #
	@FieldFixedLength(2)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String iDTipoGarantia; //Tipo N - Tamanho 2 - Decimais  # Posição 8-9 #
	@FieldFixedLength(2)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String iDSubTipoGarantia; //Tipo N - Tamanho 2 - Decimais  # Posição 10-11 #
	@FieldFixedLength(14)
	@FieldAlign(alignMode=AlignMode.Left)	
	private String cPFCnpjGarantidor; //Tipo A - Tamanho 14 - Decimais  # Posição 12-25 #
	@FieldFixedLength(50)
	@FieldAlign(alignMode=AlignMode.Left)
	private String descNomeGarantidor; //Tipo A - Tamanho 50 - Decimais  # Posição 26-75 #
	@FieldFixedLength(7)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String percGarantia; //Tipo N - Tamanho 7 - Decimais 2 # Posição 76-82 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String valorOriGarantia; //Tipo N - Tamanho 15 - Decimais 2 # Posição 83-97 #
	@FieldFixedLength(15)
	@FieldAlign(alignMode=AlignMode.Right, alignChar='0')
	private String valorAtualGarantia; //Tipo N - Tamanho 15 - Decimais 2 # Posição 98-112 #
	@FieldTrim(trimMode=TrimMode.Right)
    @FieldFixedLength(8)
	@FieldNullValue(value="00000000")
    @FieldConverter(converter = ConverterKind.Date, format = "yyyyMMdd")
	private Date dataReavaliacao; //Tipo D - Tamanho 8 - Decimais  # Posição 113-120 #
	@FieldFixedLength(14)
	@FieldAlign(alignMode=AlignMode.Left)
	private String cpfCnpjCliente; //Tipo A - Tamanho 14 - Decimais  # Posição 120-133 #
	@FieldFixedLength(40)
	@FieldAlign(alignMode=AlignMode.Left)	
	private String numeroContrato; //Tipo A - Tamanho 40 - Decimais  # Posição 134-174 #
	@FieldFixedLength(485)
	@FieldAlign(alignMode=AlignMode.Left)
	private String filler; //Tipo A - Tamanho 485 - Decimais  # Posição 175-659 #
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
	public String getiDTipoGarantia() {
		return iDTipoGarantia;
	}
	public void setiDTipoGarantia(String iDTipoGarantia) {
		this.iDTipoGarantia = iDTipoGarantia;
	}
	public String getiDSubTipoGarantia() {
		return iDSubTipoGarantia;
	}
	public void setiDSubTipoGarantia(String iDSubTipoGarantia) {
		this.iDSubTipoGarantia = iDSubTipoGarantia;
	}
	public String getcPFCnpjGarantidor() {
		return cPFCnpjGarantidor;
	}
	public void setcPFCnpjGarantidor(String cPFCnpjGarantidor) {
		this.cPFCnpjGarantidor = cPFCnpjGarantidor;
	}
	public String getDescNomeGarantidor() {
		return descNomeGarantidor;
	}
	public void setDescNomeGarantidor(String descNomeGarantidor) {
		this.descNomeGarantidor = descNomeGarantidor;
	}
	public String getPercGarantia() {
		return percGarantia;
	}
	public void setPercGarantia(String percGarantia) {
		this.percGarantia = percGarantia;
	}
	public String getValorOriGarantia() {
		return valorOriGarantia;
	}
	public void setValorOriGarantia(String valorOriGarantia) {
		this.valorOriGarantia = valorOriGarantia;
	}
	public String getValorAtualGarantia() {
		return valorAtualGarantia;
	}
	public void setValorAtualGarantia(String valorAtualGarantia) {
		this.valorAtualGarantia = valorAtualGarantia;
	}
	public Date getDataReavaliacao() {
		return dataReavaliacao;
	}
	public void setDataReavaliacao(Date dataReavaliacao) {
		this.dataReavaliacao = dataReavaliacao;
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
