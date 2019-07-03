package nl.hu.ipass.firstapp.webservices;

import java.sql.SQLException;
import java.text.ParseException;
import java.sql.Date;
import java.util.*;
import javax.json.*;
import javax.ws.rs.*;

import nl.hu.ipass.firstapp.model.GenereerWachtwoord;
import nl.hu.ipass.firstapp.model.Persoon;
import nl.hu.ipass.firstapp.serviceproviders.PersoonService;

@Path("/persoon")
public class PersoonResource {
	private Persoon persoon;
	
	//deze functie haalt informatie op basis van gebruikersnaam
	@GET 
	@Path("/ophalen/{gebruikersnaam}") // de URL pad aangeven
	@Produces("application/json") // annotatie om de data type aan te geven
	public String personenOphalen(@PathParam("gebruikersnaam") String gebruikersnaam)
			throws SQLException, ClassNotFoundException, ParseException {
		List<Persoon> personen = new ArrayList<Persoon>();
		
		PersoonService persoonService = new PersoonService();
		personen = persoonService.personenOphalen(gebruikersnaam);
		JsonObjectBuilder job = Json.createObjectBuilder();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Persoon p : personen) {

			job.add("voorletter", p.getVoorletter());
			job.add("tussenvoegsel", p.getTussenvoegsel());
			job.add("achternaam", p.getAchternaam());
			job.add("rol", p.getRol());
			job.add("gebruikersnaam", p.getGebruikersnaam());
			job.add("wachtwoord", p.getWachtwoord());
			job.add("geslacht", p.getGeslacht());
			job.add("geboorte", p.getGeboorte().toString());
			job.add("huisnummer", p.getHuisnummer());
			job.add("toevoeging", p.getToevoeging());
			job.add("straatnaam", p.getStraatnaam());
			job.add("postcode", p.getPostcode());
			job.add("plaats", p.getPlaats());
			job.add("telefoonnummer", p.getTelefoonnummer());
			job.add("email", p.getEmail());
			jab.add(job);
		}
		JsonArray array =jab.build();
		return array.toString();
	}

	
	@POST
	@Path("/toevoegen") // de URL pad aangeven
	@Produces("application/json") // annotatie om de data type aan te geven
	public String persoonToevoegen(
			@FormParam("voorletter")String voorletter,
			@FormParam("tussenvoegsel") String tussenvoegsel,
			@FormParam("achternaam") String achternaam,	
			@FormParam("rol") String rol,
			@FormParam("gebruikersnaam") String gebruikersnaam,
			@FormParam("wachtwoord") String wachtwoord,
			@FormParam("geslacht") String geslacht,
			@FormParam("geboortedatum") Date geboorte, 
			@FormParam("huisnummer") int huisnummer,
			@FormParam("toevoeging") String toevoeging,
			@FormParam("straatnaam") String straatnaam,
			@FormParam("postcode") String postcode, 
			@FormParam("plaats") String plaats,
			@FormParam("telefoonnummer") int telefoonnummer,
			@FormParam("email") String email)

			throws SQLException, ClassNotFoundException, ParseException {
		
		if (wachtwoord == null) {
			wachtwoord  = GenereerWachtwoord.genereerWachtwoord(8);
		}
		persoon = new Persoon(0, voorletter, tussenvoegsel, achternaam, rol, gebruikersnaam, wachtwoord, geslacht,
				geboorte, huisnummer,toevoeging, straatnaam, postcode, plaats, telefoonnummer, email);

		PersoonService persoonService = new PersoonService();
		persoon = persoonService.persoonToevoegen(persoon);

		JsonObjectBuilder job = Json.createObjectBuilder();
		
		job.add("voorletter", persoon.getVoorletter());
		job.add("tussenvoegsel", persoon.getTussenvoegsel());
		job.add("achternaam", persoon.getAchternaam());
		job.add("rol", persoon.getRol());
		job.add("gebruikersnaam", persoon.getGebruikersnaam());
		job.add("wachtwoord", persoon.getWachtwoord());
		job.add("geslacht", persoon.getGeslacht());
		job.add("geboorte", persoon.getGeboorte().toString());
		job.add("huisnummer", persoon.getHuisnummer());
		job.add("toevoeging", persoon.getToevoeging());
		job.add("straatnaam", persoon.getStraatnaam());
		job.add("postcode", persoon.getPostcode());
		job.add("plaats", persoon.getPlaats());
		job.add("telefoonnummer", persoon.getTelefoonnummer());
		job.add("email", persoon.getEmail());
		
		JsonArrayBuilder jab = Json.createArrayBuilder();
		jab.add(job);

		return jab.build().toString();
	}
	
	@POST // om te kunnen creeren 
	@Path("/inloggen")// de URL pad aangeven
	@Produces("application/json") // annotatie om de data type aan te geven
	public String inloggen(@FormParam("gebruikersnaam") String gebruikersnaam,
			@FormParam("wachtwoord") String wachtwoord) throws SQLException, ClassNotFoundException, ParseException {
		PersoonService persoonService = new PersoonService();
		persoon = persoonService.inloggen(gebruikersnaam, wachtwoord);
		JsonObjectBuilder job = Json.createObjectBuilder();
		
		job.add("persoonid", persoon.getId());
		job.add("voorletter", persoon.getVoorletter());
		job.add("tussenvoegsel", persoon.getTussenvoegsel());
		job.add("achternaam", persoon.getAchternaam());
		job.add("rol", persoon.getRol());
		job.add("gebruikersnaam", persoon.getGebruikersnaam());
		job.add("wachtwoord", persoon.getWachtwoord());
		job.add("geslacht", persoon.getGeslacht());
		job.add("geboorte", persoon.getGeboorte().toString());
		job.add("huisnummer", persoon.getHuisnummer());
		job.add("toevoeging", persoon.getToevoeging());
		job.add("straatnaam", persoon.getStraatnaam());
		job.add("postcode", persoon.getPostcode());
		job.add("plaats", persoon.getPlaats());
		job.add("telefoonnummer", persoon.getTelefoonnummer());
		job.add("email", persoon.getEmail());

		JsonArrayBuilder jab = Json.createArrayBuilder();
		jab.add(job);

		return jab.build().toString();
	}

	@GET  // om de data te kunnen ophalen 
	@Path("/leden") // de URL pad aangeven 
	@Produces("application/json") // annotatie om de data type aan te geven
	public String ledenOphalen() throws SQLException, ClassNotFoundException, ParseException {
		List<Persoon> personen = new ArrayList<Persoon>();
		
		PersoonService pService = new PersoonService();
		personen = pService.ledenOphalen();
		JsonObjectBuilder job = Json.createObjectBuilder();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Persoon p : personen) {
			job.add("id", p.getId());
			job.add("voorletter", p.getVoorletter());
			job.add("tussenvoegsel", p.getTussenvoegsel());
			job.add("achternaam", p.getAchternaam());
			job.add("rol", p.getRol());
			job.add("gebruikersnaam", p.getGebruikersnaam());
			job.add("wachtwoord", p.getWachtwoord());
			job.add("geslacht", p.getGeslacht());
			job.add("geboorte", p.getGeboorte().toString());
			job.add("huisnummer", p.getHuisnummer());
			job.add("toevoeging", p.getToevoeging());
			job.add("straatnaam", p.getStraatnaam());
			job.add("postcode", p.getPostcode());
			job.add("plaats", p.getPlaats());
			job.add("telefoonnummer", p.getTelefoonnummer());
			job.add("email", p.getEmail());
			jab.add(job);
		}
		return jab.build().toString();
	}

	

	@PUT //om de data te kunnen bewerken 
	@Path("/wijzigen") // de URL pad aangeven 
	@Produces("application/json") // annotatie om de data type aan te geven
	public String persoonWijzigen(

			@FormParam("voorletter") String voorletter, 
			@FormParam("tussenvoegsel") String tussenvoegsel,
			@FormParam("achternaam") String achternaam,	
			@FormParam("rol") String rol,
			@FormParam("gebruikersnaam") String gebruikersNaam,
			@FormParam("wachtwoord") String wachtwoord,  
			@FormParam("geslacht") String geslacht,
			@FormParam("geboorte") Date geboorte, 
			@FormParam("huisnummer") int huisnummer,
			@FormParam("toevoeging") String toevoeging,
			@FormParam("straat") String straatnaam,
			@FormParam("postcode") String postcode, 
			@FormParam("plaats") String plaats,
			@FormParam("telefoonnummer") int telefoonnummer,
			@FormParam("email") String email)
			throws SQLException, ClassNotFoundException, ParseException {
		
		persoon = new Persoon(0, voorletter, tussenvoegsel, achternaam, rol, gebruikersNaam, wachtwoord, geslacht,
				geboorte, huisnummer,toevoeging, straatnaam, postcode, plaats, telefoonnummer, email);

		PersoonService persoonService = new PersoonService();
		persoon = persoonService.persoonWijzigen(persoon);

		JsonObjectBuilder job = Json.createObjectBuilder();

		job.add("voorletter", persoon.getVoorletter());
		job.add("tussenvoegsel", persoon.getTussenvoegsel());
		job.add("achternaam", persoon.getAchternaam());
		job.add("rol", persoon.getRol());
		job.add("gebruikersnaam", persoon.getGebruikersnaam());
		job.add("wachtwoord", persoon.getWachtwoord());
		job.add("geslacht", persoon.getGeslacht());
		job.add("geboorte", persoon.getGeboorte().toString());
		job.add("huisnummer", persoon.getHuisnummer());
		job.add("toevoeging", persoon.getToevoeging());
		job.add("straatnaam", persoon.getStraatnaam());
		job.add("postcode", persoon.getPostcode());
		job.add("plaats", persoon.getPlaats());
		job.add("telefoonnummer", persoon.getTelefoonnummer());
		job.add("email", persoon.getEmail());

		JsonArrayBuilder jab = Json.createArrayBuilder();
		jab.add(job);

		return jab.build().toString();
	}

	@DELETE // om de data te kunnen verwijderen 
	@Path("/verwijderen/{gebruikersnaam}")  // de URL pad aangeven
	@Produces("application/json") // annotatie om de data type aan te geven
	public String persoonVerwijderen(@PathParam("gebruikersnaam") String gebruikersnaam)
			throws SQLException, ClassNotFoundException, ParseException {
		PersoonService pService = new PersoonService();
		boolean deleted = pService.persoonVerwijderen(gebruikersnaam);
		JsonObjectBuilder job = Json.createObjectBuilder();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		job.add("verwijderd", deleted);
		jab.add(job);

		return jab.build().toString();
	}

}
