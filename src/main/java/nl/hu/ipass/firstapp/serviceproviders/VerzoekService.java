package nl.hu.ipass.firstapp.serviceproviders;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import nl.hu.ipass.firstapp.model.Verzoek;
import nl.hu.ipass.firstapp.persistence.VerzoekDao;
import nl.hu.ipass.firstapp.persistence.VerzoekPostgresImpl;

public class VerzoekService {
	private VerzoekDao verzoekDao= new VerzoekPostgresImpl();
	
	public List<Verzoek> verzoekOphalen(int verzoek) throws ClassNotFoundException, SQLException, ParseException {
		
		return verzoekDao.verzoekOphalen(verzoek);
	}
	
	public List<Verzoek> verzoekenOphalen() throws ClassNotFoundException, SQLException, ParseException {
		return verzoekDao.verzoekenOphalen();
	}

	public Verzoek verzoekToevoegen(Verzoek verzoek) throws ClassNotFoundException, SQLException, ParseException {
		return verzoekDao.verzoekToevoegen(verzoek);
	}
	
	public boolean verzoekVerwijderen(int verzoek) throws ClassNotFoundException, SQLException, ParseException {
		return verzoekDao.verzoekVerwijderen(verzoek);
	}
	

}
