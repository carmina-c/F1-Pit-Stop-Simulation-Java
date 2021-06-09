package pitStopStrategy;
import pitStopStrategy.InginerCursa;
import pitCrew.*;
import driver.*;
import semafoare.*;

public class MainClass {
	public static int viteza, temperatura;
	public static int threshold_viteza = 80;
	
	public static SemaforBinar sem_pilot = new SemaforBinar();
	public static SemaforBinar sem_mecanici = new SemaforBinar();
	public static SemaforBinar sem_pozitie = new SemaforBinar();
	public static SemaforBinar sem_pneuri = new SemaforBinar();
	public static SemaforBinar sem_go = new SemaforBinar();
	public static SemaforBinar sem_foc = new SemaforBinar();
	public static SemaforBinar sem_sf = new SemaforBinar();
	public static SemaforBinar sem_ss = new SemaforBinar();
	public static SemaforBinar sem_df = new SemaforBinar();
	public static SemaforBinar sem_ds = new SemaforBinar();
	public static SemaforBinar gata_sf = new SemaforBinar();
	public static SemaforBinar gata_ss = new SemaforBinar();
	public static SemaforBinar gata_df = new SemaforBinar();
	public static SemaforBinar gata_ds = new SemaforBinar();
	public static SemaforBinar gata_pneuri = new SemaforBinar();
	public static SemaforBinar gata_pozitie = new SemaforBinar();
	public static SemaforBinar gata_pilot = new SemaforBinar();
	public static SemaforBinar foc_stins = new SemaforBinar();
	
	
	public static void main(String[] args) {
		InginerCursa inginerCursa = new InginerCursa();
		inginerCursa.start();
		Pilot pilot = new Pilot();
		pilot.start();
		MecaniciPneuri mecaniciPneuri = new MecaniciPneuri();
		mecaniciPneuri.start();
		MecaniciPozitie mecaniciPozitie = new MecaniciPozitie();
		mecaniciPozitie.start();
		StingatorFoc stingator = new StingatorFoc();
		stingator.start();		
		PneuStangaFata psf = new PneuStangaFata();
		psf.start();
		PneuDreaptaFata pdf = new PneuDreaptaFata();
		pdf.start();
		PneuStangaSpate pss = new PneuStangaSpate();
		pss.start();
		PneuDreaptaSpate pds = new PneuDreaptaSpate();
		pds.start();
	}

}
