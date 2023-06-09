package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.TaskDto;
import com.cg.entity.Tasks;
import com.cg.entity.TeamMember;
import com.cg.exceptions.ResourceNotFoundException;
import com.cg.services.Tasksservice;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {
	
	@Autowired
	private Tasksservice taskservice;
	
	@PostMapping({"/task/{userId}/{projectId}"})
	public ResponseEntity<Tasks> createTask(@RequestBody @Valid TaskDto taskdto,@PathVariable Long userId,@PathVariable Long projectId) throws Exception {
		return new ResponseEntity<>(taskservice.createTasks(taskdto,userId,projectId), HttpStatus.CREATED);
	};

	
	@GetMapping("/showAlltasks")
	public ResponseEntity<List<Tasks>> showTasks() throws ResourceNotFoundException {
		return ResponseEntity.ok(taskservice.showListOfTaskss());

	}
	
	@PutMapping({ "/updatetasksById/{uid}"})
	public ResponseEntity<Tasks> updateTask(@RequestBody @Valid Tasks task, @PathVariable Long uid)
			throws ResourceNotFoundException {
		return ResponseEntity.ok(taskservice.updateTask(task, uid));
	}
	
	@PutMapping({ "/updatetasksById/{uid}/{userid}"})
	public ResponseEntity<Tasks> updateTask(@RequestBody @Valid TaskDto task, @PathVariable Long uid,@PathVariable Long userid)
			throws ResourceNotFoundException {
		return ResponseEntity.ok(taskservice.updateTasks(task, uid,userid));
	}

	@DeleteMapping({"/deletetasksById/{id}"})
	public ResponseEntity<?> deleteTask(@PathVariable Long id) throws ResourceNotFoundException {
		taskservice.deleteTasks(id);
		return ResponseEntity.ok("Dleted user ");

	}

	@GetMapping("/findtasksById/{id}")
	public ResponseEntity<?> findTaskById(@PathVariable Long id) throws ResourceNotFoundException {
		return new ResponseEntity<Tasks>(taskservice.findTasksById(id), HttpStatus.OK);
	}

	
	@GetMapping("/findtasksByuserId/{id}")
	public ResponseEntity<?> findtasksById(@PathVariable Long id) throws ResourceNotFoundException {
		return new ResponseEntity<List<Tasks>>(taskservice.showTasksByTeamMemberId(id),HttpStatus.OK);
	}

	@GetMapping("/findtasksByprojectId/{id}")
	public ResponseEntity<?> findtasksByprojectId(@PathVariable Long id) throws ResourceNotFoundException {
		return new ResponseEntity<List<Tasks>>(taskservice.showTasksByprojectId(id),HttpStatus.OK);
	}

	

	
//	@PutMapping("/updatetaskstatus/{status}")
//	public ResponseEntity<?> findtasksByStatusd(@PathVariable String status) throws ResourceNotFoundException {
//		return new ResponseEntity<List<Tasks>>(taskservice.updateTasksStatus(),HttpStatus.OK);
//	}

	

}


//updateTasksStatus