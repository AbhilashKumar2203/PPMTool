package io.mylearning.ppmtool.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Backlog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Integer ptSequence=0;
	@Column(updatable = false)
	private String projectIdentifier;
	
	//OnToOne mapping with Project
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="project_id",nullable=false)
	@JsonIgnore
	Project project;
	
	//oneToMany with Project Task
	
	@OneToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL,mappedBy="backlog")
	List<ProjectTask> projectTasks = new ArrayList<ProjectTask>();
	
	
	public List<ProjectTask> getProjectTasks() {
		return projectTasks;
	}
	public void setProjectTasks(List<ProjectTask> projectTasks) {
		this.projectTasks = projectTasks;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Backlog() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Integer getPtSequence() {
		return ptSequence;
	}
	public void setPtSequence(Integer ptSequence) {
		this.ptSequence = ptSequence;
	}
	public String getProjectIdentifier() {
		return projectIdentifier;
	}
	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}
	
	
	
	
}
