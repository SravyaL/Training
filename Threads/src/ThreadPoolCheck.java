import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MThread implements Runnable{
	
	String name;
	MThread(String name){
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(this.name +": has started.");
		try{
			Thread.sleep(3000);
		}catch(Exception e){
			
		}
		System.out.println(this.name+": has ended.");
	}
	
}
public class ThreadPoolCheck {
	public static void main(String[] args) {
		ExecutorService exe_serv = Executors.newFixedThreadPool(5);
		for(int i=1;i<=10;i++){
			Runnable thread = new MThread("Thread: "+i);
			exe_serv.execute(thread);
		}
		exe_serv.shutdown();
		
		while(!exe_serv.isTerminated());
		
		System.out.println("All threads are finished.");
	}
}
