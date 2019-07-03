package nl.hu.ipass.firstapp.persistence;

import java.sql.*;
import java.text.ParseException;
import java.util.*;
import java.sql.Date;

import nl.hu.ipass.firstapp.model.GenereerWachtwoord;
import nl.hu.ipass.firstapp.model.Persoon;

public class PersoonPostgresImpl extends PostgresBaseDao implements PersoonDao {

	@Override
	public List<Persoon> persoonOphalen(String gbnm) throws SQLException, ClassNotFoundException, ParseException {

		List<Persoon> personen = new ArrayList<Persoon>();

		try (Connection conn = super.getConnection()) {

			String queryText = "select * from persoon where gebruikersnaam = ?";
			PreparedStatement pstmt = conn.prepareStatement(queryText);
			pstmt.setString(1, gbnm);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String voorletter = rs.getString("voorletter");
				String tussenvoegsel = rs.getString("tussenvoegsel");
				String achternaam = rs.getString("achternaam");
				String rol = rs.getString("rol");
				String gebruikersnaam = rs.getString("gebruikersnaam");
				String wachtwoord = rs.getString("wachtwoord");
				String geslacht = rs.getString("geslacht");
				Date geboortedatum = rs.getDate("geboortedatum");
				int huisnummer = rs.getInt("huisnummer");
				String toevoeging = rs.getString("toevoeging");
				String straatnaam = rs.getString("straatnaam");
				String postcode = rs.getString("postcode");
				String plaats = rs.getString("plaats");
				int telefoonnum = rs.getInt("telefoonnum");
				String email = rs.getString("email");

				Persoon persoon = new Persoon(id, voorletter, tussenvoegsel, achternaam, rol, gebruikersnaam,
						wachtwoord, geslacht, geboortedatum, huisnummer, toevoeging, straatnaam, postcode, plaats,
						telefoonnum, email);
				personen.add(persoon);
			}

			return personen;
		} catch (SQLException e) {
			System.out.print(e + "\n Er is mis gegaan.");
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public Persoon inloggen(String username, String passwoord)
			throws SQLException, ClassNotFoundException, ParseException {

		Persoon persoon = new Persoon(0, passwoord, passwoord, passwoord, passwoord, passwoord, passwoord, passwoord,
				new Date(1, 1, 2009), 0, passwoord, passwoord, passwoord, passwoord, 0, passwoord);

		try (Connection conn = super.getConnection()) {

			String queryText = "select * from persoon where gebruikersnaam = ?";
			PreparedStatement pstmt = conn.prepareStatement(queryText);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				if (passwoord.equals(rs.getString("wachtwoord"))) {
					int id = rs.getInt("id");
					String voorletter = rs.getString("voorletter");
					String tussenvoegsel = rs.getString("tussenvoegsel");
					String achternaam = rs.getString("achternaam");
					String rol = rs.getString("rol");
					String gebruikersnaam = rs.getString("gebruikersnaam");
					String wachtwoord = rs.getString("wachtwoord");
					String geslacht = rs.getString("geslacht");
					Date geboortedatum = rs.getDate("geboortedatum");
					int huisnummer = rs.getInt("huisnummer");
					String toevoeging = rs.getString("toevoeging");
					String straatnaam = rs.getString("straatnaam");
					String postcode = rs.getString("postcode");
					String plaats = rs.getString("plaats");
					int telefoonnum = rs.getInt("telefoonnum");
					String email = rs.getString("email");

					persoon = new Persoon(id, voorletter, tussenvoegsel, achternaam, rol, gebruikersnaam, wachtwoord,
							geslacht, geboortedatum, huisnummer, toevoeging, straatnaam, postcode, plaats, telefoonnum,
							email);

					System.out.print("\n" + persoon.getGebruikersnaam() + " is ingelogd.");
				} else {
					System.out.print("\n Wachtwoord is fout.");
					persoon = new Persoon(0, "", "", "", "", "", "fout", "", new Date(1, 1, 2009), 0, "", "", "", "", 0,
							"");
				}
			}

			return persoon;
		} catch (SQLException e) {
			System.out.print(e + "\n Gebruikersnaam is fout.");
			return persoon;
		}
	}

