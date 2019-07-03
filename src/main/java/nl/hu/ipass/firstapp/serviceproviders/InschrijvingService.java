package nl.hu.ipass.firstapp.serviceproviders;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import nl.hu.ipass.firstapp.model.Inschrijving;
import nl.hu.ipass.firstapp.persistence.InschrijvingDao;
import nl.hu.ipass.firstapp.persistence.InschrijvingPostgresImpl;

public class InschrijvingService {
	private InschrijvingDao inschrijvingDao = new InschrijvingPostgresImpl();
	
	public List<Inschrijving> inschrijvingenOphalen(int insch_Id) throws SQLException, ClassNotFoundException, ParseException {
		return inschrijvingDao.inschrijvingenOphalen(insch_Id);
	}
	
	public Inschrijving inschrijvingToevoegen(Inschrijving inschrijving) throws SQLException, ClassNotFoundException, ParseException{
		return inschrijvingDao.inschrijvingToevoegen(inschrijving);
	}
	
	public Inschrijving inschrijvingWijzigen(Inschrijving i) throws ClassNotFoundException, SQLException, ParseException {
		return inschrijvingDao.inschrijvingWijzigen(i);
	}
	public boolean inschrijvingVerwijderen(int inschrijving) throws ClassNotFoundException, SQLException, ParseException {
		return inschrijvingDao.inschrijvingVerwijderen(inschrijving);
	}
}
