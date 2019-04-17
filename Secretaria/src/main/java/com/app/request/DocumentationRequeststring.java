package com.app.request;

import java.util.Date;

public class DocumentationRequeststring {
	
	private Long department;
	private Long filetype;
	private Long ubication;
	private Date date;//fecha
	private Long hanger;//percha
	private Long row;//fila
	private Long folder;
	private Long sender;//remitente
	private Long addressee;//destinatario
	private String description;
	public Long getDepartment() {
		return department;
	}
	public void setDepartment(Long department) {
		this.department = department;
	}
	public Long getFiletype() {
		return filetype;
	}
	public void setFiletype(Long filetype) {
		this.filetype = filetype;
	}
	public Long getUbication() {
		return ubication;
	}
	public void setUbication(Long ubication) {
		this.ubication = ubication;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getHanger() {
		return hanger;
	}
	public void setHanger(Long hanger) {
		this.hanger = hanger;
	}
	public Long getRow() {
		return row;
	}
	public void setRow(Long row) {
		this.row = row;
	}
	public Long getFolder() {
		return folder;
	}
	public void setFolder(Long folder) {
		this.folder = folder;
	}
	public Long getSender() {
		return sender;
	}
	public void setSender(Long sender) {
		this.sender = sender;
	}
	public Long getAddressee() {
		return addressee;
	}
	public void setAddressee(Long addressee) {
		this.addressee = addressee;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
