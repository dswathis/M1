package com.cg.services;

import java.util.List;

import com.cg.entity.Project;
import com.cg.entity.Status;
import com.cg.entity.StatusDto;
import com.cg.entity.Tasks;
import com.cg.entity.TeamMember;
import com.cg.exceptions.ResourceNotFoundException;


public interface StatusService {
	Status createstatus(StatusDto Statusdto,Long taskId) throws Exception;
	
	void deletestatus(long id) throws ResourceNotFoundException;
	
	List<Status> showstatus();
	
	Status  updatestatus(StatusDto Statusdto , Long uid) throws ResourceNotFoundException;

	Status findStatusById(Long id) throws ResourceNotFoundException;
	Tasks findTasksById(Long id) throws ResourceNotFoundException;
	
	List<Status> showTasksByUserId(Long userId)  throws ResourceNotFoundException;;
	
	//findbyid
	//find by user id
	//
	
}
