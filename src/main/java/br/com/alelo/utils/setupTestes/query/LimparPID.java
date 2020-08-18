package br.com.alelo.utils.setupTestes.query;

public class LimparPID {
	
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

}
