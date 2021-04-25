package io.mylearning.ppmtool.services;

import io.mylearning.ppmtool.domain.Project;

public interface ProjectServiceInterface {
	
	public Project createOrUpdateProject(Project project);

	Project findProjectByProjectId(String projectId); 
	

}
