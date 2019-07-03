package nl.hu.ipass.firstapp.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import nl.hu.ipass.firstapp.model.Verzoek;

public class VerzoekPostgresImpl extends PostgresBaseDao implements VerzoekDao {

	@Override
	public List<Verzoek> verzoekOphalen(int verzoekId) throws SQLException, ClassNotFoundException, ParseException {
		List<Verzoek> verzoeken = new ArrayList<Verzoek>();

		String queryText = "select * from verzoek where verzoekId = ?";

		try (Connection conn = super.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(queryText);
			pstmt.setInt(1, verzoekId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("verzoekid");
				int sportId = rs.getInt("id_sport");
				String voorletter = rs.getString("voorletter");
				String tussenvoegsel = rs.getString("tussenvoegsel");
				String achternaam = rs.getString("achternaam");
				String gebruikersnaam = rs.getString("gebruikersnaam");
				String geslacht = rs.getString("geslacht");
				Date geboortedatum = rs.getDate("geboortedatum");
				int huisnummer = rs.getInt("huisnummer");
				String toevoeging = rs.getString("toevoeging");
				String straatnaam = rs.getString("straatnaam");
				String postcode = rs.getString("postcode");
				String plaats = rs.getString("plaats");
				int telefoonnum = rs.getInt("telefoonnummer");
				String email = rs.getString("email");
				Date van = rs.getDate("van");
				Date tot = rs.getDate("tot");
				String zelfbeschrijving = rs.getString("zelfbeschrijving");

				// nieuwe vezoek opject opvullen met de opgehaalde waardes
				Verzoek verzoek = new Verzoek(id, sportId, voorletter, tussenvoegsel, achternaam, gebruikersnaam,
						geslacht, geboortedatum, huisnummer, toevoeging, straatnaam, postcode, plaats, telefoonnum,
						email, van, tot, zelfbeschrijving);
				verzoeken.add(verzoek);
			}

			return verzoeken;
		} catch (SQLException e) {
			// om de sql exceptions te vangen
			System.out.print(e + "\n Er is mis gegaan.");
			return null;
		}
	}

	@Override
	public List<Verzoek> verzoekenOphalen() throws SQLException, ClassNotFoundException, ParseException {
		List<Verzoek> verzoeken = new ArrayList<Verzoek>();

		String queryText = "select * from verzoek order by verzoekid";

		try (Connection conn = super.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(queryText);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("verzoekid");
				int sportId = rs.getInt("id_sport");
				String voorletter = rs.getString("voorletter");
				String tussenvoegsel = rs.getString("tussenvoegsel");
				String achternaam = rs.getString("achternaam");
				String gebruikersnaam = rs.getString("gebruikersnaam");
				String geslacht = rs.getString("geslacht");
				Date geboortedatum = rs.getDate("geboortedatum");
				int huisnummer = rs.getInt("huisnummer");
				String toevoeging = rs.getString("toevoeging");
				String straatnaam = rs.getString("straatnaam");
				String postcode = rs.getString("postcode");
				String plaats = rs.getString("plaats");
				int telefoonnum = rs.getInt("telefoonnum");
				String email = rs.getString("email");
				Date van = rs.getDate("van");
				Date tot = rs.getDate("tot");
				String zelfbeschrijving = rs.getString("zelfbeschrijving");

				// nieuwe vezoek opject opvullen met de opgehaalde waardes
				Verzoek verzoek = new Verzoek(id, sportId, voorletter, tussenvoegsel, achternaam, gebruikersnaam,
						geslacht, geboortedatum, huisnummer, toevoeging, straatnaam, postcode, plaats, telefoonnum,
						email, van, tot, zelfbeschrijving);
				verzoeken.add(verzoek);

			}

			return verzoeken;

		} catch (SQLException e) {
			// om de sql exceptions te vangen
			System.out.print(e + "\n Er is mis gegaan.");
			return null;
		}
	}

	// functie die een object vangt, de data eruit haalt en in de database opslaat
	@Override
	public Verzoek verzoekToevoegen(Verzoek verzoek) throws SQLException, ClassNotFoundException {

		try (Connection conn = super.getConnection()) {
			// querytext om de data te kunnen opslaan in de database
			String queryText = "insert into verzoek (id_sport, voorletter, tussenvoegsel, achternaam, gebruikersnaam, geslacht, geboortedatum, huisnummer, toevoeging, straatnaam, postcode, plaats, telefoonnum, email, van, tot, zelfbeschrijving) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(queryText);

			// de waardes van de attributen opvullen
			pstmt.setInt(1, verzoek.getSportId());
			pstmt.setString(2, verzoek.getVoorletter());
			pstmt.setString(3, verzoek.getTussenvoegsel());
			pstmt.setString(4, verzoek.getAchternaam());
			pstmt.setString(5, verzoek.getGebruikersnaam());
			pstmt.setString(6, verzoek.getGeslacht());
			pstmt.setDate(7, (Date) verzoek.getGeboorte());
			pstmt.setInt(8, verzoek.getHuisnummer());
			pstmt.setString(9, verzoek.getToevoeging());
			pstmt.setString(10, verzoek.getStraatnaam());
			pstmt.setString(11, verzoek.getPostcode());
			pstmt.setString(12, verzoek.getPlaats());
			pstmt.setInt(13, verzoek.getTelefoonnummer());
			pstmt.setString(14, verzoek.getEmail());
			pstmt.setDate(15, (Date) verzoek.getVan());
			pstmt.setDate(16, (Date) verzoek.getTot());
			pstmt.setString(17, verzoek.getZelfbeschrijving());

			// query uitvoeren in postgres
			pstmt.executeUpdate();

			String sqlText = "SELECT LASTVAL();";
			PreparedStatement pS = conn.prepareStatement(sqlText);
			ResultSet rs = pS.executeQuery();
			rs.next();
			int huidigeId = rs.getInt("lastval");

			// laatste increment ophalen
			verzoek.setVerzoek(huidigeId);

			System.out.println("\nVerzoek nummer: " + verzoek.getVerzoek() + " is toegevoegd.");
			return verzoek;
		} catch (SQLException e) {
			System.out.println("\nVerzoek nummer: " + verzoek.getVerzoek() + " is niet toegevoegd.");
			return verzoek;
		}
	}

	@Override
	public boolean verzoekVerwijderen(int verzoek) throws SQLException, ClassNotFoundException {

		String queryText = "DELETE FROM verzoek WHERE verzoekId = ?";

		try (Connection conn = super.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(queryText);
			pstmt.setInt(1, verzoek);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("\nVerzoek: " + verzoek + " is niet verwijdered.");
			return false;
		}

		System.out.println("\nVerzoek: " + verzoek + " is verwijdered.");
		return true;
	}
}
