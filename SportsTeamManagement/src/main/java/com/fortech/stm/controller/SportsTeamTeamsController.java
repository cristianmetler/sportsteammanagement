package com.fortech.stm.controller;

import java.sql.SQLException;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fortech.stm.model.TeamEntity;
import com.fortech.stm.services.impl.TeamServiceImpl;

@RestController
public class SportsTeamTeamsController {
	 @Autowired
	 TeamServiceImpl teamServiceinjected;
	
    @RequestMapping(value="/addteam", method= RequestMethod.POST, consumes =MediaType.APPLICATION_JSON_VALUE)
    public void addTeam(@RequestBody TeamEntity teammodel) throws SQLException {
    	teamServiceinjected.createTeam(teammodel);
    }  
    
    
    
    
    
    @RequestMapping(value="/searchteam", method= RequestMethod.POST, consumes =MediaType.APPLICATION_JSON_VALUE)
    public TeamEntity searchTeam(@RequestBody TeamEntity teammodel) throws SQLException {
    	TeamEntity te = teamServiceinjected.searchTeam(teammodel);
    	return te;
    }  
    
	
	
}
