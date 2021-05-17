package io.mylearning.ppmtool.reporsitories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.mylearning.ppmtool.domain.Backlog;
import java.lang.String;
import java.util.List;

@Repository
public interface BacklogRepositories extends CrudRepository<Backlog, Long>{
	Backlog findByProjectIdentifier(String projectidentifier);
}
