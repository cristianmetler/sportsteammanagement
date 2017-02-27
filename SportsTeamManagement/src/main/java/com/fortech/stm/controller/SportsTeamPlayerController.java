package com.fortech.stm.controller;

import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fortech.stm.model.PlayerEntity;
import com.fortech.stm.model.TeamEntity;
import com.fortech.stm.services.impl.PlayerServiceImpl;
import com.fortech.stm.services.impl.TeamServiceImpl;

@RestController
public class SportsTeamPlayerController {

	 @Autowired
	 PlayerServiceImpl playerServiceinjected;
    
 
    @RequestMapping(value="/addplayer", method= RequestMethod.POST, consumes =MediaType.APPLICATION_JSON_VALUE)
	    public void addPlayer(@RequestBody PlayerEntity playermodel) throws SQLException {
	    	playerServiceinjected.createPlayer(playermodel);
	    } 
    
    
    @RequestMapping(value="/searchplayer", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public PlayerEntity retrieveAllPlayers(@RequestBody PlayerEntity playermodel) throws SQLException {
    	PlayerEntity p =playerServiceinjected.searchPlayer(playermodel);
    return p;
    }   
    
    @RequestMapping(value="/updateplayer", method= RequestMethod.POST, consumes =MediaType.APPLICATION_JSON_VALUE)
    public void updatePlayer(@RequestBody PlayerEntity playermodel) throws SQLException {
    	playerServiceinjected.updatePlayer(playermodel);
    }
    
    @RequestMapping(value="/deleteplayer", method= RequestMethod.POST, consumes =MediaType.APPLICATION_JSON_VALUE)
    public void deletePlayer(@RequestBody PlayerEntity playermodel) throws SQLException {
    	playerServiceinjected.deletePlayer(playermodel);
    }


    
    @RequestMapping(value="/searchallplayers", method= RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PlayerEntity> searchAllPlayers() throws SQLException {
    	List<PlayerEntity> players = playerServiceinjected.findAllPlayers();
    	return players;
    }



}



