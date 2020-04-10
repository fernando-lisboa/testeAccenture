package br.com.alelo.utils.setupTestes.query;

public class QueryPreparaTesteExtrato {
	
	public StringBuilder retornaInsertTabelaTADQ_TRANS() {
		StringBuilder sql = new StringBuilder(" INSERT ALL ")
				.append(" into OWPPOINT.TADQ_TRANS  values ('9000000000','28339982000160',null,'5292564652',to_date('20/03/20','DD/MM/RR'),to_date('20/03/20','DD/MM/RR'),to_date('20/03/20','DD/MM/RR'),'22,7','1,25',null,'5067130401746015','0,06',null,'1','1660861638','45','1014986319',to_date('20/03/20','DD/MM/RR'),'7','ELO','202003','4','506713','0','1','22,7',null,'22,7','21,45',null,null,null,to_date('20/03/20','DD/MM/RR'),'1','VENDA','6015','100','CIELO','561275','APROVADO','APROVADO',null,'221592421','Refeição',to_date('20/03/20','DD/MM/RR')) ")
				.append(" into OWPPOINT.TADQ_TRANS  values ('9000000001','28339982000160',null,'5291686049',to_date('20/03/20','DD/MM/RR'),to_date('20/03/20','DD/MM/RR'),to_date('20/03/20','DD/MM/RR'),'6','0,3',null,'5067541124890023','0,05',null,'1','1657383218','45','1014986319',to_date('20/03/20','DD/MM/RR'),'7','ELO','201809','7','506754','0','1','6',null,'6','5,7',null,null,null,to_date('20/03/20','DD/MM/RR'),'1','VENDA','0023','100','CIELO','384360','APROVADO','APROVADO',null,'221592421','Refeição',to_date('20/03/20','DD/MM/RR')) ")
				.append(" into OWPPOINT.TADQ_TRANS  values ('9000000002','28339982000160',null,'5291686048',to_date('20/03/20','DD/MM/RR'),to_date('20/03/20','DD/MM/RR'),to_date('20/03/20','DD/MM/RR'),'29,4','1,73',null,'5067543120283021','0,06',null,'1','1657542969','45','1014986319',to_date('20/03/20','DD/MM/RR'),'7','ELO','201809','5','506754','0','1','29,4',null,'29,4','27,67',null,null,null,to_date('20/03/20','DD/MM/RR'),'1','VENDA','3021','100','CIELO','213619','APROVADO','APROVADO',null,'221592421','Refeição',to_date('20/03/20','DD/MM/RR')) ")
				.append(" into OWPPOINT.TADQ_TRANS  values ('9000000003','28339982000160',null,'5291686047',to_date('20/03/20','DD/MM/RR'),to_date('20/03/20','DD/MM/RR'),to_date('20/03/20','DD/MM/RR'),'19','1,14',null,'5067541124886013','0,06',null,'1','1657376831','45','1014986319',to_date('20/03/20','DD/MM/RR'),'7','ELO','201809','8','506754','0','1','19',null,'19','17,86',null,null,null,to_date('20/03/20','DD/MM/RR'),'1','VENDA','6013','100','CIELO','747600','APROVADO','APROVADO',null,'221592421','Refeição',to_date('20/03/20','DD/MM/RR')) ")
				.append(" into OWPPOINT.TADQ_TRANS  values ('9000000004','28339982000160',null,'5291686046',to_date('20/03/20','DD/MM/RR'),to_date('20/03/20','DD/MM/RR'),to_date('20/03/20','DD/MM/RR'),'38,5','2,19',null,'5067543120279011','0,06',null,'1','1657375573','45','1014986319',to_date('20/03/20','DD/MM/RR'),'7','ELO','201809','4','506754','0','1','38,5',null,'38,5','36,31',null,null,null,to_date('20/03/20','DD/MM/RR'),'1','VENDA','9011','108','PAG SEGURA','444997','APROVADO','APROVADO',null,'221592421','Refeição',to_date('20/03/20','DD/MM/RR')) ")
				.append(" into OWPPOINT.TADQ_TRANS  values ('9000000005','28339982000160',null,'5291686045',to_date('26/02/20','DD/MM/RR'),to_date('26/02/20','DD/MM/RR'),to_date('26/02/20','DD/MM/RR'),'5,5','0,33',null,'5067541124886013','0,06',null,'1','1657426135','45','1014986319',to_date('26/02/20','DD/MM/RR'),'7','ELO','201809','8','506754','0','1','5,5',null,'5,5','5,17',null,null,null,to_date('26/02/20','DD/MM/RR'),'1','VENDA','6013','100','CIELO','042443','APROVADO','APROVADO',null,'221592421','Refeição',to_date('26/02/20','DD/MM/RR')) ")
				.append(" into OWPPOINT.TADQ_TRANS  values ('9000000006','28339982000160',null,'5291686044',to_date('03/04/20','DD/MM/RR'),to_date('03/04/20','DD/MM/RR'),to_date('03/04/20','DD/MM/RR'),'170,5','1,05',null,'5067543120277015','0,06',null,'1','1657421208','45','1014986319',to_date('03/04/20','DD/MM/RR'),'7','ELO','201809','8','506754','0','1','170,5',null,'170,5','160,45',null,null,null,to_date('03/04/20','DD/MM/RR'),'1','VENDA','7015','100','CIELO','115538','APROVADO','APROVADO',null,'221592421','Refeição',to_date('03/04/20','DD/MM/RR')) ")
				.append(" into OWPPOINT.TADQ_TRANS  values ('9000000007','28339982000160',null,'5263107611',to_date('03/04/20','DD/MM/RR'),to_date('03/04/20','DD/MM/RR'),to_date('03/04/20','DD/MM/RR'),'-104',null,null,'1',null,'982','2','1647438389','45','1012770645',to_date('03/04/20','DD/MM/RR'),'7','ELO','201809','4','1','0','1','-104',null,'-104','-104',null,null,null,to_date('03/04/20','DD/MM/RR'),'2','OUTRAS TRANSAÇÕES',null,'100','CIELO','000000','APROVADO','APROVADO','TARIFA DE ANUIDADE','221592421','Refeição',to_date('03/04/20','DD/MM/RR')) ")
				.append(" into OWPPOINT.TADQ_TRANS  values ('9000000008','28339982000160',null,'5291686030', to_date('22/03/20','DD/MM/RR'), to_date('22/03/20','DD/MM/RR'), to_date('22/03/20','DD/MM/RR'),'20,79','1,21',null,'5067543120260011','0,06',null,'1','1657565478','45','1012770645', to_date('22/03/20','DD/MM/RR'),'7','ELO','201809','7','506754','0','1','20,79',null,'20,79','19,58',null,null,null, to_date('22/03/20','DD/MM/RR'),'1','VENDA','0011','100','CIELO','181120','APROVADO','APROVADO',null,'221592421','Refeição', to_date('22/03/20','DD/MM/RR')) ")
				.append(" into OWPPOINT.TADQ_TRANS  values ('9000000009','28339982000160',null,'5291686029', to_date('22/03/20','DD/MM/RR'), to_date('22/03/20','DD/MM/RR'), to_date('22/03/20','DD/MM/RR'),'66,77','2',null,'5067541124434012','0,03',null,'1','1657527497','45','1012770645', to_date('22/03/20','DD/MM/RR'),'7','ELO','201809','6','506754','0','1','66,77',null,'66,77','64,77',null,null,null, to_date('22/03/20','DD/MM/RR'),'1','VENDA','4012','102','GETNET','047534','APROVADO','APROVADO',null,'221592421','Refeição', to_date('22/03/20','DD/MM/RR')) ")
				.append(" into OWPPOINT.TADQ_TRANS  values ('9000000010','28339982000160',null,'5291686028', to_date('22/03/20','DD/MM/RR'), to_date('22/03/20','DD/MM/RR'), to_date('22/03/20','DD/MM/RR'),'7','0,39',null,'5067543120260011','0,06',null,'1','1657457485','45','1012770645', to_date('22/03/20','DD/MM/RR'),'7','ELO','201809','4','506754','0','1','7',null,'7','6,61',null,null,null, to_date('22/03/20','DD/MM/RR'),'1','VENDA','0011','100','CIELO','027123','APROVADO','APROVADO',null,'221592421','Refeição', to_date('22/03/20','DD/MM/RR')) ")
				.append(" into OWPPOINT.TADQ_TRANS  values ('9000000011','28339982000160',null,'5291686027', to_date('22/03/20','DD/MM/RR'), to_date('22/03/20','DD/MM/RR'), to_date('22/03/20','DD/MM/RR'),'58,8','4,12',null,'5067541124390032','0,07',null,'1','1657525339','45','1012770645', to_date('22/03/20','DD/MM/RR'),'7','ELO','201809','5','506754','0','1','58,8',null,'58,8','54,68',null,null,null, to_date('22/03/20','DD/MM/RR'),'1','VENDA','0032','100','CIELO','424885','APROVADO','APROVADO',null,'221592421','Refeição', to_date('22/03/20','DD/MM/RR')) ")
				.append(" into OWPPOINT.TADQ_TRANS  values ('9000000012','28339982000160',null,'5291686026', to_date('22/03/20','DD/MM/RR'), to_date('22/03/20','DD/MM/RR'), to_date('22/03/20','DD/MM/RR'),'62,74','3,76',null,'5067543120243017','0,06',null,'1','1657447901','45','1012770645', to_date('22/03/20','DD/MM/RR'),'7','ELO','201809','7','506754','0','1','62,74',null,'62,74','58,98',null,null,null, to_date('22/03/20','DD/MM/RR'),'1','VENDA','3017','100','CIELO','112926','APROVADO','APROVADO',null,'221592421','Refeição', to_date('22/03/20','DD/MM/RR')) ")
				.append(" into OWPPOINT.TADQ_TRANS  values ('9000000013','28339982000160',null,'5291686025', to_date('22/03/20','DD/MM/RR'), to_date('22/03/20','DD/MM/RR'), to_date('22/03/20','DD/MM/RR'),'193,74','10,66',null,'5067541124339013','0,06',null,'1','1657460480','45','1012770645', to_date('22/03/20','DD/MM/RR'),'7','ELO','201809','5','506754','0','1','193,74',null,'193,74','183,08',null,null,null, to_date('22/03/20','DD/MM/RR'),'1','VENDA','9013','101','REDE','881595','APROVADO','APROVADO',null,'221592421','Refeição', to_date('22/03/20','DD/MM/RR')) ")
				.append(" into OWPPOINT.TADQ_TRANS  values ('9000000014','28339982000160',null,'5291686024', to_date('22/03/20','DD/MM/RR'), to_date('22/03/20','DD/MM/RR'), to_date('22/03/20','DD/MM/RR'),'7','0,42',null,'5067543120239015','0,06',null,'1','1657611595','45','1012770645', to_date('22/03/20','DD/MM/RR'),'7','ELO','201809','9','506754','0','1','7',null,'7','6,58',null,null,null, to_date('22/03/20','DD/MM/RR'),'1','VENDA','9015','101','REDE','364139','APROVADO','APROVADO',null,'221592421','Refeição', to_date('22/03/20','DD/MM/RR')) ")
				.append("  SELECT 1 FROM DUAL ");

		return sql;
	}
	
	
	public StringBuilder retornaInsertTabelaTIND_EC_MES() {
		StringBuilder sql = new StringBuilder(" INSERT ALL ")
				.append(" into OWODSADQ.TIND_EC_MES values ('28339982000160','202002','1','99999',to_date('26/02/20','DD/MM/RR'),to_date('26/02/20','DD/MM/RR'),'221592421',to_date('26/02/20','DD/MM/RR')) ")
				.append(" into OWODSADQ.TIND_EC_MES values ('28339982000160','202003','12','99999',to_date('22/03/20','DD/MM/RR'),to_date('22/03/20','DD/MM/RR'),'221592421',to_date('22/03/20','DD/MM/RR')) ")
				.append(" into OWODSADQ.TIND_EC_MES values ('28339982000160','202004','12','99999',to_date('03/04/20','DD/MM/RR'),to_date('03/04/20','DD/MM/RR'),'221592421',to_date('03/04/20','DD/MM/RR')) ")
				.append("  SELECT 1 FROM DUAL ");

		return sql;
	}
	
