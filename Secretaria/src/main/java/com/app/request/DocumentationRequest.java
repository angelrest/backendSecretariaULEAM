package com.app.request;

import java.util.Date;


public class DocumentationRequest {
	
	private Long department;
	private String filetype;
	private String ubication;
	private Date date;//fecha
	private String hanger;//percha
	private String row;//fila
	private String folder;
	private String sender;//remitente
	private String addressee;//destinatario
	private String description;
	
	
	public DocumentationRequest(Long department, String filetype, String ubication, Date date, String hanger,
			String row, String folder, String sender, String addressee, String description) {
		super();
		this.department = department;
		this.filetype = filetype;
		this.ubication = ubication;
	this.date = date;
		this.hanger = hanger;
		this.row = row;
		this.folder = folder;
		this.sender = sender;
		this.addressee = addressee;
		this.description = description;
	}
	public Long getDepartment() {
		return department;
	}
	public void setDepartment(Long department) {
		this.department = department;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public String getUbication() {
		return ubication;
	}
	public void setUbication(String ubication) {
		this.ubication = ubication;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getHanger() {
		return hanger;
	}
	public void setHanger(String hanger) {
		this.hanger = hanger;
	}
	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}
	public String getFolder() {
		return folder;
	}
	public void setFolder(String folder) {
		this.folder = folder;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getAddressee() {
		return addressee;
	}
	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
