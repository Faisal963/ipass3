package nl.hu.ipass.firstapp.webservices;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import javax.json.*;

import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import nl.hu.ipass.firstapp.model.Verzoek;
import nl.hu.ipass.firstapp.serviceproviders.VerzoekService;

@Path("/verzoek")
public class VerzoekResource {
	private Verzoek verzoek;
	
	@GET
	@Path("/ophalen/{verzoekId}")
	@Produces("application/json")
	public String verzoekOphalen(@PathParam("verzoekId") int verzoekId)
			throws SQLException, ClassNotFoundException, ParseException {
		List<Verzoek> verzoeken = new ArrayList<Verzoek>();
		VerzoekService vService = new VerzoekService();
		verzoeken = vService.verzoekOphalen(verzoekId);
		JsonObjectBuilder job = Json.createObjectBuilder();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Verzoek v : verzoeken) {
			
			job.add("verzoekId", v.getVerzoek());
			job.add("sportId", v.getSportId());
			job.add("voorletter", v.getVoorletter());
			job.add("tussenvoegsel", v.getTussenvoegsel());
			job.add("achternaam", v.getAchternaam());
			job.add("gebruikersnaam", v.getGebruikersnaam());
			job.add("geslacht", v.getGeslacht());
			job.add("geboortedatum", v.getGeboorte().toString());
			job.add("huisnummer", v.getHuisnummer());
			job.add("toevoeging", v.getToevoeging());
			job.add("straatnaam", v.getStraatnaam());
			job.add("postcode", v.getPostcode());
			job.add("plaats", v.getPlaats());
			job.add("telefoonnummer", v.getTelefoonnummer());
			job.add("email", v.getEmail());
			job.add("van", v.getVan().toString());
			job.add("tot", v.getTot().toString());
			job.add("zelfbeschrijving", v.getZelfbeschrijving());
			jab.add(job);
		}
		JsonArray array =jab.build();
		return array.toString();
	}

	
	@POST
	@Path("/toevoegen")
	@Produces("application/json")
	public String verzoekToevoegen(
			@FormParam("sportId")int sportId,
			@FormParam("voorletter")String voorletter,
			@FormParam("tussenvoegsel") String tussenvoegsel,
			@FormParam("achternaam") String achternaam,
			@FormParam("gebruikersnaam") String gebruikersnaam,
			@FormParam("geslacht") String geslacht,
			@FormParam("geboortedatum") Date geboorte, 
			@FormParam("huisnummer") int huisnummer,
			@FormParam("toevoeging") String toevoeging,
			@FormParam("straatnaam") String straatnaam,
			@FormParam("postcode") String postcode, 
			@FormParam("plaats") String plaats,
			@FormParam("telefoonnummer") int telefoonnummer,
			@FormParam("email") String email,
			@FormParam("van") Date van,
			@FormParam("tot") Date tot,
			@FormParam("zelfbeschrijving") String zelfbeschrijving)

			throws SQLException, ClassNotFoundException, ParseException {
//		SimpleDateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
//		Date geboorteDatum = dF.parse(geboorte);
//		Date van2 = dF.parse(van);
//		Date tot2 = dF.parse(tot);
		
		verzoek = new Verzoek(0, sportId, voorletter, tussenvoegsel, achternaam, gebruikersnaam, geslacht,
				geboorte, huisnummer,toevoeging, straatnaam, postcode, plaats, telefoonnummer, email, van, tot, zelfbeschrijving);

		VerzoekService vService = new VerzoekService();
		verzoek = vService.verzoekToevoegen(verzoek);

		JsonObjectBuilder job = Json.createObjectBuilder();
		
		job.add("verzoekId", verzoek.getVerzoek());
		job.add("sportId", verzoek.getSportId());
		job.add("voorletter", verzoek.getVoorletter());
		job.add("tussenvoegsel", verzoek.getTussenvoegsel());
		job.add("achternaam", verzoek.getAchternaam());
		job.add("gebruikersnaam", verzoek.getGebruikersnaam());
		job.add("geslacht", verzoek.getGeslacht());
		job.add("geboortedatum", verzoek.getGeboorte().toString());
		job.add("huisnummer", verzoek.getHuisnummer());
		job.add("toevoeging", verzoek.getToevoeging());
		job.add("straatnaam", verzoek.getStraatnaam());
		job.add("postcode", verzoek.getPostcode());
		job.add("plaats", verzoek.getPlaats());
		job.add("telefoonnummer", verzoek.getTelefoonnummer());
		job.add("email", verzoek.getEmail());
		job.add("van", verzoek.getVan().toString());
		job.add("tot", verzoek.getTot().toString());
		job.add("zelfbeschrijving", verzoek.getZelfbeschrijving());

		
		JsonArrayBuilder jab = Json.createArrayBuilder();
		jab.add(job);

		return jab.build().toString();
	}
	

	@DELETE
	@Path("/verwijderen/{verzoekId}")
	@Produces("application/json")
	public String verzoekVerwijderen(@PathParam("verzoekId") int verzoek)
			throws SQLException, ClassNotFoundException, ParseException {
		VerzoekService vService = new VerzoekService();
		boolean deleted = vService.verzoekVerwijderen(verzoek);
		JsonObjectBuilder job = Json.createObjectBuilder();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		job.add("verwijderd", deleted);
		jab.add(job);

		return jab.build().toString();
	}
	
	
	@GET
	@Path("/alles")
	@Produces("application/json")
	public String verzoekenOphalen()
			throws SQLException, ClassNotFoundException, ParseException {
		List<Verzoek> verzoeken = new ArrayList<Verzoek>();
		VerzoekService vService = new VerzoekService();
		verzoeken = vService.verzoekenOphalen();
		JsonObjectBuilder job = Json.createObjectBuilder();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Verzoek v : verzoeken) {
			
			job.add("verzoekId", v.getVerzoek());
			job.add("sportId", v.getSportId());
			job.add("voorletter", v.getVoorletter());
			job.add("tussenvoegsel", v.getTussenvoegsel());
			job.add("achternaam", v.getAchternaam());
			job.add("gebruikersnaam", v.getGebruikersnaam());
			job.add("geslacht", v.getGeslacht());
			job.add("geboortedatum", v.getGeboorte().toString());
			job.add("huisnummer", v.getHuisnummer());
			job.add("toevoeging", v.getToevoeging());
			job.add("straatnaam", v.getStraatnaam());
			job.add("postcode", v.getPostcode());
			job.add("plaats", v.getPlaats());
			job.add("telefoonnummer", v.getTelefoonnummer());
			job.add("email", v.getEmail());
			job.add("van", v.getVan().toString());
			job.add("tot", v.getTot().toString());
			job.add("zelfbeschrijving", v.getZelfbeschrijving());
			jab.add(job);
		}
		JsonArray array =jab.build();
		return array.toString();
	}

}