	public StringBuilder retornaInsertTabelaTIND_EC_TPO_DIA() {
		StringBuilder sql = new StringBuilder(" INSERT ALL ")
				.append(" into OWODSADQ.TIND_EC_TPO_DIA  values ('221592421','1014986319',to_date('26/02/20','DD/MM/RR'),'1','VENDA',to_number('5.17','9999.99'),'5',to_date('26/02/20','DD/MM/RR'),to_date('26/02/20','DD/MM/RR')) ")
				.append(" into OWODSADQ.TIND_EC_TPO_DIA  values ('221592421','1014986319',to_date('20/03/20','DD/MM/RR'),'1','VENDA',to_number('108.99','9999.99'),'5',to_date('20/03/20','DD/MM/RR'),to_date('20/03/20','DD/MM/RR')) ")
				.append(" into OWODSADQ.TIND_EC_TPO_DIA  values ('221592421','1012770645',to_date('22/03/20','DD/MM/RR'),'1','VENDA',to_number('374.7','9999.99'),'7',to_date('22/03/20','DD/MM/RR'),to_date('22/03/20','DD/MM/RR')) ")
				.append(" into OWODSADQ.TIND_EC_TPO_DIA  values ('221592421','1012770645',to_date('03/04/20','DD/MM/RR'),'1','VENDA',to_number('160.45','9999.99'),'7',to_date('03/04/20','DD/MM/RR'),to_date('03/04/20','DD/MM/RR')) ")
				.append(" into OWODSADQ.TIND_EC_TPO_DIA  values ('221592421','1012770645',to_date('03/04/20','DD/MM/RR'),'2','VENDA',to_number('-104','9999.99'),'7',to_date('03/04/20','DD/MM/RR'),to_date('03/04/20','DD/MM/RR')) ")
				.append("  SELECT 1 FROM DUAL ");

		return sql;
	}
	
	public StringBuilder retornaDeleteTabelaTADQ_TRANS() {
		StringBuilder sql = new StringBuilder(
				" DELETE FROM OWPPOINT.TADQ_TRANS where id_pk BETWEEN 9000000000 AND 9000000014 ");
		return sql;
	}
	
	
	
	public StringBuilder retornaDeleteTabelaTIND_EC_MES() {
		StringBuilder sql = new StringBuilder(
				"  DELETE FROM OWODSADQ.TIND_EC_MES Where NU_ANOMES BETWEEN  202002 AND 202004 ");
		return sql;
	}
	
	public StringBuilder retornaDeleteTabelaTIND_EC_TPO_DIA() {
		StringBuilder sql = new StringBuilder(
				" DELETE FROM OWODSADQ.TIND_EC_TPO_DIA where Id_Pess_unid = 221592421 AND DT_TRANSACAO BETWEEN  to_date('26/02/20','DD/MM/RR') AND to_date('03/04/20','DD/MM/RR') ");
		return sql;
	}
	
	

	
	


	

	

	

	

	

	

	

	

	

	

	

	

	
	
}
