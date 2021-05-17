package io.mylearning.ppmtool.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.engine.internal.Cascade;
import org.hibernate.engine.spi.CascadeStyles;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank(message="Project name is required")
	private String projectName;
	@NotBlank(message="Project Identifier is required")
	@Size(min=4,max=5,message="Please enter 4 to 5 character long")
	@Column(updatable=false,unique=true)
	private String projectIdentifier;
	@NotBlank(message="Project Description is required")
	private String projectDesc;
	@JsonFormat(pattern="yyyy-mm-dd")
	private Date startDate;
	@JsonFormat(pattern="yyyy-mm-dd")
	private Date endDate;
	@JsonFormat(pattern="yyyy-mm-dd")
	private Date createdAt;
	@JsonFormat(pattern="yyyy-mm-dd")
	private Date updatedAt;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="project")
	Backlog backlog;
	
	
	public Backlog getBacklog() {
		return backlog;
	}

	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}

	public Project() {
		super();
	}
	
	@PrePersist
	public void onCreate() {
		this.createdAt= new Date();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updatedAt= new Date();
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectIdentifier() {
		return projectIdentifier;
	}
	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}
	public String getProjectDesc() {
		return projectDesc;
	}
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
	
	
	
	
	
	

}
