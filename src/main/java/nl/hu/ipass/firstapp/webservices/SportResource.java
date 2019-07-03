package nl.hu.ipass.firstapp.webservices;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;

import nl.hu.ipass.firstapp.model.Sport;
import nl.hu.ipass.firstapp.serviceproviders.SportService;

@Path("/sport")
public class SportResource {
	private Sport sport;
	@GET
	@Path("/ophalen")
	@Produces("application/json")
	public String sportenOphalen(String naam)
			throws SQLException, ClassNotFoundException, ParseException {
		List<Sport> sporten = new ArrayList<Sport>();
		SportService sService = new SportService();
		sporten = sService.sportenOphalen(naam);
		JsonObjectBuilder job = Json.createObjectBuilder();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		for (Sport s : sporten) {

			job.add("naam", s.getNaam());
			job.add("id", s.getId());
			
			jab.add(job);
		}
		JsonArray array =jab.build();
		return array.toString();
	}

	
	
	@POST
	@Path("/toevoegen")
	@Produces("application/json")
	public String sportToevoegen(
			@FormParam("naam") String naam,
			@FormParam("id") int id)

			throws SQLException, ClassNotFoundException, ParseException {
		sport = new Sport(naam, id);

		SportService sService = new SportService();
		sport = sService.sportToevoegen(sport);

		JsonObjectBuilder job = Json.createObjectBuilder();
		
		job.add("naam", sport.getNaam());
		job.add("Id", sport.getId());
		
		JsonArrayBuilder jab = Json.createArrayBuilder();
		jab.add(job);

		return jab.build().toString();
	}
	
	
	@PUT
	@Path("/wijzigen")
	@Produces("application/json")
	public String sportWijzigen(
				@FormParam("sport") String naam,
				@FormParam("id") int id)
			throws SQLException, ClassNotFoundException, ParseException {
		sport = new Sport(naam, id);

		SportService sService = new SportService();
		sport = sService.sportWijzigen(sport);

		JsonObjectBuilder job = Json.createObjectBuilder();

		job.add("naam", sport.getNaam());
		job.add("id", sport.getId());
		
		JsonArrayBuilder jab = Json.createArrayBuilder();
		jab.add(job);

		return jab.build().toString();
	}

	@DELETE
	@Path("/verwijderen/{naam}")
	@Produces("application/json")
	public String sportVerwijderen(@PathParam("naam") String naam)
			throws SQLException, ClassNotFoundException, ParseException {
		SportService sService = new SportService();
		boolean deleted = sService.sportVerwijderen(naam);
		JsonObjectBuilder job = Json.createObjectBuilder();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		job.add("verwijderd", deleted);
		jab.add(job);

		return jab.build().toString();
	}

}
