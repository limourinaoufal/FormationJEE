package dao;

import org.springframework.stereotype.Component;

@Component("dao2")
public class DaoImplV2 implements IDao{

	@Override
	public double getTemperature() {
		/*
		 * Dans cette version, je me connecte a un web service pour 
		 * récuperer la température
		 */
		double data = 32;
		return data;
	}

}
