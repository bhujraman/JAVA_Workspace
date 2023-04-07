
//synchronised block
package com.extra;

class ThreadEg1 {

	public synchronized void print1_5() 
	{
		System.out.println("Method started");
		synchronized(this)
		{
		
		try {
			for (int i = 1; i <= 5; i++) 
			{
				Thread.sleep(1000);
				System.out.println("i = " + i);
			}
		} 
		catch (InterruptedException e) {

			e.printStackTrace();
		
		}
		System.out.println("Method ended");
	}
	}
}
	

class ThreadExample2 extends Thread {

	ThreadEg1 t1;

	public ThreadExample2(ThreadEg1 t1) {
		this.t1 = t1;
	}

	public void run() {
		t1.print1_5();

	}

}

public class MultiThreadEgSynchroBlock {

	public static void main(String[] args) {
		System.out.println("Main started");
		ThreadEg1 t1 = new ThreadEg1();
	

		ThreadExample2 t2a = new ThreadExample2(t1);
		ThreadExample2 t2b = new ThreadExample2(t1);
		t2a.start();
		t2b.start();
		System.out.println("Main ended");
	}

}
