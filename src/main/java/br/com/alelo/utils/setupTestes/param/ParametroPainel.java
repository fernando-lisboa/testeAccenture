package br.com.alelo.utils.setupTestes.param;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParametroPainel {
	
	@JsonProperty(value = "idPersonUnit")
	private String idPersonUnit;
	
	@JsonProperty(value = "status")
	private String status;
	

	public String getIdPersonUnit() {
	return idPersonUnit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setIdPersonUnit(String idPersonUnit) {
	this.idPersonUnit = idPersonUnit;
	}


}