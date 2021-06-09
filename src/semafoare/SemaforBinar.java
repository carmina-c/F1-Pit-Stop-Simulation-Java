package semafoare;

public final class SemaforBinar extends Semafor {
	
	public SemaforBinar() {
		super();
	}
	
	public SemaforBinar(int initial) {
		super(initial);
		if(initial > 1)
			throw new IllegalArgumentException("inital>1");
	}
	
	public SemaforBinar(boolean initial) {
		super(initial ? 1 : 0);
	}
	
	public final synchronized void sem_post( ) {
		super.sem_post();
		if(value > 1)
			value  = 1;
		
	}
}
