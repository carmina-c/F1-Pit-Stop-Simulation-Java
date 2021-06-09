package pitCrew;
import java.util.Calendar;

import pitStopStrategy.MainClass;

public class MecaniciPneuri extends Thread{
	
	MainClass main = new MainClass();
	Calendar startPneuri, endPneuri;
	
	@Override
	public void run() {
		main.sem_pneuri.sem_wait();
		
		startPneuri = Calendar.getInstance();
		
		main.sem_sf.sem_post();
		main.sem_ss.sem_post();
		main.sem_df.sem_post();
		main.sem_ds.sem_post();
		main.gata_sf.sem_wait();
		main.gata_ss.sem_wait();
		main.gata_df.sem_wait();
		main.gata_ds.sem_wait();
		
		endPneuri = Calendar.getInstance();
		long timpPneuri = endPneuri.getTimeInMillis() - startPneuri.getTimeInMillis();
		
		System.out.println("[mecanici_pneuri]: Pneurile au fost schimbate in " + timpPneuri/1000.0 + " secunde");
		
		main.gata_pneuri.sem_post();
	}
}
