package br.com.alelo.qa.data.entity;

public class TransacoesAprovadas {

	private String data;
	private String valorBruto;
	private String taxaDesconto;

	public TransacoesAprovadas(String data, String valorBruto, String taxaDesconto) {
		super();
		this.data = data;
		this.valorBruto = valorBruto;
		this.taxaDesconto = taxaDesconto;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(String valorBruto) {
		this.valorBruto = valorBruto;
	}

	public String getTaxaDesconto() {
		return taxaDesconto;
	}

	public void setTaxaDesconto(String taxaDesconto) {
		this.taxaDesconto = taxaDesconto;
	}

	@Override
	public String toString() {
		return "TransacoesAprovadasDTO [data=" + data + ", valorBruto=" + valorBruto + ", taxaDesconto=" + taxaDesconto
				+ "]";
	}

}
