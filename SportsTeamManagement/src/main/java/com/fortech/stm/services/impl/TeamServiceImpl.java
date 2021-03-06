package com.fortech.stm.services.impl;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortech.stm.model.TeamEntity;
import com.fortech.stm.persistence.JPAUtility;
import com.fortech.stm.services.TeamService;

@Service("teamServiceinjected")
@Transactional
public class TeamServiceImpl implements TeamService{


	public void updateTeamDetails(TeamEntity team) {
		
		EntityManager em = JPAUtility.getEntityManager();
		try {
			Query q = em.createQuery("UPDATE TeamEntity AS c SET c.foundedInYear =:foundedInYear WHERE c.teamName= :teamName");
					q.setParameter("playerName", team.getTeamName());
					q.setParameter("foundedInYear", team.getFoundedInYear());
			int result = q.executeUpdate();
			System.out.println(result + " checkpoint");
		} catch (NoResultException nre) {
			//do nothing, no result is okay.
		}  	
		
	}

	public void deleteTeam(TeamEntity team) {
		EntityManager em = JPAUtility.getEntityManager();
		try {
			Query q = em.createQuery("DELETE FROM TeamEntity AS c WHERE c.teamName= :teamName");
					q.setParameter("teamName", team.getTeamName());
			int result = q.executeUpdate();
			System.out.println(result + " checkpoint");
		} catch (NoResultException nre) {
			//do nothing, no result is okay.
		}  	
		
		
	}

	public TeamEntity searchTeam(TeamEntity team)
	{
		EntityManager em = JPAUtility.getEntityManager();
		TeamEntity p = null;
		try {
			p =(TeamEntity) em.createNamedQuery("TeamEntity.findPTeamsByNameOrCategoryOrScore")
					.setParameter("teamName",team.getTeamName())
					.setParameter("sportsCategory",team.getSportsCategory())
					.setParameter("ratingScore", team.getRatingScore())
					.getSingleResult();
		} catch (NoResultException nre) {
			//do nothing, no result is okay.
		}  		 
		return p;
	}
	
	
	public void createTeam(TeamEntity team) {
		EntityManager em = JPAUtility.getEntityManager();
		TeamEntity p = null;
		try {
			p =(TeamEntity) em.createNamedQuery("TeamEntity.findTeamByTeamName")
					.setParameter("teamName",team.getTeamName())
					.getSingleResult();
		} catch (NoResultException nre) {
			//do nothing, no result is okay.
		}  		 
		if (p== null) { 
			//team does not exist in DB so it can be saved.
			em.getTransaction().begin();
			em.persist(team);
			em.getTransaction().commit();
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<TeamEntity> retrieveAllTeams() {
		// TODO Auto-generated method stub
		EntityManager em = JPAUtility.getEntityManager();
		List<TeamEntity> p = null;
		try {
			Query q =em.createNamedQuery("TeamEntity.findallteams");
			p = q.getResultList();
			
		} catch (NoResultException nre) {
			//do nothing, no result is okay.
		}  
		return p;
	}

	public List<TeamEntity> deleteAllTeams() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isTeamExistent(TeamEntity team) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TeamEntity> findTeamsByName(String playerName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TeamEntity> findPTeamsBySportsCategory(String sportsCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TeamEntity> findTeamsByRatingScore(long minimumRatingScore, long maximumRatingScore) {
		// TODO Auto-generated method stub
		return null;
	}

}
