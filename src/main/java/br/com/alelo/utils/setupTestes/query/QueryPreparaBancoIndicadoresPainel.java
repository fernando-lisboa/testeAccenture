package br.com.alelo.utils.setupTestes.query;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fernando Lisbos
 *
 */
public class QueryPreparaBancoIndicadoresPainel {

	public StringBuilder retornaInsertContratacao1() {
		StringBuilder sql = new StringBuilder(
				" INSERT INTO TACS_CONTR_INDCD(ID_CONTR, NU_CNPJ, DT_INI_OFERT, DT_FIM_OFERT, DS_BLOQ, DT_CANCT) VALUES (SIBX_CONTR.nextval,'28339982000160',	current_timestamp ,null, 'N', null) ");
		return sql;
	}
	

	public StringBuilder retornaInsertContratacao2() {
		StringBuilder sql = new StringBuilder(
				" INSERT INTO TACS_CONTR_INDCD(ID_CONTR, NU_CNPJ, DT_INI_OFERT, DT_FIM_OFERT, DS_BLOQ, DT_CANCT) VALUES (SIBX_CONTR.nextval,'37491504000161', current_timestamp ,null, 'N', null) ");

		return sql;
	}

	public StringBuilder retornaInsertContratacao3() {
		StringBuilder sql = new StringBuilder(
				" INSERT INTO TACS_CONTR_INDCD(ID_CONTR, NU_CNPJ, DT_INI_OFERT, DT_FIM_OFERT, DS_BLOQ, DT_CANCT) VALUES (SIBX_CONTR.nextval,'12259140000168', current_timestamp ,null, 'N', null) ");
		return sql;
	}

	public StringBuilder retornaInsertContratacao4() {
		StringBuilder sql = new StringBuilder(
				" INSERT INTO TACS_CONTR_INDCD(ID_CONTR, NU_CNPJ, DT_INI_OFERT, DT_FIM_OFERT, DS_BLOQ, DT_CANCT) VALUES (SIBX_CONTR.nextval,'41707658000115', current_timestamp ,null, 'N', null) ");
		return sql;
	}
	public StringBuilder retornaInsertContratacaoCancelado() {
		StringBuilder sql = new StringBuilder(
				" INSERT INTO TACS_CONTR_INDCD(ID_CONTR, NU_CNPJ, DT_INI_OFERT, DT_FIM_OFERT, DS_BLOQ, DT_CANCT) VALUES (SIBX_CONTR.nextval,'11699141000160', SYSDATE - 60 ,SYSDATE - 31, 'N', null) ");
		return sql;
	}
	
	public StringBuilder retornaInsertContratacaoForaPeriodoTestes() {
		StringBuilder sql = new StringBuilder(
				" INSERT INTO TACS_CONTR_INDCD(ID_CONTR, NU_CNPJ, DT_INI_OFERT, DT_FIM_OFERT, DS_BLOQ, DT_CANCT) VALUES (SIBX_CONTR.nextval,'41707658000115',SYSDATE - 60 ,null, 'N', null) ");
		return sql;
	}
	

	public StringBuilder retornaInsertOferta() {


		StringBuilder sql = new StringBuilder("INSERT ALL ")
				.append(" INTO OWADQ.TACS_OFERT(NU_CNPJ, DT_PROCM) VALUES ('28339982000160', current_timestamp) ")
				.append(" INTO OWADQ.TACS_OFERT(NU_CNPJ, DT_PROCM) VALUES ('37491504000161', current_timestamp) ")
				.append(" INTO OWADQ.TACS_OFERT(NU_CNPJ, DT_PROCM) VALUES ('12259140000168', current_timestamp) ")
				.append(" INTO OWADQ.TACS_OFERT(NU_CNPJ, DT_PROCM) VALUES ('41707658000115', current_timestamp) ")
				.append(" INTO OWADQ.TACS_OFERT(NU_CNPJ, DT_PROCM) VALUES ('11699141000160', current_timestamp) ")
				.append(" SELECT 1 FROM DUAL ");

//		String[] Cnpjs = {"28339982000160","37491504000161","12259140000168","41707658000115","11699141000160"};
//		StringBuilder sql = new StringBuilder("INSERT ALL ");
//		for(String cnpj : Cnpjs)
//			sql.append(" INTO OWADQ.TACS_OFERT(NU_CNPJ, DT_PROCM) VALUES ('"+ cnpj +"', current_timestamp) ");

		return sql;
	}

