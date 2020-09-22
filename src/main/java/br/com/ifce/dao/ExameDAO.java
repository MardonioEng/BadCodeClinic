package br.com.ifce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ifce.model.Exame;

public class ExameDAO {

	private static ExameDAO instance;
	private EntityManager entityManager;

	public static ExameDAO getInstance() {
		if (instance == null) {
			instance = new ExameDAO();
		}
		return instance;
	}

	public ExameDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
		if (entityManager == null) {
			entityManager = emf.createEntityManager();
		}
		return entityManager;
	}

	public Exame getById(final Long id) {
		return entityManager.find(Exame.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Exame> findAll() {
		return entityManager.createQuery("FROM " + Exame.class.getSimpleName()).getResultList();
	}

	public void persist(Exame exame) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(exame);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(Exame exame) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(exame);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Exame exame) {
		try {
			entityManager.getTransaction().begin();
			exame = entityManager.find(Exame.class, exame.getId());
			entityManager.remove(exame);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final Long id) {
		try {
			Exame exame = this.getById(id);
			this.remove(exame);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
