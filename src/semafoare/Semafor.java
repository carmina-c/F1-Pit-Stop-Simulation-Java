package semafoare;

public class Semafor {
	protected int value = 0;
	
	 public Semafor() {
		 value = 0;
	 }
	
	 public Semafor(int initial) {
		 if (initial < 0)
			 throw new IllegalArgumentException("initial<0");
		 value = initial;
	 }
	
	 //equivalent of sem_wait() from POSIX (Linux, QNX)
	 public synchronized void sem_wait() {
		 if (value > 0)
			 	value--;
		 else {
			 while (true) { // we must be notified not interrupted
				try {
					wait();
					break; // notify(), so sem_wait() succeeds
				} catch (InterruptedException e) {
					System.err.println("Semafor.wait():InterruptedException, wait again");
					if (value > 0)
						break; // race condition fix
					else
						continue; // no sem_post() yet
				}
			 }
			 value--;
		 }
	 }
	
	 //equivalent of sem_post() from POSIX (Linux, QNX)
	 public synchronized void sem_post() {
		 value++;
		 if (value == 1)
			 notify();
	 }
	
	 public synchronized int getValue() {
		 return value;
	 }
	
	public synchronized String toString() {
		return String.valueOf(value);
	}
}


