package nl.hu.ipass.firstapp.persistence;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import nl.hu.ipass.firstapp.model.Inschrijving;

public interface InschrijvingDao {
	
	Inschrijving inschrijvingToevoegen (Inschrijving inschrijving) throws SQLException, ClassNotFoundException ;
	
	List<Inschrijving> inschrijvingenOphalen(int insch_Id) throws SQLException, ClassNotFoundException, ParseException;
	
	Inschrijving inschrijvingWijzigen(Inschrijving inschrijving) throws ClassNotFoundException, SQLException, ParseException; 
	
	boolean inschrijvingVerwijderen(int id) throws ClassNotFoundException, SQLException, ParseException;
	
}
