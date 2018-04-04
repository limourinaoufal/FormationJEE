package com.lndroid.tpjpa.dao.EntityManager;

import java.util.List;

public interface EntityRepository<Type> {
	
	public Type save (Type t);
	public List<Type> findAll();
	public List<Type> findByDesignation(String mc);
	public Type findOne(Long id);
	public Type update(Type t);
	public void delete (Long id);
	

}
