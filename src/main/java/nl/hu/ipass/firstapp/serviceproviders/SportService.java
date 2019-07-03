package nl.hu.ipass.firstapp.serviceproviders;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import nl.hu.ipass.firstapp.model.Sport;
import nl.hu.ipass.firstapp.persistence.SportDao;
import nl.hu.ipass.firstapp.persistence.SportPostgresImpl;

public class SportService {
	private SportDao sportDao = new SportPostgresImpl();

	public Sport sportToevoegen(Sport sport) throws ClassNotFoundException, SQLException, ParseException {
			return sportDao.sportToevoegen(sport);
	}

	public Sport sportWijzigen(Sport sport) throws ClassNotFoundException, SQLException, ParseException {
		return sportDao.sportWijzigen(sport);
	}
	
	public boolean sportVerwijderen(String naam) throws ClassNotFoundException, SQLException, ParseException {
		return sportDao.sportVerwijderen(naam);
	}
	public List<Sport> sportenOphalen(String naam) throws ClassNotFoundException, SQLException, ParseException {
		return sportDao.sportenOphalen(naam);
	}

}
