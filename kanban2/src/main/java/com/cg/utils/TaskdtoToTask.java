package com.cg.utils;

import com.cg.entity.Status;
import com.cg.entity.StatusDto;
import com.cg.entity.TaskDto;
import com.cg.entity.Tasks;

public class TaskdtoToTask {
	
	public static Tasks parseTaskDtotoTasks(TaskDto TaskDto) {
		Tasks Tasks = new Tasks();
		Tasks.setTaskId(TaskDto.getTaskId());
		Tasks.setTaskname(TaskDto.getTaskname());
		Tasks.setDetail(TaskDto.getDetail());
		return Tasks;
	}
	
	public static Status parseStatusDtotoStatus(StatusDto statusDto) {
		Status s=new Status();
		s.setStatusId(statusDto.getStatusId());
		//s.setPercentage(statusDto.getPercentage());
		s.setStatus(statusDto.getStatus());
		return s;
		
	}

}
