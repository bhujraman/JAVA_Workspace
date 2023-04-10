package com.dal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LambdaEg {

	public static void main(String[] args) {
		//Java 7 syntax 1 without thread
//		Task task = new Task();
//		task.connect();
//		
		//Java 7 syntax 2 with thread
//		Runnable r = new MyTaskThread();
//		Thread thread =new Thread(r);
//		thread.start();
		
//		//Java 7 Syntax 3 anonymous way
//		Runnable r = new Runnable() {
//			@Override
//			public void run() {
//				Task task = new Task();
//				task.connect();
//
//			}
//		};
//		Thread t1 = new Thread(r);
//		t1.start();
//	}
	//}
	//}
	
//	//Java 8 Syntax 1
//	Runnable r1 = () -> {
//		Task task = new  Task();
//		task.connect();
//		
//	};
//	Thread t1 = new Thread(r1);
//	t1.start();
	
		//Java 8 Syntax 2
//		
//		Thread th1 = new Thread(() ->{
//			Task task = new Task();
//			task.connect();});
//		th1.start();
		
//		//Java 8 Syntax 3
//		new Thread(()-> {new Task().connect();}).start();
//		
//		//Java 8 Syntax 4 Method reference
//		new Thread(new Task()::connect).start();
		
		User u1 = new User(11,"Bhuvana","jbh@gmail.com");
		User u2 = new User(12,"Meena","meena@gmail.com");
		User u3 = new User(13,"Adi","adi@gmail.com");
		
		
		List<User> l1 = new ArrayList<User>();
		l1.add(u1);
		l1.add(u2);
		l1.add(u3);
		System.out.println("User List:" + l1);
		
//		Iterator<User> i = l1.iterator();
//		while(i.hasNext()) {
//			System.out.println(i.next());
//		}
//	
		//l1.forEach(lis->System.out.println(lis));
		l1.forEach(System.out::println); 
}
}

