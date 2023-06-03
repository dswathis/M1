
package com.cg.services;
 
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
 
import com.cg.entity.TeamLead;
import com.cg.exceptions.ResourceNotFoundException;
 

public interface TeamLeadService {
 
    TeamLead createUser(TeamLead user) throws Exception;
 
    
 
    TeamLead updateUser(TeamLead user, Long uid) throws ResourceNotFoundException;
 
    void deleteUser(Long id) throws ResourceNotFoundException;
 
    TeamLead findUserById(Long id) throws ResourceNotFoundException;
 
    TeamLead authenticateUser(String userName, String password) throws ResourceNotFoundException;
 
    TeamLead changePassword(String oldPassword, String newPassword) throws ResourceNotFoundException, Exception;
 
    List<TeamLead> showUsers();



	TeamLead updateUser1(Map<String, Object> fields, Long uid) throws ResourceNotFoundException;
 
//     String resetPassword(String adminEmail, String adminPassword, String newPassword) throws ResourceNotFoundException;
	
	String resetForgotPassword(String adminEmail, String newPassword) throws ResourceNotFoundException;






}

