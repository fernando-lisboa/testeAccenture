package br.com.alelo.qa.data.entity;

public class VendasDetalhadas {

	private String descricao;
	private String numTransacao;
	private String numAutorizacao;
	private String credenciadora;
	private String numCartao;
	private String pagamento;
	private String valBruto;
	private String valLiquido;
	public VendasDetalhadas(String descricao, String numTransacao, String numAutorizacao, String credenciadora,
			String numCartao, String pagamento, String valBruto, String valLiquido) {
		this.descricao = descricao;
		this.numTransacao = numTransacao;
		this.numAutorizacao = numAutorizacao;
		this.credenciadora = credenciadora;
		this.numCartao = numCartao;
		this.pagamento = pagamento;
		this.valBruto = valBruto;
		this.valLiquido = valLiquido;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNumTransacao() {
		return numTransacao;
	}
	public void setNumTransacao(String numTransacao) {
		this.numTransacao = numTransacao;
	}
	public String getNumAutorizacao() {
		return numAutorizacao;
	}
	public void setNumAutorizacao(String numAutorizacao) {
		this.numAutorizacao = numAutorizacao;
	}
	public String getCredenciadora() {
		return credenciadora;
	}
	public void setCredenciadora(String credenciadora) {
		this.credenciadora = credenciadora;
	}
	public String getNumCartao() {
		return numCartao;
	}
	public void setNumCartao(String numCartao) {
		this.numCartao = numCartao;
	}
	public String getPagamento() {
		return pagamento;
	}
	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}
	public String getValBruto() {
		return valBruto;
	}
	public void setValBruto(String valBruto) {
		this.valBruto = valBruto;
	}
	public String getValLiquido() {
		return valLiquido;
	}
	public void setValLiquido(String valLiquido) {
		this.valLiquido = valLiquido;
	}
	@Override
	public String toString() {
		return "VendasDetalhadas [descricao=" + descricao + ", numTransacao=" + numTransacao + ", numAutorizacao="
				+ numAutorizacao + ", credenciadora=" + credenciadora + ", numCartao=" + numCartao + ", pagamento="
				+ pagamento + ", valBruto=" + valBruto + ", valLiquido=" + valLiquido + "]";
	}


}
