package com.vincent.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;

import com.vincent.test.Tester;

public class SendReq implements Callable<Integer> {

	public Integer call() throws Exception {
		System.out.println("sendrequest!");
		Semaphore sema = new Semaphore(0);
		Tester.map.put("sema", sema);
		sema.acquire();
		System.out.println("accquired!");
		return 1;
	}

}
