package pitCrew;
import pitStopStrategy.MainClass;

import java.util.Calendar;
import java.util.Random;

public class PneuDreaptaSpate extends Thread{
	
	MainClass main = new MainClass();
	Random rand = new Random();
	Calendar start_ds, end_ds;

	@Override
	public void run() {
		main.sem_ds.sem_wait();
		
		start_ds = Calendar.getInstance();
				
		int timp = 400 + rand.nextInt(600);
		try {
			sleep(timp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[mecanici_dreapta_spate ]: demonteaza pneurile");
		
		timp = 400 + rand.nextInt(600);
		try {
			sleep(timp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[mecanici_dreapta_spate ]: scot pneurile vechi");
		
		timp = 400 + rand.nextInt(600);
		try {
			sleep(timp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[mecanici_dreapta_spate ]: pun pneurile noi");

		timp = 400 + rand.nextInt(600);
		try {
			sleep(timp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[mecanici_dreapta_spate ]: monteaza pneurile");

		end_ds = Calendar.getInstance();
		long timp_ds = end_ds.getTimeInMillis() - start_ds.getTimeInMillis();
		System.out.println("[mecanici_dreapta_spate ]: Pneul dreapta spate a fost schimbat in " + timp_ds/1000.0 + " secunde");
		
		main.gata_ds.sem_post();
	}

}
