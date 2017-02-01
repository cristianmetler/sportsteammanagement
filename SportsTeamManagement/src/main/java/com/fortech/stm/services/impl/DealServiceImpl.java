package com.fortech.stm.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortech.stm.model.PlayerEntity;
import com.fortech.stm.model.TeamEntity;
import com.fortech.stm.services.DealService;

@Service("dealService")
@Transactional
public class DealServiceImpl implements DealService {

	public void makeNewADeal(List<PlayerEntity> playerList, List<TeamEntity> teamList) {
		// TODO Auto-generated method stub
		
	}

	public void updateADeal(List<PlayerEntity> playerList, List<TeamEntity> teamList) {
		// TODO Auto-generated method stub
		
	}

}
