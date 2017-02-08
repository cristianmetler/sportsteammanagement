package com.fortech.stm.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    
}
