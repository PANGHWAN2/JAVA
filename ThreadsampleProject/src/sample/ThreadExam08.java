package sample;

class ThreadEx_08 implements Runnable {
	//*캐시 강의안 참고하기
	volatile boolean suspended = false;	// 만약 suspend되면 이 값이 true
	volatile boolean stopped = false;	// 만약 STOP이 되면 이 값이 true

	@Override
	public void run() {
		while (!stopped) {
			if (!suspended) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000); // 현재 동작하는 Thread를 1초 재운다.
				} catch (Exception e) {

				}
			}
		}
	}
	
	public void suspend() {
		suspended = true;
		//5번라인 주석
	}
	public void stop() {
		stopped = true;
		//6번라인 주석
	}
	public void resume() {
		suspended = false;
	}
}

public class ThreadExam08 {
	public static void main(String[] args) {

		ThreadEx_08 r1 = new ThreadEx_08();
		ThreadEx_08 r2 = new ThreadEx_08();
		ThreadEx_08 r3 = new ThreadEx_08();

		Thread t1 = new Thread(r1, "*");
		Thread t2 = new Thread(r2, "**");
		Thread t3 = new Thread(r3, "***");

		t1.start();
		t2.start();
		t3.start();

		try {
			Thread.sleep(2000); // main thread
			r1.suspend(); // Thread t1을 일시중지
			Thread.sleep(2000); // main thread
			r2.suspend(); // Thread t2를 일시중지
			Thread.sleep(3000); // main thread
			r1.resume(); // Thread t1을 다시동작
			Thread.sleep(3000); // main thread
			r1.stop();
			r2.stop();
			Thread.sleep(2000);
			r3.stop();
			// 사용하기는 편리함
			// 동기화 처리에 문제가 발생 (Dead-Lock)교착상태] 인하여 더 이상 사용안함

		} catch (Exception e) {

		}
	}
}