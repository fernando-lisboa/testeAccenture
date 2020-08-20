package br.com.alelo.qa.web.page;

public class ListaRetornoWebAdmin {
	public String CNPJ;
	public String Aplicativos;
	public String CodigoEC;
	public String Data;
	
	public ListaRetornoWebAdmin(String CNPJ, String Aplicativos, String CodigoEC, String Data)
	{
		this.CNPJ = CNPJ;
		this.Aplicativos = Aplicativos;
		this.CodigoEC = CodigoEC;
		this.Data = Data;
	}

	public String getCNPJ(){
		return CNPJ;
	}
	public String getAplicativos(){
		return Aplicativos;
	}
	public String getCodigoEC(){
		return CodigoEC;
	}
	public String getData(){
		return Data;
	}
}
