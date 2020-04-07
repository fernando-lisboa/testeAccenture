package br.com.alelo.utils.setupTestes.query;

public class QueryPreparaTesteExtrato {
	
	public StringBuilder retornaInsertTransacao1() {
		StringBuilder sql = new StringBuilder(" INSERT ALL ")
				.append(" INTO TACS_EC_LOC(NU_CNPJ, NU_CEP, DT_PROCM) VALUES ('28339982000160','55000', current_timestamp) ")
				.append(" INTO TACS_EC_LOC(NU_CNPJ, NU_CEP, DT_PROCM) VALUES ('37491504000161','55000', current_timestamp) ")
				.append(" INTO TACS_EC_LOC(NU_CNPJ, NU_CEP, DT_PROCM) VALUES ('12259140000168','55000', current_timestamp) ")
				.append(" INTO TACS_EC_LOC(NU_CNPJ, NU_CEP, DT_PROCM) VALUES ('41707658000115','55000', current_timestamp) ")
				.append(" INTO TACS_EC_LOC(NU_CNPJ, NU_CEP, DT_PROCM) VALUES ('11699141000160','55000', current_timestamp) ")
				.append("  SELECT 1 FROM DUAL ");

		return sql;
	}
	
	public StringBuilder retornaInsertContratacaoForaPeriodoTestes() {
		StringBuilder sql = new StringBuilder(
				" INSERT INTO TACS_CONTR_INDCD(ID_CONTR, NU_CNPJ, DT_INI_OFERT, DT_FIM_OFERT, DS_BLOQ, DT_CANCT) VALUES (SIBX_CONTR.nextval,'41707658000115',SYSDATE - 60 ,null, 'N', null) ");

		return sql;
	}

}
