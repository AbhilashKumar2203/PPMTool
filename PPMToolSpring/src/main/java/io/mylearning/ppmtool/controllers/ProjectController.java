package io.mylearning.ppmtool.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mylearning.ppmtool.domain.Project;
import io.mylearning.ppmtool.services.MapValidationErrorService;
import io.mylearning.ppmtool.services.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectSerice;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> createProject(@Valid @RequestBody Project p,BindingResult result){
		
		ResponseEntity<Map<String,String>> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap != null) return errorMap;
		
		Project project = projectSerice.createOrUpdateProject(p);
		return new ResponseEntity<Project>(project,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{projectId}")
	public ResponseEntity<?> getProjectByProjectId(@PathVariable String projectId ){
		
		Project project = projectSerice.findProjectByProjectId(projectId);
		
		return new ResponseEntity<Project>(project,HttpStatus.OK);
		
	}
	
	
	@GetMapping("")
	public Iterable<Project> getAllProjects(){
		return projectSerice.getAllProjects();
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> createProject(){
		
		return new ResponseEntity<String>("Application Running",HttpStatus.OK);
		
	}
	
	

}
