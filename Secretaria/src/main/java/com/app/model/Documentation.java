package com.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="documentations")
public class Documentation extends DateAudit {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "departmentid", nullable = false)
	private Department department;
	
	@ManyToOne
	@JoinColumn(name = "filetypeid", nullable = false)
	private FileType filetype;
	
	@ManyToOne
	@JoinColumn(name = "ubicationid", nullable = false)
	private Ubication ubication;
	
	
	private Date date;//fecha
	
	@ManyToOne
	@JoinColumn(name = "hangerid", nullable = false)
	private Hanger hanger;//percha
	
	@ManyToOne
	@JoinColumn(name = "rowid", nullable = false)
	private Row row;//fila
	
	@ManyToOne
	@JoinColumn(name = "folderid", nullable = false)
	private Folder folder;
	
	@ManyToOne
	@JoinColumn(name = "senderid", nullable = false)
	private SendName sender;//remitente
	
	@ManyToOne
	@JoinColumn(name = "addresseeid", nullable = false)
	private SendName addressee;//destinatario
	
	
	@Column(length=1000)
	private String description;
	
	

	public Department getDepartment() {
		
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public FileType getFiletype() {
		if (filetype==null) {
			filetype=new FileType();
		}
		return filetype;
	}

	public void setFiletype(FileType filetype) {
		this.filetype = filetype;
	}

	public Ubication getUbication() {
		if (ubication==null) {
			ubication=new Ubication();
		}
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
		if (hanger==null) {
			hanger=new Hanger();
		}
		return hanger;
	}

	public void setHanger(Hanger hanger) {
		this.hanger = hanger;
	}

	public Row getRow() {
		if (row==null) {
			row=new Row();
		}
		return row;
	}

	public void setRow(Row row) {
		this.row = row;
	}

	public Folder getFolder() {
		if (folder==null) {
			folder=new Folder();
		}
		return folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}

	public SendName getSender() {
		if (sender==null) {
			sender=new SendName();
		}
		return sender;
	}

	public void setSender(SendName sender) {
		this.sender = sender;
	}

	public SendName getAddressee() {
		if (addressee==null) {
			addressee=new SendName();
		}
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

	

	

	
	
	public Documentation(Department department, FileType filetype, Ubication ubication, Date date, Hanger hanger,
			Row row, Folder folder, SendName sender, SendName addressee, String description) {
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

	public Documentation() {
		// TODO Auto-generated constructor stub
	}

	public Documentation(Long id, Department department, FileType filetype, Ubication ubication, Date date,
			Hanger hanger, Row row, Folder folder, SendName sender, SendName addressee, String description) {
		super();
		this.id=id;
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
	

}
