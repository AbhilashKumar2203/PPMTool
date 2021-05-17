package io.mylearning.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mylearning.ppmtool.domain.Backlog;
import io.mylearning.ppmtool.domain.ProjectTask;
import io.mylearning.ppmtool.reporsitories.BacklogRepositories;
import io.mylearning.ppmtool.reporsitories.ProjectTaskRepository;

@Service
public class ProjectTaskService implements ProjectTaskSericeInterface{
	
	@Autowired
	BacklogRepositories backlogRepo;
	
	@Autowired
	ProjectTaskRepository projectTaskRepo;
	
	@Override
	public ProjectTask createProjectTask(String projectIdentifier,ProjectTask projectTask) {
		
		//Exception: Project not found
		
		Backlog backlog= backlogRepo.findByProjectIdentifier(projectIdentifier);
		projectTask.setBacklog(backlog);
		Integer backlogequence = backlog.getPtSequence();
		backlogequence++;
		backlog.setPtSequence(backlogequence);
		projectTask.setProjectSequence(projectIdentifier+"-"+backlogequence);
		
		if(projectTask.getPriority()==0) {
			projectTask.setPriority(3);
		}
		
		if(projectTask.getStatus() == "" && projectTask.getStatus()== null) {
			projectTask.setStatus("TO-DO");
		}
		
	
		return projectTaskRepo.save(projectTask);
	}

}
