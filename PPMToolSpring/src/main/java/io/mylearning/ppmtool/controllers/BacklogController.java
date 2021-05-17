package io.mylearning.ppmtool.controllers;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mylearning.ppmtool.domain.ProjectTask;
import io.mylearning.ppmtool.services.MapValidationErrorService;
import io.mylearning.ppmtool.services.ProjectTaskSericeInterface;

@RestController
@RequestMapping("/api/backlog")
@CrossOrigin
public class BacklogController {
	
	@Autowired
	ProjectTaskSericeInterface projectTaskService;
	
	@Autowired
	MapValidationErrorService mapValidationError;
	
	@PostMapping("/{backlog_id}")
	public ResponseEntity<?> addProjectTaskToBacklog(@Valid @RequestBody ProjectTask projectTask,@PathVariable String backlog_id,BindingResult result){
		ResponseEntity<?> errorMap=mapValidationError.mapValidationError(result);
		if(errorMap != null) return errorMap;
		
		ProjectTask prjTask = projectTaskService.createProjectTask(backlog_id, projectTask);
		
		return new ResponseEntity<ProjectTask>(prjTask,HttpStatus.CREATED);
		
		
	}
	
	
	

}
