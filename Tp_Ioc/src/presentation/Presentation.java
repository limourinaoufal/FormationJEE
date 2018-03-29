package presentation;

import dao.DaoImpl;
import metier.MetierImpl;

public class Presentation {

	public static void main(String[] args) {
		/*
		 * Injection des dépendances par instanciation statique => Couplage Fort 
		 *    % Application non fermer a la modification :( %
		 */
		DaoImpl dao = new DaoImpl();
		MetierImpl metier = new MetierImpl();
		metier.setDao(dao);
		
		System.out.println(metier.calcul());

	}

}
