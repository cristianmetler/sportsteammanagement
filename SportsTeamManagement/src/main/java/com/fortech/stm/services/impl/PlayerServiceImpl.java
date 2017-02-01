package com.fortech.stm.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortech.stm.model.PlayerEntity;
import com.fortech.stm.services.PlayerService;

@Service("playerService")
@Transactional
public class PlayerServiceImpl implements PlayerService {

	public List<PlayerEntity> findPlayersByName(String playerName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PlayerEntity> findPlayersBySportsCategory(String sportsCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PlayerEntity> findPlayersByIncome(long minimumIncome, long maximumIncome) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PlayerEntity> findPlayersByTeamName(String teamName) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updatePlayerDetails(PlayerEntity player) {
		// TODO Auto-generated method stub
		
	}

	public void deletePlayer(PlayerEntity player) {
		// TODO Auto-generated method stub
		
	}

	public void createPlayer(PlayerEntity player) {
		// TODO Auto-generated method stub
		
	}

	public List<PlayerEntity> retrieveAllPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PlayerEntity> deleteAllPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isPlayerExistent(PlayerEntity player) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<PlayerEntity> findPlayersByRank(int rank) {
		// TODO Auto-generated method stub
		return null;
	}

}
