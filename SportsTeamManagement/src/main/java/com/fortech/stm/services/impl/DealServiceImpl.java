package com.fortech.stm.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortech.stm.model.DealEntity;
import com.fortech.stm.model.PlayerEntity;
import com.fortech.stm.model.TeamEntity;
import com.fortech.stm.persistence.JPAUtility;
import com.fortech.stm.services.DealService;

@Service("dealServiceinjected")
@Transactional
public class DealServiceImpl implements DealService {

	public void createDeal(DealEntity dealmodel) {
		EntityManager em = JPAUtility.getEntityManager();
		DealEntity p = null;
		try {
			p =(DealEntity) em.createNamedQuery("DealEntity.findTeamByDealName")
					.setParameter("dealName",dealmodel.getDealname())
					.getSingleResult();
		} catch (NoResultException nre) {
			//do nothing, no result is okay.
		}  		 
		if (p== null) { 
			//deal does not exist in DB so it can be saved.
			em.getTransaction().begin();
			em.persist(dealmodel);
			em.getTransaction().commit();
		}
		
	}

	public void deleteDeal(DealEntity teammodel) {
		// TODO Auto-generated method stub
		
	}

	public DealEntity searchDeal(DealEntity teammodel) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DealEntity> retrieveAllDeals() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void makeNewADeal(List<PlayerEntity> playerList, List<TeamEntity> teamList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateADeal(List<PlayerEntity> playerList, List<TeamEntity> teamList) {
		// TODO Auto-generated method stub
		
	}



}