	@Override
	public List<Persoon> ledenOphalen() throws SQLException, ClassNotFoundException, ParseException {
		List<Persoon> personen = new ArrayList<Persoon>();

		String queryText = "select * from persoon where rol = 'lid';";

		try (Connection conn = super.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(queryText);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("id");
				String voorletter = rs.getString("voorletter");
				String tussenvoegsel = rs.getString("tussenvoegsel");
				String achternaam = rs.getString("achternaam");
				String rol = rs.getString("rol");
				String gebruikersnaam = rs.getString("gebruikersnaam");
				String wachtwoord = rs.getString("wachtwoord");
				String geslacht = rs.getString("geslacht");
				Date geboortedatum = rs.getDate("geboortedatum");
				int huisnummer = rs.getInt("huisnummer");
				String toevoeging = rs.getString("toevoeging");
				String straatnaam = rs.getString("straatnaam");
				String postcode = rs.getString("postcode");
				String plaats = rs.getString("plaats");
				int telefoonnummer = rs.getInt("telefoonnum");
				String email = rs.getString("email");

				Persoon persoon = new Persoon(id, voorletter, tussenvoegsel, achternaam, rol, gebruikersnaam,
						wachtwoord, geslacht, geboortedatum, huisnummer, toevoeging, straatnaam, postcode, plaats,
						telefoonnummer, email);
				personen.add(persoon);
			}

		} catch (SQLException e) {
			// om de sql exceptions te vangen
			System.out.print(e + "\n Er is mis gegaan.");
			return null;
		}
		return personen;
	}

	// functie die een object vangt, de data eruit haalt en in de database opslaat
	@Override
	public Persoon persoonToevoegen(Persoon persoon) throws SQLException, ClassNotFoundException {

		try (Connection conn = super.getConnection()) {
			String queryText = "insert into persoon ( voorletter, tussenvoegsel, achternaam, gebruikersnaam, wachtwoord, rol, geslacht, geboortedatum, huisnummer, toevoeging,Straatnaam, postcode, plaats, telefoonnum, email) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(queryText);

			pstmt.setString(1, persoon.getVoorletter());
			pstmt.setString(2, persoon.getTussenvoegsel());
			pstmt.setString(3, persoon.getAchternaam());
			pstmt.setString(4, persoon.getGebruikersnaam());
			pstmt.setString(5, GenereerWachtwoord.genereerWachtwoord(8));
			pstmt.setString(6, persoon.getRol());
			pstmt.setString(7, persoon.getGeslacht());
			pstmt.setDate(8, (Date) persoon.getGeboorte());
			pstmt.setInt(9, persoon.getHuisnummer());
			pstmt.setString(10, persoon.getToevoeging());
			pstmt.setString(11, persoon.getStraatnaam());
			pstmt.setString(12, persoon.getPostcode());
			pstmt.setString(13, persoon.getPlaats());
			pstmt.setInt(14, persoon.getTelefoonnummer());
			pstmt.setString(15, persoon.getEmail());

			pstmt.executeUpdate();

			System.out.println("\nPersoon naam: " + persoon.getVoorletter() + " " + persoon.getTussenvoegsel() + " "
					+ persoon.getAchternaam() + " is toegevoegd.");
			return persoon;
		} catch (SQLException e) {
			System.out.println("\nPersoon naam: " + persoon.getVoorletter() + " " + persoon.getTussenvoegsel() + " "
					+ persoon.getAchternaam() + " is niet juist.");
			persoon.setGebruikersnaam("ongeldig");
			return persoon;
		}
	}

	@Override
	public Persoon persoonWijzigen(Persoon persoon) throws SQLException, ClassNotFoundException {

		String queryText = "UPDATE persoon SET voorletter=?, tussenvoegsel=?, achternaam=?, wachtwoord=?, geslacht=?, geboortedatum=?, telefoonnum=?, email=?, straatnaam=?, huisnummer=?, toevoeging=?, postcode=?, plaats=?  WHERE gebruikersnaam=?";

		try (Connection conn = super.getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(queryText);
			pstmt.setString(1, persoon.getVoorletter());
			pstmt.setString(2, persoon.getTussenvoegsel());
			pstmt.setString(3, persoon.getAchternaam());
			pstmt.setString(4, persoon.getWachtwoord());
			pstmt.setString(5, persoon.getGeslacht());
			pstmt.setDate(6, (Date) persoon.getGeboorte());
			pstmt.setInt(7, persoon.getTelefoonnummer());
			pstmt.setString(8, persoon.getEmail());
			pstmt.setString(9, persoon.getStraatnaam());
			pstmt.setInt(10, persoon.getHuisnummer());
			pstmt.setString(11, persoon.getToevoeging());
			pstmt.setString(12, persoon.getPostcode());
			pstmt.setString(13, persoon.getPlaats());
			pstmt.setString(14, persoon.getGebruikersnaam());

			pstmt.executeUpdate();

			System.out.println("\nPersoon naam: " + persoon.getGebruikersnaam() + " is gewijzigd.");
			return persoon;
		} catch (SQLException e) {
			System.out.println("\nPersoon naam: " + persoon.getGebruikersnaam() + " is niet gewijzigd.");
			persoon.setGebruikersnaam("ongeldig");
			return persoon;
		}
	}

	@Override
	public boolean persoonVerwijderen(String gebruikersnaam) throws SQLException, ClassNotFoundException {

		try (Connection conn = super.getConnection()){
			String queryText = "DELETE FROM persoon WHERE gebruikersnaam = ?";
			PreparedStatement pstmt = conn.prepareStatement(queryText);
			pstmt.setString(1, gebruikersnaam);
			pstmt.executeUpdate();
			System.out.println("\nPersoon: " + gebruikersnaam + " is verwijdered.");
			return true;
		} catch (SQLException e) {
			System.out.println("\nPersoon: " + gebruikersnaam + " is niet verwijdered.");
			return false;
		}
	}
}
