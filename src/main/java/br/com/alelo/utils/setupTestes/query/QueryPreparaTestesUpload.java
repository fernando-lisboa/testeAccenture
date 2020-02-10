package br.com.alelo.utils.setupTestes.query;

public class QueryPreparaTestesUpload {
	
	public StringBuilder retornaInsertBloqueioContratoForaDoTesteGratis() {
		StringBuilder sql = new StringBuilder(
				" INSERT INTO TACS_CONTR_INDCD(ID_CONTR, NU_CNPJ, DT_INI_OFERT, DT_FIM_OFERT, DS_BLOQ, DT_CANCT, DT_BLOQ,nm_usuar_bloq) VALUES (SIBX_CONTR.nextval,'12259140000168', TO_DATE('2019/08/22 08:30:00', 'yyyy/mm/dd hh24:mi:ss') ,TO_DATE('2019/08/22 08:30:00', 'yyyy/mm/dd hh24:mi:ss'), 'N', null, '','') ");
		return sql;
	}
	
	
	public StringBuilder retornaInsertBloqueioContratoTestGratis() {
		StringBuilder sql = new StringBuilder(
				" INSERT INTO TACS_CONTR_INDCD(ID_CONTR, NU_CNPJ, DT_INI_OFERT, DT_FIM_OFERT, DS_BLOQ, DT_CANCT, DT_BLOQ,nm_usuar_bloq) VALUES (SIBX_CONTR.nextval,'28339982000160',	current_timestamp ,null, 'N', null, '','') ");
		return sql;
	}
	
	public StringBuilder retornaInsertBloqueioContratoCancelado() {
		StringBuilder sql = new StringBuilder(
				" INSERT INTO TACS_CONTR_INDCD(ID_CONTR, NU_CNPJ, DT_INI_OFERT, DT_FIM_OFERT, DS_BLOQ, DT_CANCT, DT_BLOQ,nm_usuar_bloq) VALUES (SIBX_CONTR.nextval,'28339982000160',current_timestamp ,current_timestamp, 'N', current_timestamp, '','') ");
		return sql;
	}
	
	public StringBuilder retornaInsertDesbloqueioContratoForaDoTesteGratis() {
		StringBuilder sql = new StringBuilder(
				" INSERT INTO TACS_CONTR_INDCD(ID_CONTR, NU_CNPJ, DT_INI_OFERT, DT_FIM_OFERT, DS_BLOQ, DT_CANCT, DT_BLOQ,nm_usuar_bloq) VALUES (SIBX_CONTR.nextval,'37491504000161', TO_DATE('2019/08/22 08:30:00', 'yyyy/mm/dd hh24:mi:ss') ,null, 'S', null, current_timestamp,'FERNANDO LISBOA') ");
		return sql;
	}
	
	
	public StringBuilder retornaInsertDesbloqueioContratoTestGratis() {
		StringBuilder sql = new StringBuilder(
				" INSERT INTO TACS_CONTR_INDCD(ID_CONTR, NU_CNPJ, DT_INI_OFERT, DT_FIM_OFERT, DS_BLOQ, DT_CANCT,DT_BLOQ,nm_usuar_bloq) VALUES (SIBX_CONTR.nextval,'11699141000160',	current_timestamp ,null, 'S', null, current_timestamp,'FERNANDO LISBOA' ) ");
		return sql;
	}
	
	public StringBuilder retornaInsertDesbloqueioContratoCancelado() {
		StringBuilder sql = new StringBuilder(
				" INSERT INTO TACS_CONTR_INDCD(ID_CONTR, NU_CNPJ, DT_INI_OFERT, DT_FIM_OFERT, DS_BLOQ, DT_CANCT, DT_BLOQ,nm_usuar_bloq) VALUES (SIBX_CONTR.nextval,'11699141000160',current_timestamp ,current_timestamp, 'S', current_timestamp,current_timestamp,'FERNANDO LISBOA') ");
		return sql;
	}
	
	public StringBuilder retornaDeleteTabelaContratos() {
		StringBuilder sql = new StringBuilder(
				" DELETE FROM owadq.tacs_contr_indcd WHERE nu_cnpj in (28339982000160,41707658000115,37491504000161,12259140000168, 11699141000160, 10657052000199 ) ");
		return sql;
	}
	
	
	

}
