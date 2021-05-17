package io.mylearning.ppmtool.services;

import io.mylearning.ppmtool.domain.ProjectTask;

public interface ProjectTaskSericeInterface {

	ProjectTask createProjectTask(String projectIdentifier, ProjectTask projectTask);

}
