package com.fortech.stm.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Stateless
public class JPAUtility {
	  @PersistenceContext(unitName = "stmPersistence")
	  private EntityManager em;
	  
	  static {
		  
	  }
	  
	  public static EntityManager getEntityManager() {
	      EntityManagerFactory emf = Persistence.createEntityManagerFactory("stmPersistence");
	      EntityManager ecm = emf.createEntityManager(); 
	      return ecm;
	  }
} 