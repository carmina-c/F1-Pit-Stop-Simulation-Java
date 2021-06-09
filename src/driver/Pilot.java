package driver;
import java.util.Calendar;

import pitStopStrategy.MainClass;

public class Pilot extends Thread {

	MainClass main = new MainClass();
	Calendar startPit, endPit;
	
	@Override
	public void run() {
		main.sem_pilot.sem_wait();
		
		System.out.println("[pilot]: Pilotul e chemat la boxe");
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("[pilot]: Pilotul confirma oprirea");
		
		synchronized(this) {
			System.out.println("[pilot]: Viteza masinii este = " +  main.viteza + " kmh");
			System.out.println("[pilot]: Viteza masinii scade...\n");
			while(main.viteza > main.threshold_viteza){
				main.viteza -= 10;
				try {
					sleep(250);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("[pilot:] Intrare pit lane");
		System.out.println("[pilot]: Pilotul apasa butonul de reducere a vitezei in pitlane");
		startPit = Calendar.getInstance();
		System.out.println("[pilot]: Viteza masinii este = " + main.viteza + " kmh\n");
		try {
			sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("[pilot]: Pilotul aduce masina in zona marcata din dreptul garajului");
		main.viteza = 0;
		System.out.println("[pilot]: Viteza masinii este = " +  main.viteza + " kmh\n");
		
		if(main.temperatura > 1000) {
			main.sem_foc.sem_post();
			main.foc_stins.sem_wait();
		}
		
		main.sem_pozitie.sem_post();
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		main.sem_pneuri.sem_post();
		
		main.sem_go.sem_wait();
		
		synchronized(this) {
			System.out.println("\n[pilot]: Viteza masinii este = " +  main.viteza + " kmh");
			System.out.println("[pilot]: Pilotul accelereaza");
			main.viteza = 80;
			System.out.println("[pilot]: Viteza masinii este = " +  main.viteza + " kmh\n");
			try {
				sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("[pilot]: Exit pitlane");
	
			endPit = Calendar.getInstance();
			long durataPit = endPit.getTimeInMillis() - startPit.getTimeInMillis();
			System.out.println("\n[pilot]: Pitstop-ul a durat: " + durataPit/1000.0 + " secunde\n");
			
			System.out.println("[pilot]: Pilotul accelereaza");
			while(main.viteza < 200){
				main.viteza += 50;
				System.out.println("[pilot]: Viteza masinii este = " +  main.viteza + " kmh");
				try {
					sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		main.gata_pilot.sem_post();
	}
}
