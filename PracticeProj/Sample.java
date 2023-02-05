import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.lang.*;
import java.time.Instant;
import java.io.*;

/**
 * @author MAHESHREDDY
 *
 */
public class Sample{

//	public void run()
//	{
//		System.out.println("Thread1 is running");
//	}
    
	
	public static void main(String[] args)
	{
		ExecutorService executor = Executors.newFixedThreadPool(5);
//		Runnable rough = new Rough();
		Instant obj = Instant.now();
//		System.out.println(obj);
		
		for(int i=0; i<5; i++)
		{
			//Thread t = new Thread(rough);
			
			executor.execute(() -> {
				System.out.println(Thread.currentThread().getName()+ obj);
				
				try {
					Thread.sleep(50000L);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}
		executor.shutdown();
	}

}
