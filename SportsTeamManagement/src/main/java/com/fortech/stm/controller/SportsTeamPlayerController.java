package com.fortech.stm.controller;

import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fortech.stm.model.PlayerEntity;
import com.fortech.stm.services.impl.PlayerServiceImpl;

@RestController
public class SportsTeamPlayerController {

	 @Autowired
	 PlayerServiceImpl playerServiceinjected;
    
    @RequestMapping(value="/addplayer", method= RequestMethod.POST, consumes =MediaType.APPLICATION_JSON_VALUE)
    public void addPlayer(@RequestBody PlayerEntity playermodel) throws SQLException {
    	playerServiceinjected.createPlayer(playermodel);
    }  
    @RequestMapping(value="/searchplayer", method= RequestMethod.POST, consumes =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlayerEntity> retrieveAllPlayers(@RequestBody PlayerEntity playermodel) throws SQLException {
    	PlayerEntity p =playerServiceinjected.searchPlayer(playermodel);
    	if (p==null) {
            return new ResponseEntity<PlayerEntity>(HttpStatus.NOT_FOUND);
    	} 

    	else {
    		   return new ResponseEntity<PlayerEntity>(p, HttpStatus.OK);
    	}
 
    }   
    
}
