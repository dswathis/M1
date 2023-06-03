package com.cg.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entity.TeamMember;
import com.cg.exceptions.ResourceNotFoundException;


public interface TeamMemberService {

	TeamMember registerTeamMember(TeamMember teamMember) throws Exception;

	//TeamMember1 getTeamMember(Long uid) throws ResourceNotFoundException;
	

	TeamMember updateTeamMember(TeamMember teamMember, Long uid) throws ResourceNotFoundException;

	void deleteTeamMember(Long id) throws ResourceNotFoundException;

	TeamMember findTeamMemberById(Long id) throws ResourceNotFoundException;
//
//	TeamMember1 findTeamMemberByEmail(String email) throws ResourceNotFoundException;
//
//	TeamMember1 findTeamMemberByName(String name) throws ResourceNotFoundException;

	TeamMember loginTeamMember(String teamMemberName, String password) throws ResourceNotFoundException;

	TeamMember changePassword(String oldPassword, String newPassword) throws ResourceNotFoundException, Exception;

	List<TeamMember> showTeamMembers();


	
	
	
	
	
	
}
