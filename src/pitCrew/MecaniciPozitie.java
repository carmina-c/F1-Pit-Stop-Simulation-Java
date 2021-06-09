package pitCrew;
import pitStopStrategy.MainClass;

public class MecaniciPozitie extends Thread{

	MainClass main = new MainClass();
	
	@Override
	public void run() {
		main.sem_mecanici.sem_wait();
		
		System.out.println("[mecanici_pozitie]: Mecanicii isi iau pozitia");
		
		main.sem_pozitie.sem_wait();
		
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("[mecanici_pozitie]: 2 mecanici ridica masina");
		System.out.println("[mecanici_pozitie]: 2 mecanici mentin masina stabila din lateral...");
		
		main.gata_pneuri.sem_wait();
		
		System.out.println("[mecanici_pozitie]: 2 mecanici coboara masina");
		
		main.gata_pozitie.sem_post();
	}
}
