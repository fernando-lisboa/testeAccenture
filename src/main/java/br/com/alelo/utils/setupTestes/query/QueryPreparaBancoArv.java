package br.com.alelo.utils.setupTestes.query;

public class QueryPreparaBancoArv {
	
	public StringBuilder roternaUpdateDataDeProcessmentoAM() {
		StringBuilder sql = new StringBuilder(
				"update OWADQ.TCFG_PROCM set DT_PROCM = sysdate");
		return sql;
	}
	
	public StringBuilder roternaUpdateDataDeProcessmentoPM() {
		StringBuilder sql = new StringBuilder(
				"update OWADQ.TCFG_PROCM set DT_PROCM = sysdate -1");
		return sql;
		
	}
	
	public StringBuilder roternaUpdateIdSolicitacao() {
		StringBuilder sql = new StringBuilder(
				"UPDATE owadq.tarv_rsumo_oper_dispn SET id_soltc = null WHERE id_pssoa_und =221592421");
		return sql;
		
	}

}
