package sample;

class ThreadEx_11 extends Thread {
		
	final static int MAX_MEMORY = 1000;
	int usedMemory = 0;
	
	@Override
	public void run() {
	
		while(true) {
			try {
				Thread.sleep(10000);
			} catch (Exception e) {
				System.out.println("interrupt가 걸렸어요!");	
			}
			gc();
		}
	}
	
	public void gc() {
		usedMemory -= 300;
		if(usedMemory < 0) {
			usedMemory = 0;
		}
		
	}
	
	public int totalMemory() {
		return MAX_MEMORY;
	}
	public int freeMemory() {
		return MAX_MEMORY - usedMemory;
	}
}


public class ThreadExam11 {
	
	public static void main(String[] args) {
		
		ThreadEx_11 t = new ThreadEx_11();
		t.setDaemon(true);
		t.start();
		
		int requiredMemory = 0;
		
		for(int i=0; i<20; i++) {
			requiredMemory = (int)(Math.random() * 10) * 20;
			
			if(t.freeMemory() < requiredMemory || 
					t.freeMemory() < t.totalMemory() * 0.4) {
				t.interrupt();
				try {
					t.join(100);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
			t.usedMemory += requiredMemory;
			System.out.println("usedMemory : " + t.usedMemory);
		}
		
	}
	
}




