package Threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerLocks {
	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue(5);
		Thread producer = new Thread( () -> {
			while(true)
				myQueue.produceMessage();
		});
		
		Thread consumer = new Thread( ()-> {
			try {
				while(true)
					myQueue.consumeMessage();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		producer.start();
		consumer.start();
	}
	
}

class MyQueue{
	
	int max = 0;
	public MyQueue(int size){
		this.max = size;
	}
	Queue<String> messageQueue = new LinkedList<String>();
	Lock lock = new ReentrantLock();
	Condition producerCondition = lock.newCondition();
	Condition consumerCondition = lock.newCondition();
	
	public void produceMessage(){
		lock.lock();
		
		try {
			if(messageQueue.size() == max){
				producerCondition.await();
			}
			messageQueue.add("message produced");
			consumerCondition.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public void consumeMessage() throws InterruptedException{
		lock.lock();
		
		try{
			if(messageQueue.size() == 0){
				consumerCondition.await();
			}
			System.out.println(messageQueue.remove());
			producerCondition.signal();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
			
	}
}

