package sample;

class ThreadEx_05_1 extends Thread{

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			// sleep은 static method
			// sleep은 현재 실행중인 Thread를 재우는 기능
			// instance를 이용해서 사용하지 않는다.
		} catch (Exception e) {
			
		}
		for(int i = 0 ; i < 300; i++) {
			System.out.print("-");
		}
		System.out.println("<< Thread 1 종료 >>");
	}
}

class ThreadEx_05_2 extends Thread{

	@Override
	public void run() {
		for(int i = 0 ; i < 300; i++) {
			System.out.print("|");
		}
		System.out.println("<< Thread 2 종료 >>");
	}
}

public class ThreadExam05 {
	public static void main(String[] args) {
		Thread t1 = new ThreadEx_05_1();
		Thread t2 = new ThreadEx_05_2();
		
		t1.start();
		t2.start();
		  
		/*
		try {
			Thread.sleep(2000);
			// sleep은 static method
			// sleep은 현재 실행중인 Thread를 재우는 기능
			// instance를 이용해서 사용하지 않는다.
		} catch (Exception e) {
			
		}
		*/
		System.out.println("<< main thread 종료 >>");
	}
}