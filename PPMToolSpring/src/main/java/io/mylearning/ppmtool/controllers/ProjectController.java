package io.mylearning.ppmtool.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	private ProjectService projectService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	@CrossOrigin(origins="http://localhost:3000")
	public ResponseEntity<?> createProject(@Valid @RequestBody Project p,BindingResult result){
		
		ResponseEntity<Map<String,String>> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap != null) return errorMap;
		
		Project project = projectService.createOrUpdateProject(p);
		return new ResponseEntity<Project>(project,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{projectId}")
	public ResponseEntity<?> getProjectByProjectId(@PathVariable String projectId ){
		
		Project project = projectService.findProjectByProjectId(projectId);
		
		return new ResponseEntity<Project>(project,HttpStatus.OK);
		
	}
	
	
	@GetMapping("")
	public Iterable<Project> getAllProjects(){
		return projectService.getAllProjects();
	}
	
	@DeleteMapping("/{projectId}")
	
	public ResponseEntity<?>deleteProject(@PathVariable String projectId){
		projectService.deleteProject(projectId);
		return new ResponseEntity<String>("Project with id "+projectId+" Deleted Successfully",HttpStatus.OK);
	}
	
	
	@PutMapping("")
	
	public ResponseEntity<?>updateProject(@Valid @RequestBody Project project){
		Project project1=projectService.updateProject(project);
		return new ResponseEntity<Project>(project1,HttpStatus.OK);
	}
	@GetMapping("/test")
	public ResponseEntity<String> createProject(){
		
		return new ResponseEntity<String>("Application Running",HttpStatus.OK);
		
	}
	
	

}
