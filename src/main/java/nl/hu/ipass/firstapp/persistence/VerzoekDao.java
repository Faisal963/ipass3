package nl.hu.ipass.firstapp.persistence;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import nl.hu.ipass.firstapp.model.Verzoek;

public interface VerzoekDao {
	
	List<Verzoek> verzoekOphalen(int verzoek) throws SQLException, ClassNotFoundException, ParseException;
	
	List<Verzoek> verzoekenOphalen() throws SQLException, ClassNotFoundException, ParseException;
	
	Verzoek verzoekToevoegen(Verzoek verzoek) throws SQLException, ClassNotFoundException, ParseException;
	
	boolean verzoekVerwijderen(int verzoek) throws SQLException, ClassNotFoundException, ParseException;
}
