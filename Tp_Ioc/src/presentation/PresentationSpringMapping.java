package presentation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import metier.IMetier;

public class PresentationSpringMapping {
	
	public static void main(String[] args) {
		ApplicationContext springContext = 
				new ClassPathXmlApplicationContext("config.xml");
		
		IMetier metier = (IMetier) springContext.getBean("metier");
		
		System.out.println(metier.calcul());
		
	}

}
