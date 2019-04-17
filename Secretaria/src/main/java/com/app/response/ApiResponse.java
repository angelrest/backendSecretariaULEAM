package com.app.response;

public class ApiResponse {
	
	private Long id;
	private String name;
	private boolean success;
	
	public ApiResponse(Long id, String name, boolean success) {
		this.id=id;
		this.name=name;
		this.success=success;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	

}
