package com.fortech.stm.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.fortech.stm.controller.SportsTeamAuthentificationController;

@Stateless
public class JPAUtility {
	  @PersistenceContext(unitName = "stmPersistence")
	  private EntityManager em;
	  
	  final static Logger logger = Logger.getLogger(JPAUtility.class);
	  
  
	  
	  public static EntityManager getEntityManager() {
		  logger.info("Time before obtaining the entity manager: "+ System.currentTimeMillis());
	      EntityManagerFactory emf = Persistence.createEntityManagerFactory("stmPersistence");
	      EntityManager ecm = emf.createEntityManager(); 
	      logger.info("Time after obtaining the entity manager: "+ System.currentTimeMillis());
	      return ecm;
	  }
} 