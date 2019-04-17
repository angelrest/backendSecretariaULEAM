package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="archivepdf")
public class ArchivePdf extends DateAudit {
	
	public ArchivePdf() {
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(length=160, unique=true)
	private String filename;
	
	@Column(length=50)
	private String originalfilename;
	
	@Column(length=1000)
	private String filedownloaduri;
	
	@Column(length=100)
	private String filetype;
	
	private long size;
	
	@ManyToOne
	@JoinColumn(name = "documentationid", nullable = false)
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

	public ArchivePdf(String filename, String filedownloaduri, String filetype, long size,
			Documentation documentation, String originalfilename) {
		super();
		this.originalfilename=originalfilename;
		this.filename = filename;
		this.filedownloaduri = filedownloaduri;
		this.filetype = filetype;
		this.size = size;
		this.documentation = documentation;
	}

	public String getOriginalfilename() {
		return originalfilename;
	}

	public void setOriginalfilename(String originalfilename) {
		this.originalfilename = originalfilename;
	}

	
	

}
