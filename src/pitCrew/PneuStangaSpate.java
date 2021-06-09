package pitCrew;
import pitStopStrategy.MainClass;

import java.util.Calendar;
import java.util.Random;

public class PneuStangaSpate extends Thread{
	
	MainClass main = new MainClass();
	Random rand = new Random();
	Calendar start_ss, end_ss;

	@Override
	public void run() {
		main.sem_ss.sem_wait();
		
		start_ss = Calendar.getInstance();
				
		int timp = 400 + rand.nextInt(600);
		try {
			sleep(timp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[mecanici_stanga_spate  ]: demonteaza pneurile");
		
		timp = 400 + rand.nextInt(600);
		try {
			sleep(timp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[mecanici_stanga_spate  ]: scot pneurile vechi");
		
		timp = 400 + rand.nextInt(600);
		try {
			sleep(timp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[mecanici_stanga_spate  ]: pun pneurile noi");

		timp = 400 + rand.nextInt(600);
		try {
			sleep(timp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[mecanici_stanga_spate  ]: monteaza pneurile");

		end_ss = Calendar.getInstance();
		long timp_ss = end_ss.getTimeInMillis() - start_ss.getTimeInMillis();
		System.out.println("[mecanici_stanga_spate  ]: Pneul stanga spate a fost schimbat in " + timp_ss/1000.0 + " secunde");
		
		main.gata_ss.sem_post();
	}
}
