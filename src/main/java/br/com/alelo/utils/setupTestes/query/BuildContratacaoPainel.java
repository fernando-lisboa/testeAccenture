package br.com.alelo.utils.setupTestes.query;

import br.com.alelo.utils.setupTestes.param.ParametroPainel;

public class BuildContratacaoPainel {

	public ParametroPainel contratacaoCancelamento(String idPersonUnit, String status) {
		ParametroPainel param = new ParametroPainel();
		param.setStatus(status);
		return param;
	}

	public ParametroPainel consultaStatus(String valor) {
		ParametroPainel param = new ParametroPainel();
		param.setIdPersonUnit(valor);
		return param;
	}
}
