package br.com.ative.businessin.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.metamodel.EmbeddableType;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.ManagedType;
import javax.persistence.metamodel.Metamodel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("entityDAO")
public class EntityDAO implements IEntityDAO {

	@Autowired
//	private EntityManagerFactory emf;
//	private EntityManager em;
	private EntityJdbc jdbc;
	
	public void doSomething() {
//		Metamodel metamodel = emf.getMetamodel();
//		EntityManagerFactory emf = em.getEntityManagerFactory();
//		emf.getMetamodel().getEntities();
//		Connection
		jdbc.test();
	}
	
}
