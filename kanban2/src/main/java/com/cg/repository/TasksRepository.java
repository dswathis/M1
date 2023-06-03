package com.cg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Tasks;
import com.cg.entity.TeamMember;


@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {
	
	@Query(value="SELECT * FROM tasks WHERE project_details_fk=?1",nativeQuery = true)
	List<Tasks> findTasksByprojectId(long userId);
	
	@Query(value="SELECT * FROM tasks WHERE user_details_fk=?1",nativeQuery = true)
	List<Tasks> findTasksByTeamMemberId(long userId);
	
	

}


