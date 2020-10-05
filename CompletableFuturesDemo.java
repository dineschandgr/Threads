package io.java.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFuturesDemo {
	public static void main(String[] args) {
		show();
	}
	
	public static void show() {
		//ForkJoinPool.commonPool()
		//Runnable task = () -> System.out.println("test");
		Supplier<Integer> task = () -> 1;
		var future = CompletableFuture.supplyAsync(task);
		//future.thenRun(() -> System.out.println("done"));
		future.thenAcceptAsync((result) -> {
			System.out.println(Thread.currentThread().getName());
			System.out.println("Done");
			System.out.println(result);
		});
		try {
			future.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
