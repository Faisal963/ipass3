package nl.hu.ipass.firstapp.model;

import java.sql.Date;

public class Persoon {

	private int id;
	private String voorletter;
	private String tussenvoegsel;
	private String achternaam;
	private String rol;
	private String gebruikersnaam;
	protected String wachtwoord;
	private String geslacht;
	private Date geboorte;
	private int huisnummer;
	private String toevoeging;
	private String straatnaam;
	private String postcode;
	private String plaats;
	private int telefoonnummer;
	private String email;

	public Persoon(
			int id,
			String voorletter,
			String tussenvoegsel,
			String achternaam, 
			String rol,
			String gebruikersnaam,
			String wachtwoord,
			String geslacht, 
			Date geboorte,
			int huisnummer,
			String toevoeging,
			String straatnaam,
			String postcode,
			String plaats, 
			int telefoonnummer,
			String email) {
		this.id = id;
		this.voorletter = voorletter;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.rol = rol;
		this.gebruikersnaam = gebruikersnaam;
		this.wachtwoord = wachtwoord;
		this.geslacht = geslacht;
		this.geboorte = geboorte;
		this.huisnummer = huisnummer;
		this.toevoeging = toevoeging;
		this.straatnaam = straatnaam;
		this.postcode = postcode;
		this.plaats = plaats;
		this.telefoonnummer = telefoonnummer;
		this.email = email;
	}

	public int getId() {
		return id;
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

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getGebruikersnaam() {
		return gebruikersnaam;
	}

	public void setGebruikersnaam(String gebruikersnaam) {
		this.gebruikersnaam = gebruikersnaam;
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
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

	@Override
	public String toString() {
		return "Persoon [id=" + id + 
				", voorletter=" + voorletter + 
				", tussenvoegsel=" + tussenvoegsel + 
				", achternaam=" + achternaam + 
				", rol=" + rol + 
				", gebruikersnaam=" + gebruikersnaam + 
				", geslacht=" + geslacht + 
				", geboorte=" + geboorte + 
				", huisnummer=" + huisnummer + 
				", toevoeging=" + toevoeging + 
				", straatnaam=" + straatnaam + 
				", postcode=" + postcode + 
				", plaats=" + plaats + 
				", telefoonnummer=" + telefoonnummer + 
				", email=" + email + "]";
	}
}
