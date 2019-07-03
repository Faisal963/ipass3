package nl.hu.ipass.firstapp.model;

import java.util.*;

public class Inschrijving {
	
	private int inschrijving;
	private int persoonId;
	private int sportId;
	private Date van;
	private Date tot;
	private List<Persoon> personen_inschrijving = new ArrayList<Persoon>();
	private List<Sport> sports_inschrijving = new ArrayList<Sport>();
	
	
	public Inschrijving(int insch,int pId,int sId, Date v, Date t) {
		inschrijving = insch;
		setPersoonId(pId);
		setSportId(sId);
		van = v;
		tot = t;	
	}

	public int getInschrijving() {
		return inschrijving;
	}

	public void setInschrijving(int inschrijving) {
		this.inschrijving = inschrijving;
	}

	public Date getVan() {
		return van;
	}

	public void setVan(Date van) {
		this.van = van;
	}

	public Date getTot() {
		return tot;
	}

	public void setTot(Date tot) {
		this.tot = tot;
	}

	public int getSportId() {
		return sportId;
	}

	public void setSportId(int sportId) {
		this.sportId = sportId;
	}

	public int getPersoonId() {
		return persoonId;
	}

	public void setPersoonId(int persoonId) {
		this.persoonId = persoonId;
	}

	public List<Persoon> getPersonen_inschrijving() {
		return personen_inschrijving;
	}

	public void setPersonen_inschrijving(List<Persoon> personen_inschrijving) {
		this.personen_inschrijving = personen_inschrijving;
	}

	public List<Sport> getSports_inschrijving() {
		return sports_inschrijving;
	}

	public void setSports_inschrijving(List<Sport> sports_inschrijving) {
		this.sports_inschrijving = sports_inschrijving;
	}
	

}
