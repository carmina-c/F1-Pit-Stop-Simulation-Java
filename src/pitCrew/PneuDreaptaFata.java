package pitCrew;
import pitStopStrategy.MainClass;

import java.util.Calendar;
import java.util.Random;

public class PneuDreaptaFata extends Thread{
	
	MainClass main = new MainClass();
	Random rand = new Random();
	Calendar start_df, end_df;

	@Override
	public void run() {
		main.sem_df.sem_wait();
			
		start_df = Calendar.getInstance();
		
		int timp = 400 + rand.nextInt(600);
		try {
			sleep(timp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[mecanici_dreapta_fata  ]: demonteaza pneurile");
		
		timp = 400 + rand.nextInt(600);
		try {
			sleep(timp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[mecanici_dreapta_fata  ]: scot pneurile vechi");
		
		timp = 400 + rand.nextInt(600);
		try {
			sleep(timp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[mecanici_dreapta_fata  ]: pun pneurile noi");

		timp = 400 + rand.nextInt(600);
		try {
			sleep(timp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[mecanici_dreapta_fata  ]: monteaza pneurile");

		end_df = Calendar.getInstance();
		long timp_df = end_df.getTimeInMillis() - start_df.getTimeInMillis();
		System.out.println("[mecanici_dreapta_fata  ]: Pneul dreapta fata a fost schimbat in " + timp_df/1000.0 + " secunde");
		
		main.gata_df.sem_post();
	}

}
