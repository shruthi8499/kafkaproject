package com.rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PendingMessage {
    
	@Override
	public String toString() {
		return "PendingMessage [id=" + id + ", clientId=" + clientId + ", content=" + content + "]";
	}
	public PendingMessage(Long id, String clientId, String content) {
		super();
		this.id = id;
		this.clientId = clientId;
		this.content = content;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public PendingMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String clientId;
    private String content;

    
}