package com.rest;

public class DeadLetterMessage {
	
	private String originalTopic;
    private String originalMessage;
    private String failureReason;
	
	@Override
	public String toString() {
		return "DeadLetterMessage [originalTopic=" + originalTopic + ", originalMessage=" + originalMessage
				+ ", failureReason=" + failureReason + "]";
	}
	public String getOriginalTopic() {
		return originalTopic;
	}
	public void setOriginalTopic(String originalTopic) {
		this.originalTopic = originalTopic;
	}
	public String getOriginalMessage() {
		return originalMessage;
	}
	public void setOriginalMessage(String originalMessage) {
		this.originalMessage = originalMessage;
	}
	public String getFailureReason() {
		return failureReason;
	}
	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}
	public DeadLetterMessage(String originalTopic, String originalMessage, String failureReason) {
		super();
		this.originalTopic = originalTopic;
		this.originalMessage = originalMessage;
		this.failureReason = failureReason;
	}
	public DeadLetterMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
