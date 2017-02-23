package com.fortech.stm.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fortech.stm.model.DealEntity;
import com.fortech.stm.services.impl.DealServiceImpl;



@RestController
public class SportsTeamDealsController {

	 @Autowired
	 DealServiceImpl dealServiceinjected;
	
    @RequestMapping(value="/adddeal", method= RequestMethod.POST, consumes =MediaType.APPLICATION_JSON_VALUE)
    public void addDeal(@RequestBody DealEntity dealmodel) throws SQLException {
    	dealServiceinjected.createDeal(dealmodel);
    }  
    
    @RequestMapping(value="/searchdeal", method= RequestMethod.POST, consumes =MediaType.APPLICATION_JSON_VALUE)
    public DealEntity searchDeal(@RequestBody DealEntity teammodel) throws SQLException {
    	DealEntity te = dealServiceinjected.searchDeal(teammodel);
    	return te;
    }  
    
//    @RequestMapping(value="/updateteam", method= RequestMethod.POST, consumes =MediaType.APPLICATION_JSON_VALUE)
//    public void updateTeam(@RequestBody DealEntity teammodel) throws SQLException {
//    	teamServiceinjected.createTeam(teammodel);
//    }  
//       
    @RequestMapping(value="/deletedeal", method= RequestMethod.POST, consumes =MediaType.APPLICATION_JSON_VALUE)
    public void deleteTeam(@RequestBody DealEntity teammodel) throws SQLException {
    	dealServiceinjected.deleteDeal(teammodel);
    }  
//    	
//    @RequestMapping(value="/deleteallteams", method= RequestMethod.POST, consumes =MediaType.APPLICATION_JSON_VALUE)
//    public DealEntity deleteAllTeams(@RequestBody DealEntity teammodel) throws SQLException {
//    	DealEntity te = teamServiceinjected.searchTeam(teammodel);
//    	return te;
//    }  
//    	
    @RequestMapping(value="/findalldeals", method= RequestMethod.GET, produces =MediaType.APPLICATION_JSON_VALUE)
    public List<DealEntity> findAllTeams() throws SQLException {
    	List<DealEntity> list = dealServiceinjected.retrieveAllDeals();
    	return list;
    	
    }  
	
	
}
