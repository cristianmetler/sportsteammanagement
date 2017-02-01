package com.fortech.stm.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortech.stm.model.TeamEntity;
import com.fortech.stm.services.TeamService;

@Service("teamService")
@Transactional
public class TeamServiceImpl implements TeamService{

	public List<TeamEntity> findTeamsByName(String playerName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TeamEntity> findPTeamsBySportsCategory(String sportsCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TeamEntity> findTeamsByRatingScore(long minimumRatingScore, long maximumRatingScore) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateTeamDetails(TeamEntity player) {
		// TODO Auto-generated method stub
		
	}

	public void deleteTeam(TeamEntity player) {
		// TODO Auto-generated method stub
		
	}

	public void createTeam(TeamEntity player) {
		// TODO Auto-generated method stub
		
	}

	public List<TeamEntity> retrieveAllTeams() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TeamEntity> deleteAllTeams() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isTeamExistent(TeamEntity team) {
		// TODO Auto-generated method stub
		return false;
	}

}
