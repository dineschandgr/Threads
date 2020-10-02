package Threads;

class MyTask extends Thread{
	@Override
	public void run() {
		for(int i = 0;i< 10;i++)
			System.out.println("Printer 1=============");
		
	}
}

class Printer{
	void printDocuments(int noOfCopies, String docName){
		for(int i = 0; i < noOfCopies; i++)
			System.out.println(">> Printing "+docName);
	}
}

class MyThread implements Runnable{

	Printer pRef;
	
	MyThread(Printer p){
		pRef = p;
	}
	
	@Override
	public void run() {
		
			pRef.printDocuments(10,"DC.pdf");
	}
}

class YourThread implements Runnable{

	Printer pRef;
	
	YourThread(Printer p){
		pRef = p;
	}
	
	@Override
	public void run() {
		
			pRef.printDocuments(10,"MS.pdf");
	}
}

public class ThreadDemoRunnable{
	public static void main(String[] args) {
		//job1
		System.out.println("==Application started==");
		
		/*Runnable r = new MyTask1();
		Thread t1 = new Thread(r);
		t1.start();*/
		MyTask task1 = new MyTask();
		task1.start();
		
		//Thread t2 = new Thread(() -> System.out.println("thread t2"));
		//t2.start();
		Printer pRef = new Printer();
		Runnable runnable = new MyThread(pRef);
		Thread t1 = new Thread(runnable);
		t1.start();
		
		runnable = new YourThread(pRef);
		Thread t2 = new Thread(runnable);
		t2.start();
		
		//job3
		for(int i = 0;i< 10;i++)
			System.out.println("Printer 2***************");
		
		System.out.println("Job finished *-*-*-*-*-*-");
	}


	
}
