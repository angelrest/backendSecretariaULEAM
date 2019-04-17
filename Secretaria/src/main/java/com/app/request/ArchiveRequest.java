package com.app.request;

import javax.validation.constraints.NotNull;

public class ArchiveRequest {
	
	private byte name;
	
	@NotNull
	private String filename;
	
	
	@NotNull
	private Long documentation;

	public byte getName() {
		return name;
	}

	public void setName(byte name) {
		this.name = name;
	}

	public Long getDocumentation() {
		return documentation;
	}

	public void setDocumentation(Long documentation) {
		this.documentation = documentation;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	 
	 


}
