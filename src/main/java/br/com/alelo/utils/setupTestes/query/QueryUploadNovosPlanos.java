package br.com.alelo.utils.setupTestes.query;

public class QueryUploadNovosPlanos {
	
	public StringBuilder retornaDeleteNovosPlanos() {
		StringBuilder sql = new StringBuilder(
				" DELETE TSGM_OFERT_NVOS_PLANO WHERE nu_cnpj IN (27969660000999)");
		return sql;
	}
	
}
