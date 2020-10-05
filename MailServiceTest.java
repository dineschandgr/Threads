package io.java.threads;

public class MailServiceTest {
	public static void main(String[] args) {
		var service = new MailService();
		var future = service.sendAsync();
		System.out.println("future "+future);
		System.out.println("Hello World ");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("future "+future);
	}
}
