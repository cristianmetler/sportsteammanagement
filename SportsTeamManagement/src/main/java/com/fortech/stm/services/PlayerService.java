package com.fortech.stm.services;

import java.util.List;

import com.fortech.stm.model.PlayerEntity;

public interface PlayerService {

	
	List<PlayerEntity> findPlayersByName(String playerName);
	
	List<PlayerEntity> findPlayersBySportsCategory(String sportsCategory);
	
	
	List<PlayerEntity> findPlayersByTeamName(String teamName);
	
	List<PlayerEntity> findPlayersByRank(int rank);
	
	void updatePlayerDetails(PlayerEntity player);
	
	void deletePlayer(PlayerEntity player);
	
	void createPlayer(PlayerEntity player);
	
	List<PlayerEntity> retrieveAllPlayers();
	
	List<PlayerEntity> deleteAllPlayers();
	
	boolean isPlayerExistent(PlayerEntity player);
	
}
