package pitStopStrategy;
import pitStopStrategy.MainClass;
import java.util.Random;
import java.util.Scanner;

public class InginerCursa extends Thread {
	
	MainClass main = new MainClass();
	Random rand = new Random();
	Scanner scanner = new Scanner(System.in);
	
	@Override
	public void run() {
		
		int operatie = 0;
		
		main.viteza = 200 + rand.nextInt(120);
		main.temperatura = 500 + rand.nextInt(700);
		
		System.out.println("Conditii masina:\nViteza = " + main.viteza + " kmh\nTemperatura discurilor de frana = " + main.temperatura + " grade C");
		System.out.println("Selectati o comanda:");
		System.out.println("1. Chemare la boxe.");
		operatie = scanner.nextInt();
		System.out.println("Ati ales: " + operatie);
		while(1==1) {
			switch(operatie) {
				case 1:
					main.sem_pilot.sem_post();
					main.sem_mecanici.sem_post();
					main.gata_pozitie.sem_wait();
					main.sem_go.sem_post();
					main.gata_pilot.sem_wait();
					break;
				default:
					System.out.println("Alegeti altceva");
					operatie = scanner.nextInt();	
			}
		}
	}
}
