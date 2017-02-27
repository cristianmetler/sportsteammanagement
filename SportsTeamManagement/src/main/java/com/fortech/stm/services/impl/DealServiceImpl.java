package com.fortech.stm.services.impl;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

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
			p =(DealEntity) em.createNamedQuery("DealEntity.findDealByDealName")
					.setParameter("desire",dealmodel.getDesire())
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

	public void deleteDeal(DealEntity dealmodel) {
		EntityManager em = JPAUtility.getEntityManager();
		try {
			Query q = em.createQuery("DELETE FROM TeamEntity AS c WHERE c.desire= :desire");
					q.setParameter("desire", dealmodel.getDesire());
			int result = q.executeUpdate();
			System.out.println(result + " checkpoint");
		} catch (NoResultException nre) {
			//do nothing, no result is okay.
		}  	
		
		
		
	}

	public DealEntity searchDeal(DealEntity dealmodel) {
		
		
			EntityManager em = JPAUtility.getEntityManager();
			DealEntity p = null;
			try 		{	p =(DealEntity) em.createNamedQuery("DealEntity.findDealByDealName")
					.setParameter("desire",dealmodel.getDesire())
					.getSingleResult();
			} catch (NoResultException nre) {
				//do nothing, no result is okay.
			}  		 
			return p;
		
		
	}

	@SuppressWarnings("unchecked")
	public List<DealEntity> retrieveAllDeals() {

		EntityManager em = JPAUtility.getEntityManager();
		List<DealEntity> p = null;
		try {
			Query q =em.createNamedQuery("DealEntity.findalldeals");
			p = q.getResultList();
			
		} catch (NoResultException nre) {
			//do nothing, no result is okay.
		}  
		return p;
		
	}

	
	@Override
	public void makeNewADeal(List<PlayerEntity> playerList, List<TeamEntity> teamList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateADeal(List<PlayerEntity> playerList, List<TeamEntity> teamList) {
		// TODO Auto-generated method stub
		
	}

	public void updateDeal(DealEntity dealmodel) {
		EntityManager em = JPAUtility.getEntityManager();
		try {
			Query q = em.createQuery("UPDATE DealEntity AS c SET c.numberOfPlayersBought =:numberOfPlayersBought AND c.numberOfPlayerssold = :numberOfPlayerssold  WHERE c.desire= :desire");
					q.setParameter("desire", dealmodel.getDesire());
					q.setParameter("numberOfPlayersBought", dealmodel.getNumberOfPlayersBought());
					q.setParameter("numberOfPlayersSold", dealmodel.getNumberOfPlayerssold());
			int result = q.executeUpdate();
			System.out.println(result + " checkpoint");
		} catch (NoResultException nre) {
			//do nothing, no result is okay.
		}  	
		
	}



}
