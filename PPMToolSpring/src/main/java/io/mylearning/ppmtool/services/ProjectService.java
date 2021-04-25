package io.mylearning.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mylearning.ppmtool.domain.Project;
import io.mylearning.ppmtool.reporsitories.ProjectRepositories;

@Service
public class ProjectService implements ProjectServiceInterface {
	
	@Autowired
	private ProjectRepositories projectRepositories;

	@Override
	public Project createOrUpdateProject(Project p) {
		Project project = projectRepositories.save(p);
		return project;
	}
	
	

}
