package io.mylearning.ppmtool.services;

import io.mylearning.ppmtool.domain.Project;

public interface ProjectServiceInterface {
	
	public Project createOrUpdateProject(Project project);

	Project findProjectByProjectId(String projectId);

	Iterable<Project> getAllProjects();

	void deleteProject(String projectId);

	Project updateProject(Project project); 
	

}
