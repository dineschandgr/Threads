package io.java.threads;

public class BlockingQueueDemo {

	public static void main(String[] args) {
		BlockingQueue<String> queue = new BlockingQueue<>(5);
		Runnable producer = () -> {
			while(true)
				queue.put("put data "+Thread.currentThread().getName());
		};
		
		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(producer);
		t1.start();
		t2.start();
		
		Runnable consumer = () -> {
			while(true)
				System.out.println(queue.take());
		};
		
		Thread t3 = new Thread(consumer);
		Thread t4 = new Thread(consumer);
		t3.start();
		t4.start();
	}

}
