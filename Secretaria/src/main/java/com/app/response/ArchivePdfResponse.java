package com.app.response;

import com.app.model.Documentation;

public class ArchivePdfResponse {
	 private Long id;
	 private String filename;
	 private String originalfilename;
	 private String filedownloaduri;
	 private String filetype;
	 private long size;
	 private Documentation documentation;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFiledownloaduri() {
		return filedownloaduri;
	}
	public void setFiledownloaduri(String filedownloaduri) {
		this.filedownloaduri = filedownloaduri;
	}
	public String getOriginalfilename() {
		return originalfilename;
	}
	public void setOriginalfilename(String originalfilename) {
		this.originalfilename = originalfilename;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public Documentation getDocumentation() {
		return documentation;
	}
	public void setDocumentation(Documentation documentation) {
		this.documentation = documentation;
	}
	 
		
	 
	 

}
