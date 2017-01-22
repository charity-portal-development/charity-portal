package com.charityportal.core.model.context;

public class Context {
	
	private String actorAccountId;
	
	private long actionTimestamp;

	public String getActorAccountId() {
		return actorAccountId;
	}

	public void setActorAccountId(String actorAccountId) {
		this.actorAccountId = actorAccountId;
	}

	public long getActionTimestamp() {
		return actionTimestamp;
	}

	public void setActionTimestamp(long actionTimestamp) {
		this.actionTimestamp = actionTimestamp;
	}

}
