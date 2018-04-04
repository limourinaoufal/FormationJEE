package com.lndroid.tpjpa.dao.SpringData;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lndroid.tpjpa.entities.Categorie;
import com.lndroid.tpjpa.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	
	@Query("Select p from Produit p where p.designation like:x")
		public List<Produit> produitByMotCle(@Param("x") String mc);
	
	


}
