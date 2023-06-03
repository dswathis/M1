package com.cg.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Project;
import com.cg.exceptions.ResourceNotFoundException;
import com.cg.repository.Projectrepository;

@Service
public class ProjectImpl implements ProjectService{
	
     @Autowired
	private Projectrepository repository;
	
	@Override
	public Project createProject(Project project) throws Exception {
           if(project.getProjectname()=="" || project.getDescription()=="") 
        	   throw new ResourceNotFoundException("Project Name and description should not be empty");
		project.setCreatedate(LocalDate.now());
		return repository.save(project);
	}

	@Override
	public Project updateProject(Project project, Long uid) throws ResourceNotFoundException {
		
		Project u=repository.findById(uid).
				orElseThrow(()->new ResourceNotFoundException("project Not found with id : " + uid));
		u.setDescription(project.getDescription());
		u.setProjectId(uid);
		u.setCreatedate(LocalDate.now());
		u.setProjectname(project.getProjectname());
		
		
		return repository.save(u);
	}

	@Override
	public void deleteproject(Long id) throws ResourceNotFoundException {
		Project u = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("project Not found with id : " + id));
		repository.deleteById(id);

		
	}

	@Override
	public Project findProjectById(Long id) throws ResourceNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("project Not found with id : " + id));
	}	
		
	

	@Override
	public List<Project> showProjects() {
		
		return repository.findAll();
	}

}
