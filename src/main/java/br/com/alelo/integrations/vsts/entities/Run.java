package br.com.alelo.integrations.vsts.entities;

public class Run {
	
	private String name;
	private String planId;
	private String state;
	private Boolean isAutomated = true;
	private String runId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Boolean getIsAutomated() {
		return isAutomated;
	}
	public void setIsAutomated(Boolean isAutomated) {
		this.isAutomated = isAutomated;
	}
	
	public String createJson(){
		return "{\"name\" : \""+name+"\", \"isAutomated\" : \""+isAutomated+"\", \"plan\" : { \"id\" : \""+planId+"\" } }";
	}
	
	public String updateRun(){
		return "{\"state\" : \"Completed\"}";
	}
	public String getRunId() {
		return runId;
	}
	public void setRunId(String runId) {
		this.runId = runId;
	}
	
	

}
