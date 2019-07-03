package nl.hu.ipass.firstapp.model;

import java.sql.Date;

public class Verzoek {
	
	private int verzoek;
	private int sportId;
	private String voorletter;
	private String tussenvoegsel;
	private String achternaam;
	private String gebruikersnaam;
	private String geslacht;
	private Date geboorte;
	private int huisnummer;
	private String toevoeging;
	private String straatnaam;
	private String postcode;
	private String plaats;
	private int telefoonnummer;
	private String email;
	private Date van;
	private Date tot;
	private String zelfbeschrijving;
	public Verzoek(int verzoek,
			int sportId, 
			String voorletter, 
			String tussenvoegsel,
			String achternaam,
			String gebruikersnaam,
			String geslacht,
			Date geboorte,
			int huisnummer, 
			String toevoeging,
			String straatnaam,
			String postcode, 
			String plaats, 
			int telefoonnummer,
			String email,
			Date van, 
			Date tot,
			String zelfbeschrijving) {
		super();
		this.verzoek = verzoek;
		this.sportId = sportId;
		this.voorletter = voorletter;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.gebruikersnaam = gebruikersnaam;
		this.geslacht = geslacht;
		this.geboorte = geboorte;
		this.huisnummer = huisnummer;
		this.toevoeging = toevoeging;
		this.straatnaam = straatnaam;
		this.postcode = postcode;
		this.plaats = plaats;
		this.telefoonnummer = telefoonnummer;
		this.email = email;
		this.van = van;
		this.tot = tot;
		this.zelfbeschrijving = zelfbeschrijving;
	}
	public int getVerzoek() {
		return verzoek;
	}
	public void setVerzoek(int verzoek) {
		this.verzoek = verzoek;
	}
	public int getSportId() {
		return sportId;
	}
	public void setSportId(int sportId) {
		this.sportId = sportId;
	}
	public String getVoorletter() {
		return voorletter;
	}
	public void setVoorletter(String voorletter) {
		this.voorletter = voorletter;
	}
	public String getTussenvoegsel() {
		return tussenvoegsel;
	}
	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}
	public String getAchternaam() {
		return achternaam;
	}
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}
	public String getGebruikersnaam() {
		return gebruikersnaam;
	}
	public void setGebruikersnaam(String gebruikersnaam) {
		this.gebruikersnaam = gebruikersnaam;
	}
	public String getGeslacht() {
		return geslacht;
	}
	public void setGeslacht(String geslacht) {
		this.geslacht = geslacht;
	}
	public Date getGeboorte() {
		return geboorte;
	}
	public void setGeboorte(Date geboorte) {
		this.geboorte = geboorte;
	}
	public int getHuisnummer() {
		return huisnummer;
	}
	public void setHuisnummer(int huisnummer) {
		this.huisnummer = huisnummer;
	}
	public String getToevoeging() {
		return toevoeging;
	}
	public void setToevoeging(String toevoeging) {
		this.toevoeging = toevoeging;
	}
	public String getStraatnaam() {
		return straatnaam;
	}
	public void setStraatnaam(String straatnaam) {
		this.straatnaam = straatnaam;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getPlaats() {
		return plaats;
	}
	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}
	public int getTelefoonnummer() {
		return telefoonnummer;
	}
	public void setTelefoonnummer(int telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getZelfbeschrijving() {
		return zelfbeschrijving;
	}
	public void setZelfbeschrijving(String zelfbeschrijving) {
		this.zelfbeschrijving = zelfbeschrijving;
	}
	@Override
	public String toString() {
		return "Verzoek [verzoek=" + verzoek + ", sportId=" + sportId + ", voorletter=" + voorletter
				+ ", tussenvoegsel=" + tussenvoegsel + ", achternaam=" + achternaam + ", gebruikersnaam="
				+ gebruikersnaam + ", geslacht=" + geslacht + ", geboorte=" + geboorte + ", huisnummer=" + huisnummer
				+ ", toevoeging=" + toevoeging + ", straatnaam=" + straatnaam + ", postcode=" + postcode + ", plaats="
				+ plaats + ", telefoonnummer=" + telefoonnummer + ", email=" + email + ", van=" + van + ", tot=" + tot
				+ ", zelfbeschrijving=" + zelfbeschrijving + "]";
	}
	
	
	
}
