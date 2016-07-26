package com.vincent.test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.vincent.thread.ReturnThread;
import com.vincent.thread.SendReq;

public class Tester {
	public static ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object>();
	public static void main(String[] args) {
//		ExecutorService executor = Executors.newCachedThreadPool();
		SendReq sendReq = new SendReq();
		FutureTask<Integer> task = new FutureTask<Integer>(sendReq);
//		executor.execute(task);
		new Thread(task).start();
		new Thread(new ReturnThread()).start();
		try {
			task.get(20, TimeUnit.SECONDS);
			System.out.println("main finish!");
		} catch (InterruptedException e) {
			e.printStackTrace();
//			task.
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

}
