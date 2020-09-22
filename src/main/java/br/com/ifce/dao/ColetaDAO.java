package br.com.ifce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ifce.model.Coleta;

public class ColetaDAO {

	private static ColetaDAO instance;
	private EntityManager entityManager;

	public static ColetaDAO getInstance() {
		if (instance == null) {
			instance = new ColetaDAO();
		}
		return instance;
	}

	public ColetaDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
		if (entityManager == null) {
			entityManager = emf.createEntityManager();
		}
		return entityManager;
	}

	public Coleta getById(final Long id) {
		return entityManager.find(Coleta.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Coleta> findAll() {
		return entityManager.createQuery("FROM " + Coleta.class.getSimpleName()).getResultList();
	}

	public void persist(Coleta coleta) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(coleta);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(Coleta coleta) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(coleta);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Coleta coleta) {
		try {
			entityManager.getTransaction().begin();
			coleta = entityManager.find(Coleta.class, coleta.getId());
			entityManager.remove(coleta);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final Long id) {
		try {
			Coleta coleta = this.getById(id);
			this.remove(coleta);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
