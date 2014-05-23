package br.com.decla.credicon.to;

public class ClienteTO {
	
	private String sequencial; //Tipo N - Tamanho 6 - Decimais  # Posição 1-6 #
	private String iDRegistro; //Tipo N - Tamanho 1 - Decimais  # Posição 7-7 #Identificação Registro
	private String filler; //Tipo A - Tamanho 2 - Decimais  # Posição 8-9 #Espaços em branco
	private String cpfCnpjCliente; //Tipo A - Tamanho 14 - Decimais  # Posição 10-23 #Identificação do cliente (CPF, CNPJ)
	private String porteCliente; //Tipo A - Tamanho 1 - Decimais  # Posição 24-24 #Porte do Cliente
	private String filler_2; //Tipo A - Tamanho 2 - Decimais  # Posição 25-26 #Espaços em branco
	private String tipoControle; //Tipo A - Tamanho 2 - Decimais  # Posição 27-28 #identificador do tipo de controlador
	private String tpoPessoa; //Tipo N - Tamanho 1 - Decimais  # Posição 29-29 #Tipo de Pessoa
	private String dataIncioRelacionamento; //Tipo D - Tamanho 8 - Decimais  # Posição 30-37 #Data de abertura de conta corrente ou outra data considerada relevante para avaliação do risco do crédito
	private String nivelRiscoCliente; //Tipo A - Tamanho 2 - Decimais  # Posição 38-39 #Classificação de Risco do Cliente
	private String autorização; //Tipo A - Tamanho 1 - Decimais  # Posição 40-40 #Autorização para a consulta das informações do cliente no SCR
	private String faturamentoAnual; //Tipo N - Tamanho 16 - Decimais 2 # Posição 41-56 #Faturamento anual PJ
	
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
		return tpoPessoa;
	}
	public void setTpoPessoa(String tpoPessoa) {
		this.tpoPessoa = tpoPessoa;
	}
	public String getDataIncioRelacionamento() {
		return dataIncioRelacionamento;
	}
	public void setDataIncioRelacionamento(String dataIncioRelacionamento) {
		this.dataIncioRelacionamento = dataIncioRelacionamento;
	}
	public String getNivelRiscoCliente() {
		return nivelRiscoCliente;
	}
	public void setNivelRiscoCliente(String nivelRiscoCliente) {
		this.nivelRiscoCliente = nivelRiscoCliente;
	}
	public String getAutorização() {
		return autorização;
	}
	public void setAutorização(String autorização) {
		this.autorização = autorização;
	}
	public String getFaturamentoAnual() {
		return faturamentoAnual;
	}
	public void setFaturamentoAnual(String faturamentoAnual) {
		this.faturamentoAnual = faturamentoAnual;
	}

}
