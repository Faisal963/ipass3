package nl.hu.ipass.firstapp.serviceproviders;

public class ServiceProvider {
	
	private static PersoonService persoonService = new PersoonService();
	private static InschrijvingService inschrijvingService = new InschrijvingService();
	private static SportService sportService = new SportService();
	private static VerzoekService verzoekService = new VerzoekService();

	public static PersoonService getPersoonService() {
		return persoonService;
	}
	
	public static InschrijvingService getInschrijvingService() {
		return inschrijvingService;
	}
	
	public static SportService getSportService() {
		return sportService;
	}
	
	public static VerzoekService getVrezoekService() {
		return verzoekService;
	}
}
