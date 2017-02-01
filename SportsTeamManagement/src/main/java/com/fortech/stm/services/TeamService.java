package com.fortech.stm.services;

import java.util.List;

import com.fortech.stm.model.TeamEntity;

public interface TeamService {

	List<TeamEntity> findTeamsByName(String playerName);
	
	List<TeamEntity> findPTeamsBySportsCategory(String sportsCategory);
	
	List<TeamEntity> findTeamsByRatingScore(long minimumRatingScore, long maximumRatingScore);
		
	void updateTeamDetails(TeamEntity player);
	
	void deleteTeam(TeamEntity player);
	
	void createTeam(TeamEntity player);
	
	List<TeamEntity> retrieveAllTeams();
	
	List<TeamEntity> deleteAllTeams();
	
	boolean isTeamExistent(TeamEntity team);
}
