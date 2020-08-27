package br.com.alelo.utils.setupTestes.query;

public class QuerySolicitacaoDelivery {

	public StringBuilder deletaPID() {
		StringBuilder sql = new StringBuilder("DELETE OWADQ.TACS_IDTFD_PORTAL where nu_cpf = 97201873016");
		System.out.println(sql);
		return sql;
	}

	public StringBuilder deletaPIDIsan() {
		StringBuilder sql = new StringBuilder("DELETE OWADQ.TACS_USUAR_PORTAL where nu_cpf = 97201873016");
		System.out.println(sql);
		return sql;
	}

	public StringBuilder deletaSolicitacaoDelivery() {
		StringBuilder sql = new StringBuilder("delete from TDSV_ESTBL_COML WHERE nu_cnpj in (28339982000160)");
		System.out.println(sql);
		return sql;
	}

	public StringBuilder selecionaMassaDelivery() {
		StringBuilder sql = new StringBuilder(
				"SELECT * from owadq.TDSV_ESTBL_COML where nu_cnpj in ('63996512000124','63996511000124','0445692000147','0445692000147','6399651000125','0445692000142','6399651000456','7899651000125','65796511000125','67696511000176','92625163000189','95734560001203','95734567800123','46739993300234','46399933000234')");

		System.out.println(sql);
		return sql;
	}

	public StringBuilder deletaMassaDelivery() {
		StringBuilder sql = new StringBuilder(
				"Delete from owadq.TDSV_ESTBL_COML where nu_cnpj in ('63996512000124','63996511000124','0445692000147','0445692000147','6399651000125','0445692000142','6399651000456','7899651000125','65796511000125','67696511000176','92625163000189','95734560001203','95734567800123','46739993300234','46399933000234')");
		System.out.println(sql);
		return sql;
	}

	public StringBuilder insereMassaDelivery() {
		StringBuilder sql = new StringBuilder("INSERT ALL ")
				.append("into owadq.TDSV_ESTBL_COML (ID_ESTBL,NU_CNPJ,CD_ESTBL_COML,DT_HORA_INCL,ID_PLATF_DLIVRY) values ((select max(ID_ESTBL)+1 from owadq.TDSV_ESTBL_COML),'63996511000124','10170645',sysdate,'1')")
				.append("into owadq.TDSV_ESTBL_COML (ID_ESTBL,NU_CNPJ,CD_ESTBL_COML,DT_HORA_INCL,ID_PLATF_DLIVRY) values ((select max(ID_ESTBL)+1 from owadq.TDSV_ESTBL_COML),'63996592000124','10170645',sysdate,'1')")
				.append("into owadq.TDSV_ESTBL_COML (ID_ESTBL,NU_CNPJ,CD_ESTBL_COML,DT_HORA_INCL,ID_PLATF_DLIVRY) values ((select max(ID_ESTBL)+1 from owadq.TDSV_ESTBL_COML),'44445699000147','123456789',sysdate,'2')")
				.append("into owadq.TDSV_ESTBL_COML (ID_ESTBL,NU_CNPJ,CD_ESTBL_COML,DT_HORA_INCL,ID_PLATF_DLIVRY) values ((select max(ID_ESTBL)+1 from owadq.TDSV_ESTBL_COML),'04453672000147','43567890',sysdate,'1')")
				.append("into owadq.TDSV_ESTBL_COML (ID_ESTBL,NU_CNPJ,CD_ESTBL_COML,DT_HORA_INCL,ID_PLATF_DLIVRY) values ((select max(ID_ESTBL)+1 from owadq.TDSV_ESTBL_COML),'63996560030125','65679943',sysdate,'2')")
				.append("into owadq.TDSV_ESTBL_COML (ID_ESTBL,NU_CNPJ,CD_ESTBL_COML,DT_HORA_INCL,ID_PLATF_DLIVRY) values ((select max(ID_ESTBL)+1 from owadq.TDSV_ESTBL_COML),'04456352000142','76789543',sysdate,'2')")
				.append("into owadq.TDSV_ESTBL_COML (ID_ESTBL,NU_CNPJ,CD_ESTBL_COML,DT_HORA_INCL,ID_PLATF_DLIVRY) values ((select max(ID_ESTBL)+1 from owadq.TDSV_ESTBL_COML),'63996441000456','234567895',sysdate,'2')")
				.append("into owadq.TDSV_ESTBL_COML (ID_ESTBL,NU_CNPJ,CD_ESTBL_COML,DT_HORA_INCL,ID_PLATF_DLIVRY) values ((select max(ID_ESTBL)+1 from owadq.TDSV_ESTBL_COML),'78996534000125','1012770645',sysdate,'2')")
				.append("into owadq.TDSV_ESTBL_COML (ID_ESTBL,NU_CNPJ,CD_ESTBL_COML,DT_HORA_INCL,ID_PLATF_DLIVRY) values ((select max(ID_ESTBL)+1 from owadq.TDSV_ESTBL_COML),'65796511000125','234565434',sysdate,'2')")
				.append("into owadq.TDSV_ESTBL_COML (ID_ESTBL,NU_CNPJ,CD_ESTBL_COML,DT_HORA_INCL,ID_PLATF_DLIVRY) values ((select max(ID_ESTBL)+1 from owadq.TDSV_ESTBL_COML),'87696511000176','4567899954',sysdate,'1')")
				.append("into owadq.TDSV_ESTBL_COML (ID_ESTBL,NU_CNPJ,CD_ESTBL_COML,DT_HORA_INCL,ID_PLATF_DLIVRY) values ((select max(ID_ESTBL)+1 from owadq.TDSV_ESTBL_COML),'72625163000189','1012770645',sysdate,'2')")
				.append("into owadq.TDSV_ESTBL_COML (ID_ESTBL,NU_CNPJ,CD_ESTBL_COML,DT_HORA_INCL,ID_PLATF_DLIVRY) values ((select max(ID_ESTBL)+1 from owadq.TDSV_ESTBL_COML),'15734560001203','1012770645',sysdate,'2')")
				.append("into owadq.TDSV_ESTBL_COML (ID_ESTBL,NU_CNPJ,CD_ESTBL_COML,DT_HORA_INCL,ID_PLATF_DLIVRY) values ((select max(ID_ESTBL)+1 from owadq.TDSV_ESTBL_COML),'11734567800123','1012770645',sysdate,'1')")
				.append("into owadq.TDSV_ESTBL_COML (ID_ESTBL,NU_CNPJ,CD_ESTBL_COML,DT_HORA_INCL,ID_PLATF_DLIVRY) values ((select max(ID_ESTBL)+1 from owadq.TDSV_ESTBL_COML),'12739993300234','4562699790',sysdate,'2')")
				.append("into owadq.TDSV_ESTBL_COML (ID_ESTBL,NU_CNPJ,CD_ESTBL_COML,DT_HORA_INCL,ID_PLATF_DLIVRY) values ((select max(ID_ESTBL)+1 from owadq.TDSV_ESTBL_COML),'13399933000234','561234578',sysdate,'2')")
				.append(" SELECT 1 FROM DUAL ");
				System.out.println(sql);
						return sql;
	}

	public StringBuilder insereMassaPid() {
		StringBuilder sql = new StringBuilder("select * from TDSV_ESTBL_COML WHERE nu_cnpj in (63996511000125)");
		System.out.println(sql);
		return sql;
	}

}
