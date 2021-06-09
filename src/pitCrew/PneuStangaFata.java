package pitCrew;
import pitStopStrategy.MainClass;

import java.util.Calendar;
import java.util.Random;

public class PneuStangaFata extends Thread{
	
	MainClass main = new MainClass();
	Random rand = new Random();
	Calendar start_sf, end_sf;
	
	@Override
	public void run() {
		main.sem_sf.sem_wait();
		
		start_sf = Calendar.getInstance();
				
		int timp = 400 + rand.nextInt(600);
		try {
			sleep(timp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[mecanici_stanga_fata   ]: demonteaza pneurile");
		
		timp = 400 + rand.nextInt(600);
		try {
			sleep(timp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[mecanici_stanga_fata   ]: scot pneurile vechi");
		
		timp = 400 + rand.nextInt(600);
		try {
			sleep(timp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[mecanici_stanga_fata   ]: pun pneurile noi");

		timp = 400 + rand.nextInt(600);
		try {
			sleep(timp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[mecanici_stanga_fata   ]: monteaza pneurile");

		end_sf = Calendar.getInstance();
		long timp_sf = end_sf.getTimeInMillis() - start_sf.getTimeInMillis();
		System.out.println("[mecanici_stanga_fata   ]: Pneul stanga fata a fost schimbat in " + timp_sf/1000.0 + " secunde");
		
		main.gata_sf.sem_post();
	}
	
}
