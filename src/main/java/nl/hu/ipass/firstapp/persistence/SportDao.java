package nl.hu.ipass.firstapp.persistence;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import nl.hu.ipass.firstapp.model.Sport;

public interface SportDao {

	Sport sportToevoegen(Sport sport) throws SQLException, ClassNotFoundException;

	Sport sportWijzigen(Sport sport) throws ClassNotFoundException, SQLException, ParseException;

	boolean sportVerwijderen(String naam) throws ClassNotFoundException, SQLException, ParseException;

	List<Sport> sportenOphalen(String naam) throws SQLException, ClassNotFoundException, ParseException;


}
