package io.mylearning.ppmtool.reporsitories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.mylearning.ppmtool.domain.ProjectTask;

@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long>{

}
