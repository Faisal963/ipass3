package nl.hu.ipass.firstapp.webservices;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.json.*;
import javax.ws.rs.*;
import nl.hu.ipass.firstapp.model.Inschrijving;
import nl.hu.ipass.firstapp.serviceproviders.InschrijvingService;
@Path("/inschrijving/")
public class InschrijvingResource {
	private Inschrijving inschrijving;
	@GET
	@Path("/ophalen")
	@Produces("application/json")
	public String inschrijvingenOphalen(int id)
			throws SQLException, ClassNotFoundException, ParseException {
		List<Inschrijving> inschrijvingen = new ArrayList<Inschrijving>();
		InschrijvingService iService = new InschrijvingService();
		inschrijvingen = iService.inschrijvingenOphalen(id);
		JsonObjectBuilder job = Json.createObjectBuilder();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Inschrijving i : inschrijvingen) {

			job.add("inschrijving", i.getInschrijving());
			job.add("persoonId", i.getPersoonId());
			job.add("sportId", i.getSportId());
			job.add("van", i.getVan().toString());
			job.add("tot", i.getTot().toString());
			
			jab.add(job);
		}
		JsonArray array =jab.build();
		return array.toString();
	}

	
	
	@POST
	@Path("/toevoegen")
	@Produces("application/json")
	public String inschrijvingToevoegen(
			@FormParam("inschrijving") int insch,
			@FormParam("persoonId") int persoonId,
			@FormParam("sportId") int sportId,
			@FormParam("van") String van, 
			@FormParam("tot") String tot)

			throws SQLException, ClassNotFoundException, ParseException {
		SimpleDateFormat sDF = new SimpleDateFormat("yyyy-MM-dd");
		Date van2 = sDF.parse(van);
		Date tot2 =sDF.parse(tot);
		inschrijving = new Inschrijving(insch, persoonId, sportId, van2, tot2);

		InschrijvingService iService = new InschrijvingService();
		inschrijving = iService.inschrijvingToevoegen(inschrijving);

		JsonObjectBuilder job = Json.createObjectBuilder();
		
		job.add("inschrijving", inschrijving.getInschrijving());
		job.add("persoonId", inschrijving.getPersoonId());
		job.add("sportId", inschrijving.getSportId());
		job.add("van", inschrijving.getVan().toString());
		job.add("tot", inschrijving.getTot().toString());
		
		JsonArrayBuilder jab = Json.createArrayBuilder();
		jab.add(job);

		return jab.build().toString();
	}
	
	
	
	@PUT
	@Path("/wijzigen")
	@Produces("application/json")
	public String inschrijvingWijzigen(
				@FormParam("inschrijving") int insch,
				@FormParam("persoonId") int persoonId,
				@FormParam("sportId") int sportId,
				@FormParam("van") String van, 
				@FormParam("tot") String tot)
			throws SQLException, ClassNotFoundException, ParseException {
		
		SimpleDateFormat sDF = new SimpleDateFormat("yyyy-MM-dd");
		Date van2 = sDF.parse(van);
		Date tot2 = sDF.parse(tot);
		inschrijving = new Inschrijving(insch, persoonId, sportId,
				van2, tot2);

		InschrijvingService iService = new InschrijvingService();
		inschrijving = iService.inschrijvingWijzigen(inschrijving);

		JsonObjectBuilder job = Json.createObjectBuilder();

		job.add("inschrijving", inschrijving.getInschrijving());
		job.add("persoonId", inschrijving.getPersoonId());
		job.add("sportId", inschrijving.getSportId());
		job.add("van", inschrijving.getVan().toString());
		job.add("tot", inschrijving.getTot().toString());
		
		JsonArrayBuilder jab = Json.createArrayBuilder();
		jab.add(job);

		return jab.build().toString();
	}

	@DELETE
	@Path("/verwijderen/{inschrijving}")
	@Produces("application/json")
	public String inschrijvingVerwijderen(@PathParam("inschrijving") int inschrijving)
			throws SQLException, ClassNotFoundException, ParseException {
		InschrijvingService iService = new InschrijvingService();
		boolean deleted = iService.inschrijvingVerwijderen(inschrijving);
		JsonObjectBuilder job = Json.createObjectBuilder();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		job.add("verwijderd", deleted);
		jab.add(job);

		return jab.build().toString();
	}
}
