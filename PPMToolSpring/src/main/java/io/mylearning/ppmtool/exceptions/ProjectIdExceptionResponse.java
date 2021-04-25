package io.mylearning.ppmtool.exceptions;

public class ProjectIdExceptionResponse {
	
	public ProjectIdExceptionResponse(String projectIdentifier) {
		super();
		this.projectIdentifier = projectIdentifier;
	}
	
	private String projectIdentifier;

	public String getProjectIdentifier() {
		return projectIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}

	
	
	

}
