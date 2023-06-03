package com.cg.services;

import java.util.List;

import com.cg.entity.Project;
import com.cg.entity.TeamMember;
import com.cg.exceptions.ResourceNotFoundException;

public interface ProjectService {
	
	Project createProject(Project project) throws Exception;

	//Project getUser(Long uid) throws ResourceNotFoundException;
	

	Project updateProject(Project project , Long uid) throws ResourceNotFoundException;

	void deleteproject(Long id) throws ResourceNotFoundException;

	Project findProjectById(Long id) throws ResourceNotFoundException;

	List<Project> showProjects();
	

}