	/*public enum ModoSQL {DELETE, INSERT, SELECT }

	public StringBuilder FuncionalidadeSQL(ModoSQL modosql, String nomeBanco, String nomeTabela, String[]colunaTabela, String[]valorColuna, String infoFinalSQL){
		StringBuilder sql = new StringBuilder("INSERT ALL ");
		String stringSQL;

		String tabelas = "";
		for(String colunaTabela_ :  colunaTabela)
			tabelas = tabelas + "," + colunaTabela_;

		switch (modosql) {
			case INSERT:
				stringSQL = "INSERT ALL INTO " + nomeBanco + "." +nomeTabela + "(" + tabelas + ")"
				break;

			case DELETE:
				break;

			case SELECT:
				break;
				}


		return sql;
	}*/


	public StringBuilder retornaInsertLocalidade() {
		StringBuilder sql = new StringBuilder(" INSERT ALL ")
				.append(" INTO TACS_EC_LOC(NU_CNPJ, NU_CEP, DT_PROCM) VALUES ('28339982000160','55000', current_timestamp) ")
				.append(" INTO TACS_EC_LOC(NU_CNPJ, NU_CEP, DT_PROCM) VALUES ('37491504000161','55000', current_timestamp) ")
				.append(" INTO TACS_EC_LOC(NU_CNPJ, NU_CEP, DT_PROCM) VALUES ('12259140000168','55000', current_timestamp) ")
				.append(" INTO TACS_EC_LOC(NU_CNPJ, NU_CEP, DT_PROCM) VALUES ('41707658000115','55000', current_timestamp) ")
				.append(" INTO TACS_EC_LOC(NU_CNPJ, NU_CEP, DT_PROCM) VALUES ('11699141000160','55000', current_timestamp) ")
				.append("  SELECT 1 FROM DUAL ");
		return sql;
	}

	public StringBuilder retornaDeleteLocalidade() {
		StringBuilder sql = new StringBuilder(
				
				" DELETE FROM OWADQ.TACS_EC_LOC WHERE NU_CNPJ IN (28339982000160, 37491504000161, 12259140000168, 41707658000115, 11699141000160) ");
		return sql;
	}

	public StringBuilder retornaDeleteOferta() {
		StringBuilder sql = new StringBuilder(
				" DELETE FROM OWADQ.TACS_OFERT WHERE NU_CNPJ IN (28339982000160, 37491504000161, 12259140000168, 41707658000115, 11699141000160) ");
		return sql;
	}

	public StringBuilder retornaInsertTransacoes() {
		StringBuilder sql = new StringBuilder(" INSERT ALL ")
				.append(" into TADQ_TRANS values ('9000000000','04013223002945',null,'5292564652',to_date('20/03/20','DD/MM/RR'),to_date('20/03/20','DD/MM/RR'),to_date('20/03/20','DD/MM/RR'),"
						+ "'22,7','1,25',null,'5067130401746015','0,06',null,'1','1660861638','45','1015000590',to_date('20/03/20','DD/MM/RR'),'7','ELO','202003','4','506713','0','1','22,7',"
						+ "null,'22,7','21,45',null,null,null,to_date('20/03/20','DD/MM/RR'),'1','VENDA','6015','100','CIELO','561275','APROVADO','APROVADO',null,'252309','Refeição',"
						+ "to_date('20/03/20','DD/MM/RR'));")
				.append("  SELECT 1 FROM DUAL ");
		return sql;
	}

	public StringBuilder retornaDeleteIndicadoresMensal() {
		StringBuilder sql = new StringBuilder(
				" DELETE FROM TADQ_INDCD_MENSAL WHERE NU_CNPJ IN (28339982000160, 37491504000161, 12259140000168, 41707658000115)");
		return sql;
	}

	public StringBuilder retornaDeleteIndicadoresSemanal() {
		StringBuilder sql = new StringBuilder(
				" DELETE FROM TADQ_INDCD_SMNAL WHERE NU_CNPJ IN (28339982000160, 37491504000161, 12259140000168, 41707658000115)");
		return sql;
	}

	public StringBuilder retornaDeleteIndicadoresDiario() {
		StringBuilder sql = new StringBuilder(
				" DELETE FROM TADQ_INDCD_HORA WHERE NU_CNPJ IN (28339982000160, 37491504000161, 12259140000168, 41707658000115)");
		return sql;
	}
	
	public StringBuilder retornaDeletecontratos() {
		StringBuilder sql = new StringBuilder(
				" DELETE FROM owadq.tacs_contr_indcd WHERE NU_CNPJ IN (28339982000160, 37491504000161, 12259140000168, 41707658000115, 82143278000182 )");
		return sql;
	}
}
