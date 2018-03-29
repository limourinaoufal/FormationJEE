package metier;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dao.IDao;

//@Component("metier")
@Service("metier")
public class MetierImpl implements IMetier{

	@Autowired
	@Resource(name="dao2")
	private IDao dao;

	@Override
	public double calcul() {
		double temp = dao.getTemperature();
		double res=temp*12;
		return res;
	}

	public IDao getDao() {
		return dao;
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}

}
