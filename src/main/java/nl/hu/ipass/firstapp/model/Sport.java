package nl.hu.ipass.firstapp.model;

public class Sport {
	private int id;
	private String naam;
	
	public Sport( String naam, int id) {
		super();
		this.id = id;
		this.naam = naam;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
}
