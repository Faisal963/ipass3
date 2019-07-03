package nl.hu.ipass.firstapp.serviceproviders;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import nl.hu.ipass.firstapp.model.Persoon;
import nl.hu.ipass.firstapp.persistence.PersoonDao;
import nl.hu.ipass.firstapp.persistence.PersoonPostgresImpl;

public class PersoonService {
	private PersoonDao persoonDao = new PersoonPostgresImpl();

	public List<Persoon> personenOphalen(String gebruikersnm) throws ClassNotFoundException, SQLException, ParseException {
		return persoonDao.persoonOphalen(gebruikersnm);
	}

	public Persoon persoonToevoegen(Persoon p) throws ClassNotFoundException, SQLException, ParseException {
		return persoonDao.persoonToevoegen(p);
	}

	public Persoon inloggen(String gebruikersnm, String wchtwrd) throws ClassNotFoundException, SQLException, ParseException {
		return persoonDao.inloggen(gebruikersnm, wchtwrd);
	}
	
	public List<Persoon> ledenOphalen() throws ClassNotFoundException, SQLException, ParseException {
		return persoonDao.ledenOphalen();
	}
	
	public Persoon persoonWijzigen(Persoon p) throws ClassNotFoundException, SQLException, ParseException {
		return persoonDao.persoonWijzigen(p);
	}

	public boolean persoonVerwijderen(String gebruikersnaam) throws ClassNotFoundException, SQLException, ParseException {
		return persoonDao.persoonVerwijderen(gebruikersnaam);
	}

}

