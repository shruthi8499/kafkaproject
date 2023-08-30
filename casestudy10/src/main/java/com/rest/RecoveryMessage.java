package com.rest;

public class RecoveryMessage {
    @Override
	public String toString() {
		return "RecoveryMessage [action=" + action + "]";
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public RecoveryMessage(String action) {
		super();
		this.action = action;
	}

	public RecoveryMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String action; // action for recovery, e.g., "recover-pending-messages"
    
}
