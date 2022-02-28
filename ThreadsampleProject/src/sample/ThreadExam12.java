package sample;

// 공용데이터 instance를 만들기 위한 class를 작성
class Account {
	
	private int balance = 1000; // 잔액
	
	public int getBalance() {
		return balance;
	}
	
	// method자체가 임계영역(Critical Section)으로 설정
//	public synchronized void withdraw(int money) {
//		if(balance >= money) {
//			try {
//				Thread.sleep(1000);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//			balance -= money;   // 출금처리
//		}
//	}

	public void withdraw(int money) {
		// 동기화 블럭(synchronized block) => 임계영역 설정
		synchronized (this) {
			if(balance >= money) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				balance -= money;   // 출금처리
			}	
		}
	}
	
}



class ThreadEx_12 implements Runnable {
	
		Account acc = new Account();   // 공용객체
		
		@Override
		public void run() {
			while(acc.getBalance() > 0) {
				int money = (int)(Math.random() * 3 + 1) * 100;
				acc.withdraw(money);
				System.out.println("balance : " + acc.getBalance());
			}
			
		}
}


public class ThreadExam12 {
	
	public static void main(String[] args) {
		
		// runnable interface를 구현한 class의 객체
		ThreadEx_12 r = new ThreadEx_12(); 
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
		
	}
	
}




