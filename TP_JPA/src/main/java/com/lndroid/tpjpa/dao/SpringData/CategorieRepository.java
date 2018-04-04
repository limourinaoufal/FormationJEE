package com.lndroid.tpjpa.dao.SpringData;

import com.lndroid.tpjpa.entities.Categorie;
import com.lndroid.tpjpa.entities.Produit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
	
	@Query("Select p from Produit p where p.categorie like:c")
	public List<Produit> listProduitC (@Param("c") Categorie C);

}
