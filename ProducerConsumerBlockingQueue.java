package Threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBlockingQueue {
	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);
		Thread t1 = new Thread(()-> {
			while(true)
				try {
					queue.put("produce");
				} catch (Exception e) {
					e.printStackTrace();
				}
		});
		
		Thread t2 = new Thread(()-> {
			while(true)
				try {
					System.out.println(queue.take());
				} catch (Exception e) {
					e.printStackTrace();
				}
		});
		
		t1.start();
		t2.start();
	}
	
	
	
}
