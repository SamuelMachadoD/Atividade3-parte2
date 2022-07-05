package Dao;

import javax.persistence.EntityManager;

import Modelo.Local;

public class LocalDAO {
	private EntityManager em;
	public LocalDAO(EntityManager em2) {
		this.em = em2;
	}
	public void cadastrar(Local local) {
		this.em.persist(local);
	}
	public Local pesquisar(Long id) {
			String jpql = "SELECT p FROM Local p WHERE p.id = :id";
			return this.em.createQuery(jpql, Local.class)
					.setParameter("id", id)
					.getSingleResult();
	}
	
}
