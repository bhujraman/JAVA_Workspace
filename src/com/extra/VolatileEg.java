package com.extra;

public class VolatileEg {
     public static int flag = 0;
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					if(flag == 0){
						System.out.println("Running");
					}else{
						break;
					}
				}	
			}
		}).start();
		
        new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				VolatileEg.flag = 1; 
				System.out.println("Flag value updated");
			}
		}).start();
	}

}
