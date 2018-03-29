package presentation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import metier.IMetier;


public class PresentationSpringAnnotations {
	
	public static void main(String[] args) {
		ApplicationContext springContext = 
				new AnnotationConfigApplicationContext("dao","metier");
		
		
		IMetier metier = (IMetier) springContext.getBean(IMetier.class);
//		IMetier metier = (IMetier) springContext.getBean("metier");
		
		System.out.println(metier.calcul());
	}

}
