package sample;


class ThreadEx_03 extends Thread {
	
	public ThreadEx_03(String name) {
		this.setName(name);
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(getName());
			// getName() => Thread의 이름을 가져와요!
		}
	}
}

 
public class ThreadExam03 {
	
	public static void main(String[] args) {
		
		ThreadEx_03 t1 = new ThreadEx_03("Thread-0번");  
		ThreadEx_03 t2 = new ThreadEx_03("Thread-1번");
		
		t1.setPriority(1);
		t2.setPriority(9);
		
		t1.start();
		t2.start();
	}
	
}
