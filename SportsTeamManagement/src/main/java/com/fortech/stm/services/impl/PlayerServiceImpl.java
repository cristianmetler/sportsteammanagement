package com.fortech.stm.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortech.stm.model.PlayerEntity;
import com.fortech.stm.persistence.JPAUtility;
import com.fortech.stm.persistence.UserCredentials;
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


	public List<PlayerEntity> findPlayersByTeamName(String teamName) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updatePlayer(PlayerEntity player) {
		EntityManager em = JPAUtility.getEntityManager();
		try {
			Query q = em.createQuery("UPDATE PlayerEntity AS c SET c.age = :age WHERE c.playerName= :playerName");
					q.setParameter("playerName", player.getPlayerName());
					q.setParameter("age", player.getAge());
			int result = q.executeUpdate();
			System.out.println(result + " checkpoint");
		} catch (NoResultException nre) {
			//do nothing, no result is okay.
		}  	
		

	}

	public void deletePlayer(PlayerEntity player) {
		EntityManager em = JPAUtility.getEntityManager();
		try {
			Query q = em.createQuery("DELETE FROM PlayerEntity AS c WHERE c.playerName= :playerName");
					q.setParameter("playerName", player.getPlayerName());
			int result = q.executeUpdate();
			System.out.println(result + " checkpoint");
		} catch (NoResultException nre) {
			//do nothing, no result is okay.
		}  	
		
	}
		@SuppressWarnings("unchecked")
		public List<PlayerEntity> findAllPlayers() {
			EntityManager em = JPAUtility.getEntityManager();
			List<PlayerEntity> players = null;
			try {
				Query q = em.createNamedQuery("PlayerEntity.findAllPlayers");
						
				players =q.getResultList();

			} catch (NoResultException nre) {
				//do nothing, no result is okay.
			}  	
			return players;
	}
		
		
		
	public PlayerEntity searchPlayer(PlayerEntity player) {
		EntityManager em = JPAUtility.getEntityManager();
		PlayerEntity p = null;
		
		try {
			p =(PlayerEntity) em.createNamedQuery("PlayerEntity.findPlayersByNameorTeamorCategory")
					.setParameter("playerName",player.getPlayerName())
					.setParameter("teamName", player.getTeamName())
					.setParameter("sportsCategory", player.getSportsCategory())
					.getSingleResult();
		} catch (NoResultException nre) {
			//do nothing, no result is okay.
		}  	
		return p;
	}
	

	public void createPlayer(PlayerEntity player) {
		EntityManager em = JPAUtility.getEntityManager();
		PlayerEntity p = null;
		try {
			p =(PlayerEntity) em.createNamedQuery("PlayerEntity.findPlayersByName")
					.setParameter("playerName",player.getPlayerName())
					.getSingleResult();
		} catch (NoResultException nre) {
			//do nothing, no result is okay.
		}  		 
		if (p== null) { 
			//player does not exist in DB so it can be saved.
			em.getTransaction().begin();
			em.persist(player);
			em.getTransaction().commit();
		}
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

	@Override
	public void updatePlayerDetails(PlayerEntity player) {
		// TODO Auto-generated method stub
		
	}

}
