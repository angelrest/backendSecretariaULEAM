package com.app.request;

public class FolderRequest {
	
	private String name;
	private boolean active;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	 public FolderRequest(String name, boolean active) {
			this.name = name;
			this.active = active;
		}

}
