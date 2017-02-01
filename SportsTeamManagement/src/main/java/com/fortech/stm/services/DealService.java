package com.fortech.stm.services;

import java.util.List;

import com.fortech.stm.model.PlayerEntity;
import com.fortech.stm.model.TeamEntity;

public interface DealService {

	void makeNewADeal(List<PlayerEntity>playerList, List<TeamEntity> teamList);
	
	void updateADeal(List<PlayerEntity> playerList, List<TeamEntity> teamList);
	
	
}
