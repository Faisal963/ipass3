package nl.hu.ipass.firstapp.persistence;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import nl.hu.ipass.firstapp.model.Persoon;

public interface PersoonDao {
	Persoon inloggen(String gebruikersnm, String wchtwrd) throws SQLException, ClassNotFoundException, ParseException;
	
	List<Persoon> ledenOphalen() throws SQLException, ClassNotFoundException, ParseException;
	
	List<Persoon> persoonOphalen(String gebruikersNaam)  throws SQLException, ClassNotFoundException, ParseException;

	Persoon persoonToevoegen(Persoon persoon)  throws SQLException, ClassNotFoundException, ParseException;

	Persoon persoonWijzigen(Persoon persoon)  throws SQLException, ClassNotFoundException, ParseException;

	boolean persoonVerwijderen(String gebruikersNaam)  throws SQLException, ClassNotFoundException, ParseException;
}