package userservletm17.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import userservletm17.dto.User;

public class UserDao {

	
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
	
	
	public void saveUser(User user) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.persist(user);
	
		entityTransaction.commit();
		
	}



	public User findUserByEmail(String email) {
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("Select u from User u where u.email=?1");
		query.setParameter(1, email);
		
		User dbUser=(User) query.getSingleResult();
		return dbUser;
	}



	public List<User> findAllUser() {
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("Select u from User u");
		return query.getResultList();
	}
	
	
	
	
	
	
	
	
	
	
	
}
