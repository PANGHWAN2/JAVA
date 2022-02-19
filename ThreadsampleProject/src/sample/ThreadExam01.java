package sample;


class ThreadEx_01_1 extends Thread{
	
	public ThreadEx_01_1(String name) {
		this.setName(name);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < 5; i++) {
			System.out.println(getName());
			//getName() => Thread의 이름을 가져와요!
		}
		
	}
}

class ThreadEx_01_2 implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < 5; i++) {
			System.out.println(Thread.currentThread().getName()); //getName을 쓰지는 못한다. 쓰레드가 가지고있음 Runnable인터페이스를 구현한 클래스
		}												//현재 실행중인 쓰레드를 찾아오세요
	}
}

public class ThreadExam01 {
	public static void main(String[] args) {
		ThreadEx_01_1 t1 = new ThreadEx_01_1("Thread-0번"); //Thread 객체를 생성
		
		ThreadEx_01_2 r = new ThreadEx_01_2();	//Runnable interface를 
												//구현한 객체
		Thread t2 = new Thread(r,"Thread-1번");				//t2가 Thread
		
		// Thread 객체가 2마리 만들어졌어요! 객체가 만들어 졌다고 해서 바로 실행되는건
		// 아니에요!
		// 이 Thread를 실행시키려면(run() 이 수행되려면??)
//		t1.run();	// Thread를 실행시키는게 아니예요!	이건 단지 객체가 가지는
					// method를 호출하는 거예요!
					// Thread는 이렇게 실행시키지 않아요!
		t1.start(); // Thread를 실행시키는 method
		t2.start();
	}
}
