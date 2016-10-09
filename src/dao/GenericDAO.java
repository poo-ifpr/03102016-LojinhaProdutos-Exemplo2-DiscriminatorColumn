package dao;


import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import util.EntityManagerUtil;



public class GenericDAO<T> {
	
	private Class<T> type;
	
	public GenericDAO(Class<T> type) {
		this.type = type;
	}
	
	public void adicionar(T entidade) {
		EntityManager em = EntityManagerUtil.getEntityManager();

		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
	}
	
	public void alterar(T entidade) {
		EntityManager em = EntityManagerUtil.getEntityManager();

		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();		
	}
	
	public void remover(T entidade) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		
		em.getTransaction().begin();
		em.remove(entidade);
		em.getTransaction().commit(); 
	}

	public List<T> listar() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		 
		TypedQuery<T> query = em.createQuery("SELECT a FROM " + type.getName() + " a", type);

		return query.getResultList();
	}
	
	
	
	public T buscarPorId(Serializable id) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		
		T entidade = em.find(type, id);
		
		return entidade;
	}
	
	public List<T> buscarPorCriterio(String nomeCriterio, String valorCriterio) {
		
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<T> query = em.createQuery("select a from " + type.getName() + " a where " +
				"a." + nomeCriterio + " like :" + nomeCriterio , type);
		query.setParameter(nomeCriterio, "%" + valorCriterio + "%");
		
		return query.getResultList();
		
	}
}
