package Threads;

import java.util.ArrayList;
import java.util.List;

public class ThreadDemo{
	public static void main(String[] args) {
		
		List<Thread> threads = new ArrayList<>();
		List<DownloadFileTask> tasks = new ArrayList<>();
		for(int i = 0; i < 10; i++){
			DownloadFileTask task = 
			Thread thread = new Thread(new DownloadFileTask());
			thread.start();
			threads.add(thread);
		}
		
		for(Thread thread : threads){
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("total bytes "+status.getTotalBytes());
	}
	
	public void run(){
		System.out.println("running thread");
	}
}
