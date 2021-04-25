package io.mylearning.ppmtool.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mylearning.ppmtool.domain.Project;
import io.mylearning.ppmtool.services.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectSerice;
	
	@PostMapping("/saveProject")
	public ResponseEntity<?> createProject(@Valid @RequestBody Project p,BindingResult result){
		
		if(result.hasErrors()) {
			return new ResponseEntity<String>( "Invalid Object",HttpStatus.BAD_REQUEST);
		}
		
		Project project = projectSerice.createOrUpdateProject(p);
		return new ResponseEntity<Project>(project,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> createProject(){
		
		return new ResponseEntity<String>("Application Running",HttpStatus.OK);
		
	}
	
	

}
