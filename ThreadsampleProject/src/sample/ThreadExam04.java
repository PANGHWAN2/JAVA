package sample;

//interface는 내부에 메소드가 정의되어 있는데 모두 다 abstract method로
//정의되어 있어요. => method의 내부구현이 몽땅 비어있어요!
//메소드의 구현이 안되어 있기 때문에 당연히 인터페이스부터 인스턴스를 만들 수
//없어요!

public class ThreadExam04 implements Runnable {

	static boolean autoSave = false;

	public static void main(String[] args) {

		ThreadExam04 r = new ThreadExam04();
		Thread t = new Thread(r);

		t.setDaemon(true);	// daemon thread로 변경
						    // 자기를 파생시킨 유저쓰레드가 죽으면 데몬쓰레드도 자동으로 죽음
		
		t.start();

		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000); // 1초 동안 main thread가 자요!
			} catch (Exception e) {

			}
			System.out.println(i);

			if (i == 5) {
				autoSave = true;
			}
		}
	}

	@Override
	public void run() {
		// 무한루프.
		while (true) {
			try {
				Thread.sleep(3000); // 3초간 자요!
			} catch (Exception e) {

			}
			if (autoSave) {
				System.out.println("자동저장되었어요!");
			}
		}
	}
}
