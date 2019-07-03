package nl.hu.ipass.firstapp.persistence;

import java.util.*;

import nl.hu.ipass.firstapp.model.Sport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class SportPostgresImpl extends PostgresBaseDao implements SportDao {

	@Override
	public Sport sportToevoegen(Sport sport) throws SQLException, ClassNotFoundException {

		try (Connection conn = super.getConnection()) {
			String query = "INSERT INTO sport (id, naam) VALUES (?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sport.getNaam());
			pstmt.setInt(2, sport.getId());
			return sport;
		} catch (SQLException e) {
			System.out.println("\nSport ten naam: " + sport.getNaam() + " is niet geldig.");
			return sport;
		}
	}

	@Override
	public List<Sport> sportenOphalen(String naam) throws SQLException, ClassNotFoundException, ParseException {
		List<Sport> sporten = new ArrayList<Sport>();

		try (Connection conn = super.getConnection()) {
			String query = "SELECT * FROM sport where naam = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, naam);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String naam2 = rs.getString("naam");
				int id2 = rs.getInt("id");

				Sport sport = new Sport(naam2, id2);
				sporten.add(sport);
			}

			return sporten;

		} catch (SQLException e) {
			System.out.println("\nSport kan niet toegevoegd worden.");
			return null;
		}
	}

	@Override
	public Sport sportWijzigen(Sport sport) throws ClassNotFoundException, SQLException, ParseException {
		try (Connection conn = super.getConnection()) {
			String queryText = "UPDATE sport SET naam=?  WHERE naam=?";
			PreparedStatement pstmt = conn.prepareStatement(queryText);

			pstmt.setString(1, sport.getNaam());

			pstmt.executeUpdate();

			System.out.println("\nSport nummer: " + sport.getId() + " is gewijzigd.");
			return sport;
		} catch (SQLException e) {
			System.out.println("\n" + sport.getNaam() + " is niet gewijzigd.");
			sport.setNaam("niet geldig");
			return sport;
		}
	}

	@Override
	public boolean sportVerwijderen(String naam) throws ClassNotFoundException, SQLException, ParseException {
		try (Connection conn = super.getConnection()) {
			String queryText = "DELETE FROM sport WHERE naam = ?";
			PreparedStatement pstmt = conn.prepareStatement(queryText);
			pstmt.setString(1, naam);
			pstmt.executeUpdate();

			System.out.println("\n " + naam + " is verwijdered.");
			return true;
		} catch (SQLException e) {
			System.out.println("\n " + naam + " is niet verwijdered.");
			return false;
		}
	}
}