package sample;

class ThreadEx_10_1 extends Thread {
		
	@Override
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.print(new String("-"));
		}
	}
}

class ThreadEx_10_2 extends Thread {
	
	@Override
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.print(new String("|"));
		}
	}
}


public class ThreadExam10 {
	
	public static void main(String[] args) {
		
		Thread t1 = new ThreadEx_10_1();
		Thread t2 = new ThreadEx_10_2();
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
		} catch (Exception e) {
			
		}
		System.out.println("<< main thread 종료 >>");
	}
	
}




