package com.lndroid.tpjpa.dao.EntityManager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lndroid.tpjpa.entities.Produit;

@Repository
@Transactional
public class ProduitDaoImpl implements EntityRepository<Produit>{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Produit save(Produit t) {
		em.persist(t);
		return null;
	}

	@Override
	public List<Produit> findAll() {
		Query req = em.createQuery("select p from Produit p");
		return req.getResultList();
	}

	@Override
	public List<Produit> findByDesignation(String mc) {
		Query req = em.createQuery("select p from Produit p where p.designation like :x");
			req.setParameter("x", mc);
		return req.getResultList();
	}

	@Override
	public Produit findOne(Long id) {
		Produit p = em.find(Produit.class, id);
		return p;
	}

	@Override
	public Produit update(Produit t) {
		em.merge(t);
		return t;
	}

	@Override
	public void delete(Long id) {
		Produit p = em.find(Produit.class, id);
		em.remove(p);
	}

}
