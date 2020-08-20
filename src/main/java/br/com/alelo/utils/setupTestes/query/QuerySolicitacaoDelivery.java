package br.com.alelo.utils.setupTestes.query;

public class QuerySolicitacaoDelivery {
	
	public StringBuilder deletaPID() {
		StringBuilder sql = new StringBuilder(
				"DELETE OWADQ.TACS_IDTFD_PORTAL where nu_cpf = 97201873016");
		System.out.println(sql);
		return sql;
	}
	public StringBuilder deletaPIDIsan() {
		StringBuilder sql = new StringBuilder(
				"DELETE OWADQ.TACS_USUAR_PORTAL where nu_cpf = 97201873016");
		System.out.println(sql);
		return sql;
	}
	public StringBuilder deletaSolicitacaoDelivery() {
		StringBuilder sql = new StringBuilder(
				"delete from TDSV_ESTBL_COML WHERE nu_cnpj in (28339982000160)");
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
	public StringBuilder insereMassaPid() {
		StringBuilder sql = new StringBuilder(
				"select * from TDSV_ESTBL_COML WHERE nu_cnpj in (63996511000125)");
		System.out.println(sql);
		return sql;
	}

}
