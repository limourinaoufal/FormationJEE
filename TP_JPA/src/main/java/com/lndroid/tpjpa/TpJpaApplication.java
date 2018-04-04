package com.lndroid.tpjpa;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.w3c.dom.ls.LSInput;

import com.lndroid.tpjpa.dao.EntityManager.EntityRepository;
import com.lndroid.tpjpa.dao.SpringData.CategorieRepository;
import com.lndroid.tpjpa.dao.SpringData.ProduitRepository;
import com.lndroid.tpjpa.entities.Categorie;
import com.lndroid.tpjpa.entities.Produit;

@SpringBootApplication
public class TpJpaApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(TpJpaApplication.class, args);
		EntityRepository<Produit> produitDaoEm = ctx.getBean(EntityRepository.class);
		
		/*
		 * Create 3 product with the EntityManager
		 */		
			produitDaoEm.save(new Produit("P1Em", 1000, 1));
			produitDaoEm.save(new Produit("P2Em", 3000, 2));
			produitDaoEm.save(new Produit("P3Em", 3000, 3));

		/*
		 * Create 3 new Product with the Spring Data
		 */
			ProduitRepository produitRepository = ctx.getBean(ProduitRepository.class);
			produitRepository.save(new Produit("P1Sd", 1000, 1));
			produitRepository.save(new Produit("P2Sd", 2000, 2));
			produitRepository.save(new Produit("P3Sd", 3000, 3));

		/*
		 * View All The Product with the Entity Manager
		 */
			System.out.println("=> List All Produits EM: With Entity Manager");
			List<Produit> lpEm = produitDaoEm.findAll();
			lpEm.forEach(System.out::println);

		/*
		 * View All Product with Spring Data
		 */
			System.out.println("=>List All Produits EM et SD: With Spring Data");
			List<Produit> lpSd = produitRepository.findAll();
			lpSd.forEach(System.out::println);

		/*
		 * View All Product With de designation equald %EM% : EntityManager
		 */
			System.out.println("\n-> List All Produits %EM% : with Entity Manager");
			List<Produit> lpEmByMc = produitDaoEm.findByDesignation("%EM%");
			lpEmByMc.forEach(System.out::println);

		/*
		 * View All Product With the desigantiion equals %SD% : With Spring Data
		 */
			System.out.println("\n -> List All Produits %SD% : with Spring Data");
			List<Produit> lpSdByMc = produitRepository.produitByMotCle("%SD%");
			lpSdByMc.forEach(System.out::println);
			
		/*
		 * Create Two New Categorie With Spring Data
		 */	
			CategorieRepository categorieRepository = ctx.getBean(CategorieRepository.class);
			Categorie cEm = categorieRepository.save(new Categorie("CatEm"));
			Categorie cSd =categorieRepository.save(new Categorie("CatSd"));
		
		/*
		 * Add Categoriue to All EM products + Update with Entity Manager
		 */
			List<Produit> lpEmAll = produitDaoEm.findByDesignation("%EM%");
			for(Produit p:lpEmAll) {
				p.setCategorie(cEm);
				produitDaoEm.update(p);
			}
		
		/*
		 * Add Categoriue to All SD products + Update with Spring Data
		 */
			List<Produit> lpSdAll = produitRepository.produitByMotCle("%SD%");
			for(Produit p:lpSdAll) {
				p.setCategorie(cSd);
				produitRepository.save(p);
			}

		/*
		 * Return the categorie of the Product with the id = 4
		 */
			System.out.println("\n => Return Category of the Product id = 4");
			Produit pp1 = produitDaoEm.findOne(Long.parseLong("4"));
			Categorie cc = pp1.getCategorie();
			System.out.println("\t"+cc.toString());
		
		/*
		 * Return All the product contains in the categorie SD ( ID 2 )
		 */
			System.out.println("\n => Return All Product of the Category SD : Id 2");
			List<Produit> lppC = (List<Produit>) categorieRepository.listProduitC(cc);
			for(Produit p:lppC) {
				System.out.println(p.toString());
			}

	}
}
