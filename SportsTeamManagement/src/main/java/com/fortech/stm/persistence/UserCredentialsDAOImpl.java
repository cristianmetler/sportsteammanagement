package com.fortech.stm.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("uc")
@Transactional(propagation = Propagation.REQUIRED)

public class UserCredentialsDAOImpl implements UserCredentialsDAO {

	@Override
	public void save(UserCredentials userCredentials){
		EntityManager em = JPAUtility.getEntityManager();
		em.getTransaction().begin();
      em.persist(userCredentials);
      em.getTransaction().commit();
	}
	@Override
	public UserCredentials findUser(String username) {
		UserCredentials uc = null;
		  Query q1 =  JPAUtility.getEntityManager().createQuery("SELECT c FROM UserCredentials c where c.username= :username").setParameter("username", username);
		try {
		   uc = (UserCredentials) q1.getSingleResult();
		} catch (NoResultException nre) {
			//do nothing, no result is okay.
		}  
		   return uc;
	 }
	
}
