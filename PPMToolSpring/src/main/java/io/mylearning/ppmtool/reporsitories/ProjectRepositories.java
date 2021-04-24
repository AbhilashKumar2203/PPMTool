package io.mylearning.ppmtool.reporsitories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.mylearning.ppmtool.domain.Project;

@Repository
public interface ProjectRepositories extends CrudRepository<Project, Long> {
	
	@Override
	default Iterable<Project> findAllById(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
