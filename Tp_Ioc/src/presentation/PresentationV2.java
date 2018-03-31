package presentation;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

import dao.IDao;
import metier.IMetier;
//import metier.MetierImpl;

public class PresentationV2 {

	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(new File("config.txt"));
			
			String daoClassName = scanner.nextLine();
			//System.out.println(daoClassName);
				Class<?> cDao = Class.forName(daoClassName);
					IDao dao = (IDao) cDao.newInstance();
						//*System.out.println(dao.getTemperature());
			
			String metierClassName = scanner.nextLine();
				Class<?> cMetier = Class.forName(metierClassName);
					IMetier metier = (IMetier) cMetier.newInstance();
					
			Method m = cMetier.getMethod("setDao", new Class[] {IDao.class});	
				m.invoke(metier, dao);
					
			System.out.println(metier.calcul());
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
