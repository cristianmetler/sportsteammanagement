package com.fortech.stm.controller;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.fortech.stm.persistence.EncryptionUtils;
import com.fortech.stm.persistence.UserCredentials;
import com.fortech.stm.persistence.UserCredentialsDAOImpl;
import com.fortech.stm.services.impl.DealServiceImpl;
import com.fortech.stm.services.impl.TeamServiceImpl;




@RestController
public class SportsTeamAuthentificationController {

	
	final static Logger logger = Logger.getLogger(SportsTeamAuthentificationController.class);
	
	 @Autowired 
	 TeamServiceImpl teamService;
	 @Autowired
	 DealServiceImpl dealService;
	 @Autowired
	 UserCredentialsDAOImpl uc;
	     

	    @RequestMapping(value="/", method= RequestMethod.GET)
	    public ModelAndView firstPage() {
	    return new ModelAndView("redirect:"+"/login/login.jsp");

	    }	    	    
	    
	    @RequestMapping(value="/ceva", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public UserCredentials UserCredentials(@RequestBody UserCredentials authenticateUserRequest) throws SQLException {
	    	UserCredentials user = new UserCredentials();
	    	//encrypt the data before searching/saving in DB
	    	user.setUsername(EncryptionUtils.encryptString(authenticateUserRequest.getUsername()));
	    	user.setPassword(EncryptionUtils.encryptString(authenticateUserRequest.getPassword()));
	    	if ( (uc.findUser(user.getUsername())) == null ) {
	    		if(logger.isDebugEnabled()){
	    		    logger.debug("Login user does not exist - you're gonna have to login again");
	    		}
	    		return null;
	    		
	    	}
	    	//decrypt the data when returning to view
	    	user.setUsername(EncryptionUtils.decryptString(user.getUsername()));
	    	user.setPassword(EncryptionUtils.decryptString(user.getPassword()));
    		if(logger.isDebugEnabled()){
    		    logger.debug("User successfully logged in !");
    		}
	    		return user;
	    		    	
	    }	    
	    
	    @RequestMapping(value="/ggg", method= RequestMethod.GET)
	    public void register() throws SQLException {
	    	return;
	    	}
	    	    
	    @RequestMapping(value="/register", method= RequestMethod.POST, consumes =MediaType.APPLICATION_JSON_VALUE)
	    public UserCredentials performRegistration(@RequestBody UserCredentials authenticateUserRequest) throws SQLException {
	    	UserCredentials user = new UserCredentials();
	    	user.setUsername(EncryptionUtils.encryptString(authenticateUserRequest.getUsername()));
	    	user.setPassword(EncryptionUtils.encryptString(authenticateUserRequest.getPassword()));
	    	if (uc.findUser(user.getUsername()) == null) {
	    		uc.save(user);
	    		if(logger.isDebugEnabled()){
	    		    logger.debug("User has been registered in the system!");
	    		    logger.error("beach please!");
	    		}
		    	user.setUsername(EncryptionUtils.decryptString(user.getUsername()));
		    	user.setPassword(EncryptionUtils.decryptString(user.getPassword()));
		    	return user;
	    	    }
	    	else {
	    		if(logger.isDebugEnabled()){
	    		    logger.debug("User already exists - please login with him!");
	    		}
	    		return null;
	    	}
	    }
	    
	    }
	    
