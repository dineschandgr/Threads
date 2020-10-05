package io.java.threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<E> {
	private Queue<E> queue;
	private int max = 10;
	private ReentrantLock lock = new ReentrantLock(); 
	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();
	
	public BlockingQueue(int size) {
		queue = new LinkedList<>();
		this.max = size;
	}
	
	// when queue size has reaches max capacity, then the lock is released by thread
	// and thread goes to wait state on the notFull condition
	public void put(E e) {
		lock.lock();
		try {
			if(queue.size() == max)
				notFull.await();
			queue.add(e);	
			notEmpty.signal();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}finally {
			lock.unlock();
		}
		
	}
	
	// when queue size has reaches 0 capacity, then the lock is released by thread
	// and thread goes to wait state on the notEmpty condition
	public E take() {
		lock.lock();
		E element = null;
		try {
			while(queue.size() == 0)
				notEmpty.await();
			element = queue.remove();
			notFull.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		return element;
	}
}
