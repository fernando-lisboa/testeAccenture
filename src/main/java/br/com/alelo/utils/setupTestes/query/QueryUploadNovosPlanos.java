package br.com.alelo.utils.setupTestes.query;

public class QueryUploadNovosPlanos {
	
	public StringBuilder retornaDeleteNovosPlanos() {
		StringBuilder sql = new StringBuilder(
				" DELETE TSGM_OFERT_NVOS_PLANO WHERE nu_cnpj IN (28339982000160)");
		return sql;
	}
	
	public StringBuilder retornaDeleteContratoSimulaca() {
		StringBuilder sql = new StringBuilder(
				" delete owadq.tsgm_contr where nu_cnpj = '28339982000160'");
		return sql;
	}
	
	public StringBuilder retornaInsertOFertaPlanosSimulacao() {
		StringBuilder sql = new StringBuilder("INSERT ALL ")
				.append(" INTO owadq.tsgm_ofert_nvos_plano(cd_ofert, cd_plano, cd_oper , nu_cnpj, dt_inic_vgcia, dt_fim_vgcia,cd_operacao)VALUES ((select max(cd_ofert)+1 from owadq.tsgm_ofert_nvos_plano), 2, 'I', '37491504000161', sysdate - 90, sysdate + 90, null)")
				.append(" SELECT 1 FROM DUAL ");
						return sql;
	}
	
	public StringBuilder retornaDeleteOfertaPlanosSimulacao() {
		StringBuilder sql = new StringBuilder(
				" DELETE owadq.tsgm_ofert_nvos_plano WHERE nu_cnpj IN (28339982000160)");
		return sql;
	}
	
	
	
}
