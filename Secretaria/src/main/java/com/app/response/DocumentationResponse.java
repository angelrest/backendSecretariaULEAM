package com.app.response;

import java.time.Instant;
import java.util.Date;

import com.app.model.Department;
import com.app.model.FileType;
import com.app.model.Folder;
import com.app.model.Hanger;
import com.app.model.Row;
import com.app.model.SendName;
import com.app.model.Ubication;

public class DocumentationResponse {
	
	private Long id;
	private Department department;
	private FileType filetype;
	private Ubication ubication;
	private Date date;//fecha
	private Hanger hanger;//percha
	private Row row;//fila
	private Folder folder;
	private SendName sender;//remitente
	private SendName addressee;//destinatario
	private String description;
	private Instant created_at;
	private Instant updated_at;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public FileType getFiletype() {
		return filetype;
	}
	public void setFiletype(FileType filetype) {
		this.filetype = filetype;
	}
	public Ubication getUbication() {
		return ubication;
	}
	public void setUbication(Ubication ubication) {
		this.ubication = ubication;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Hanger getHanger() {
		return hanger;
	}
	public void setHanger(Hanger hanger) {
		this.hanger = hanger;
	}
	public Row getRow() {
		return row;
	}
	public void setRow(Row row) {
		this.row = row;
	}
	public Folder getFolder() {
		return folder;
	}
	public void setFolder(Folder folder) {
		this.folder = folder;
	}
	public SendName getSender() {
		return sender;
	}
	public void setSender(SendName sender) {
		this.sender = sender;
	}
	public SendName getAddressee() {
		return addressee;
	}
	public void setAddressee(SendName addressee) {
		this.addressee = addressee;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Instant getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Instant instant) {
		this.created_at = instant;
	}
	public Instant getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Instant updated_at) {
		this.updated_at = updated_at;
	}
	
	

}
