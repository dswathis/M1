package com.cg.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskDto {
	

	
    private Long taskId;
	
	private String taskname;
	
	private String detail;
	

}
