package com.vincent.thread;

import java.util.concurrent.Semaphore;

import com.vincent.test.Tester;

public class ReturnThread implements Runnable {

	public void run() {
		System.out.println("return call!");
		Semaphore sema = (Semaphore) Tester.map.get("sema");
		if (sema != null)
			sema.release();
		System.out.println("return finish!");
	}

}
