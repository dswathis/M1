package com.cg.services;

import java.util.List;
import java.util.Optional;

import com.cg.entity.Progress;
import com.cg.entity.Status;
import com.cg.entity.TaskDto;
import com.cg.entity.Tasks;
import com.cg.exceptions.ResourceNotFoundException;

public interface Tasksservice {
	
	Tasks createTasks(TaskDto TaskDto,Long teamMemberId,Long projectId) throws ResourceNotFoundException;

	Tasks updateTasks(TaskDto tasks,Long id,Long TeamMemberId) throws ResourceNotFoundException;

	Tasks findTasksById(Long id) throws ResourceNotFoundException;

	void deleteTasks(Long id) throws ResourceNotFoundException;

	List<Tasks> showListOfTaskss() throws ResourceNotFoundException;
	
	List<Tasks> showTasksByTeamMemberId(Long teamMemberId)  throws ResourceNotFoundException;;
	
	List<Tasks> showTasksByprojectId(Long projectId)  throws ResourceNotFoundException;;


	

	 Tasks updateTask(Tasks tasks, Long uid) throws ResourceNotFoundException ;
}
