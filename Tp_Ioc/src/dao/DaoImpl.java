package dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component("dao")
@Repository("dao")
public class DaoImpl implements IDao{

	@Override
	public double getTemperature() {
		/*
		 * Se connecter à la base de donnée pour récupérer la temperature
		 */
		double data = 24;
		return data;
	}

}
