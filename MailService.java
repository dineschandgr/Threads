package io.java.threads;

import java.util.concurrent.CompletableFuture;

import BlockingQueueDemo.LongTask;

public class MailService {
	public void send() {
		LongTask.simulate();
		System.out.println("Mail was sent.");
	}
	
	public CompletableFuture<Void> sendAsync(){
		return CompletableFuture.runAsync(() -> send());
	}
}
