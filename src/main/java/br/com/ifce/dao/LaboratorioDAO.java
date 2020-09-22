package br.com.ifce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ifce.model.Laboratorio;

public class LaboratorioDAO {

	private static LaboratorioDAO instance;
	private EntityManager entityManager;

	public static LaboratorioDAO getInstance() {
		if (instance == null) {
			instance = new LaboratorioDAO();
		}
		return instance;
	}

	public LaboratorioDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
		if (entityManager == null) {
			entityManager = emf.createEntityManager();
		}
		return entityManager;
	}

	public Laboratorio getById(final Long id) {
		return entityManager.find(Laboratorio.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Laboratorio> findAll() {
		return entityManager.createQuery("FROM " + Laboratorio.class.getSimpleName()).getResultList();
	}

	public void persist(Laboratorio laboratorio) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(laboratorio);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(Laboratorio laboratorio) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(laboratorio);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Laboratorio laboratorio) {
		try {
			entityManager.getTransaction().begin();
			laboratorio = entityManager.find(Laboratorio.class, laboratorio.getId());
			entityManager.remove(laboratorio);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final Long id) {
		try {
			Laboratorio laboratorio = this.getById(id);
			this.remove(laboratorio);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
