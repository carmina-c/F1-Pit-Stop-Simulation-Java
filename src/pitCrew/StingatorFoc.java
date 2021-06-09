package pitCrew;
import pitStopStrategy.MainClass;

public class StingatorFoc extends Thread {

	MainClass main = new MainClass();
	
	@Override
	public void run() {
		main.sem_foc.sem_wait();
		
		synchronized(this) {
			System.out.println("[mecanic_stingator_foc]: Stinge focul si raceste franele");
			while(main.temperatura > 500) {
				main.temperatura -= 90;
				System.out.println("Temperatura = " + main.temperatura + " grade C");
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		main.foc_stins.sem_post();
	}
}
