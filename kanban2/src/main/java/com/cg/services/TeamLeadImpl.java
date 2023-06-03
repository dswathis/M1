
package com.cg.services;
 
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.cg.entity.TeamLead;
import com.cg.exceptions.EmailAlreadyExistsException;
import com.cg.exceptions.ResourceNotFoundException;
import com.cg.repository.TeamLeadrepository;
 
@Service
public class TeamLeadImpl implements TeamLeadService{
   
    
	 @Autowired
	    private TeamLeadrepository repository;
	 
	    
	    @Override
	    public TeamLead createUser(TeamLead user)  {
	        
	    	Optional<TeamLead> optionalUser = repository.findByEmail(user.getEmail());

	        if(optionalUser.isPresent()){
	            throw new EmailAlreadyExistsException("Email Already Exists for User");
	        }
	        
	        Optional<TeamLead> optionalUser1 = repository.findByPassword(user.getPassword());
	        if(optionalUser1.isPresent()){
	            throw new EmailAlreadyExistsException("PASSWORD  ALREADY EXISTS TRY WITH ANOTHER PASSWORD");
	        }
	         user.setRole("TEAMLEAD");
	        return repository.save(user);
	    }
	 

    @Override
    public TeamLead updateUser(TeamLead user, Long uid) throws ResourceNotFoundException {
        TeamLead u = repository.findById(uid)
                .orElseThrow(() -> new ResourceNotFoundException("User Not found with id : " + uid));
        user.setRole("TEAMLEAD");
        user.setTeamLeadId(uid);
        user.setPassword(u.getPassword());    
        return repository.save(user);
    }
 
    @Override
    public void deleteUser(Long id) throws ResourceNotFoundException {
        TeamLead u = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User Not found with id : " + id));
        repository.deleteById(id);
 
    }
 
    @Override
    public TeamLead findUserById(Long id) throws ResourceNotFoundException {
 
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User Not found with id : " + id));
    }
 
        @Override
    public TeamLead authenticateUser(String userName, String password) throws ResourceNotFoundException {
        return repository.loginTeamLead(userName, password)
                .orElseThrow(() -> new ResourceNotFoundException("Bad or Invalid Credentials"));
    }
 
    @Override
    public TeamLead changePassword(String oldPassword, String newPassword) throws Exception {
        TeamLead u = repository.findByPassword(oldPassword)
                .orElseThrow(() -> new ResourceNotFoundException("Passsword is not correct.Please enter correct password"));
        u.setPassword(newPassword);  
        repository.save(u);
        return u;
    }
 
    @Override
    public List<TeamLead> showUsers() {
        return repository.findAll();
    }


	@Override
	public TeamLead updateUser1(Map<String, Object> fields, Long uid) throws ResourceNotFoundException {
		TeamLead u = repository.findById(uid)
                .orElseThrow(() -> new ResourceNotFoundException("User Not found with id : " + uid));
       // user.setRole("TEAMLEAD");
        fields.forEach((key, value) -> {
        Field field = ReflectionUtils.findField(TeamLead.class, key);
        field.setAccessible(true);
        ReflectionUtils.setField(field, u, value);
    });
		
		
		return repository.save(u);
	}



	@Override
	public String resetForgotPassword(String adminEmail, String newPassword)
			throws ResourceNotFoundException {
		
		TeamLead u=repository.findByEmail(adminEmail).
				orElseThrow(() -> new ResourceNotFoundException("Enter a valid email"));
		   u.setPassword(newPassword);
		   repository.save(u);   
		
	return "Password reset successfully";
	}}	
		

    
 



