package io.mylearning.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mylearning.ppmtool.domain.Project;
import io.mylearning.ppmtool.exceptions.ProjectIdException;
import io.mylearning.ppmtool.reporsitories.ProjectRepositories;

@Service
public class ProjectService implements ProjectServiceInterface {
	
	@Autowired
	private ProjectRepositories projectRepositories;
	

	@Override
	public Project createOrUpdateProject(Project p) {
		try {
			p.setProjectIdentifier(p.getProjectIdentifier().toUpperCase());
			return projectRepositories.save(p);
		}catch(Exception e) {
			throw new ProjectIdException("Project Identifier "+p.getProjectIdentifier().toUpperCase()+" already exists");
		}
		
	}
	
	@Override
	public Project findProjectByProjectId(String projectId) {
		
		Project project = projectRepositories.findByProjectIdentifier(projectId.toUpperCase());
		if(project == null) {
			throw new ProjectIdException("Project does not exist");
		}
		
		
		return project;
		
	}

	@Override
	public Iterable<Project> getAllProjects() {
		return projectRepositories.findAll();
	}
	
	

}
