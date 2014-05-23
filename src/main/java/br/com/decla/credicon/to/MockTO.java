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

@FixedLengthRecord
public class MockTO {
	@FieldAlign(alignMode=AlignMode.Left)
	@FieldFixedLength(6)
	private Integer id;
	@FieldFixedLength(30)
	@FieldAlign(alignMode=AlignMode.Left)
	private String nome;
	@FieldAlign(alignMode=AlignMode.Right, alignChar=0)
	@FieldFixedLength(15)
	@FieldConverter(converter = ConverterKind.Double, format=",")
	private Double numero;
	@FieldTrim(trimMode=TrimMode.Right)
	@FieldFixedLength(10)
	@FieldConverter(converter = ConverterKind.Date, format = "ddMMyyyy")
	private Date dataNasc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getNumero() {
		return numero;
	}

	public void setNumero(Double numero) {
		this.numero = numero;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
}
