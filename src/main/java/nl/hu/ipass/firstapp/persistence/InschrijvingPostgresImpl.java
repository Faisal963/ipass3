package nl.hu.ipass.firstapp.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

import nl.hu.ipass.firstapp.model.Inschrijving;

public class InschrijvingPostgresImpl extends PostgresBaseDao implements InschrijvingDao {

	@Override
	public Inschrijving inschrijvingToevoegen(Inschrijving inschrijving) throws SQLException, ClassNotFoundException {
		try (Connection conn = super.getConnection()){
			String query = "INSERT INTO inschrijving (van, tot, id, id_per,id_sport) VALUES (?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(3, inschrijving.getInschrijving());
			pstmt.setInt(4, inschrijving.getPersoonId());
			pstmt.setInt(5, inschrijving.getSportId());
			pstmt.setDate(1, new java.sql.Date(inschrijving.getVan().getTime()));
			pstmt.setDate(2, new java.sql.Date(inschrijving.getTot().getTime()));

			return inschrijving;
		} catch (SQLException e) {
			System.out.println("\nInschrijving nummer: " + inschrijving.getInschrijving() + " is niet geldig.");
			return inschrijving;
		}
	}

	@Override
	public List<Inschrijving> inschrijvingenOphalen(int id)
			throws SQLException, ClassNotFoundException, ParseException {
		List<Inschrijving> inschrijvingen = new ArrayList<Inschrijving>();

		try (Connection conn = super.getConnection()){
			String query = "SELECT * FROM inschrijving where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int insch = rs.getInt("id");
				int persoonId = rs.getInt("id_per");
				int sportId = rs.getInt("id_sport");
				Date van = rs.getDate("van");
				Date tot = rs.getDate("tot");

				Inschrijving inschrijving = new Inschrijving(insch, persoonId, sportId, van, tot);
				inschrijvingen.add(inschrijving);
			}

			return inschrijvingen;

		} catch (SQLException e) {
			System.out.println("\nInschrijving kan niet toegevoegd worden.");
			return null;
		}
	}

	@Override
	public Inschrijving inschrijvingWijzigen(Inschrijving inschrijving)
			throws ClassNotFoundException, SQLException, ParseException {
		try (Connection conn = super.getConnection()){
			String queryText = "UPDATE inschrijving SET van=?, tot=?  WHERE id=?";
			PreparedStatement pstmt = conn.prepareStatement(queryText);

			pstmt.setDate(1, new java.sql.Date(inschrijving.getVan().getTime()));
			pstmt.setDate(2, new java.sql.Date(inschrijving.getTot().getTime()));
			pstmt.setInt(3, inschrijving.getInschrijving());
			pstmt.executeUpdate();

			System.out.println("\nInschrijving nummer: " + inschrijving.getInschrijving() + " is gewijzigd.");
			return inschrijving;
		} catch (SQLException e) {
			System.out.println("\nInschrijving nummer: " + inschrijving.getInschrijving() + " is niet gewijzigd.");
			inschrijving.setInschrijving(0);
			return inschrijving;
		}
	}

	@Override
	public boolean inschrijvingVerwijderen(int inschrijving)
			throws ClassNotFoundException, SQLException, ParseException {
		try (Connection conn = super.getConnection()){
			String queryText = "DELETE FROM inschrijving WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(queryText);
			pstmt.setInt(1, inschrijving);
			pstmt.executeUpdate();

			System.out.println("\nInschrijving: " + inschrijving + " is verwijdered.");
			return true;
		} catch (SQLException e) {
			System.out.println("\nInschrijving: " + inschrijving + " is niet verwijdered.");
			return false;
		}
	}
}
