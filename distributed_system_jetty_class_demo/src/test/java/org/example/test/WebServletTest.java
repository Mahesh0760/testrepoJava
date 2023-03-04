package org.example.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
//import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
//import java.nio.charset.StandardCharsets;
import java.util.concurrent.*;


import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import jakarta.servlet.ServletException;

import org.apache.commons.io.IOUtils;

//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;

//import org.apache.commons.io.IOUtils;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.util.EntityUtils;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.HttpResponse;
//import org.eclipse.jetty.client.api.ContentProvider;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
//import org.eclipse.jetty.client.util.StringContentProvider;
//import org.eclipse.jetty.http.HttpHeader;
//import org.example.model.Artist;
import org.example.model.Audio;
import org.example.model.SkierEvent;

public class WebServletTest {
	
	
	//will have only post req

	int numThreads = 32;  // threads =32
	int numRequests = 10;  // requests = 1000
	int idleTimeout = 120;
	String url = "http://localhost:8080/artists";
	//String url = "http://155.248.224.107:8080/artists";
	
	
	//init
	// generation of lift rides
	//artistdb
	
	@SuppressWarnings("deprecation")
	@Test
	public void SKierTestMethod() throws Exception
	{
		
		Gson gson = new Gson();
		 
		
		CountDownLatch startLatch = new CountDownLatch(1);
		CountDownLatch endLatch = new CountDownLatch(numThreads);
		HttpClient client = new HttpClient();
		client.start();
		
//		ConcurrentHashMap<String, Audio> skidb = new ConcurrentHashMap<String, Audio>();
//		
//		for (int i = 1; i < numClients; i++) {
//			String Id;
//			Id = Integer.toString(i);
//			Audio audio = new Audio(Id, getRandomArtistName(), getRandomTrackTitle(), getRandomAlbumName(), i + 2,
//					i + 2000, i * 5, i * 13);
//			skidb.put(Id, audio);
//		}
		
		for (int i = 1; i < numThreads; i++) {
            new Thread(() -> {
                try {
                    // Wait for the start latch to be released
                    startLatch.await();
                    for (int j = 1; j < numRequests; j++) {
                        if (j % 1 == 0) 
                        {
                        	
                        	//Make a POST request to the server
                        	long startTime = System.currentTimeMillis();
                        	String skier = getRandomSkier();
                        	JsonElement element = gson.toJsonTree(skier);
                            System.out.println("skier event value " + element.toString());
                        	int an = sendPostRequest(skier);
//                        	Request requestpost = client.POST(url);
//	 						String skierid = Integer.toString(skier.getSkierId());
//	 						String resId = Integer.toString(skier.getResortId());
//	 						String liftid = Integer.toString(skier.getLiftId());
//	 						String season = Integer.toString(skier.getSeasonId());
//	 						String day = Integer.toString(skier.getDayId());
//	 						String time = Integer.toString(skier.getTime());
//                			requestpost.param("skierId", skierid);
//                			requestpost.param("resortId", resId);
//                			requestpost.param("liftId", liftid);
//                			requestpost.param("seasonId", season);
//                			requestpost.param("dayId", day);
//                			requestpost.param("time", time);
//                       	requestpost.path(skier);
//                			ContentResponse responsepost = requestpost.send();
	// assert response if 200 elseif(500/400) for(,5)
//                			String res = new String(responsepost.getContent());
                			long endTime = System.currentTimeMillis();
                			System.out.println(an +" "+(endTime-startTime));
                        	
                        } 
//                        else {
//                        	//Make a GET request to the server
//                        	long startTime = System.currentTimeMillis();
//                        	Request request = client.newRequest(url);
//                			request.param("name", "Adele");
//                            ContentResponse response = request.send();
//                			assertThat(response.getStatus(), equalTo(200));
//                			String responseContent = IOUtils.toString(response.getContent());
//                			long endTime = System.currentTimeMillis();
//                			System.out.println(responseContent +"  "+(endTime-startTime));
//                        }
                    }
                    // Count down the end latch to signal that the request has finished
                    endLatch.countDown();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
		
		//client.stop();
		
		
		// Release the start latch to start the requests
        startLatch.countDown();

        // Wait for all requests to finish
        endLatch.await(10, TimeUnit.SECONDS);
	}

	
	public Integer sendPostRequest(String jsonInputString) throws Exception{
		URL url = new URL("http://localhost:8080/artists");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");

        byte[] input = jsonInputString.getBytes("utf-8");
        conn.getOutputStream().write(input);
        Integer statusCode = conn.getResponseCode();
        conn.disconnect();
        return statusCode;
	}

	
	
	
	public String getRandomSkier() {
		Gson gson = new Gson();
		Random rand = new Random();
		int lowbound = 1;
		int skierID = rand.nextInt(100000-lowbound)+lowbound;
		int resortID = rand.nextInt(10-lowbound)+lowbound;
		int liftID = rand.nextInt(40-lowbound)+lowbound;
		int seasonID = 2022;
		int dayID = 1;
		int time = rand.nextInt(360-lowbound)+lowbound;
		SkierEvent sk = new SkierEvent(skierID,resortID,liftID,seasonID,dayID,time);
		return gson.toJson(sk, SkierEvent.class);
	}







//	@SuppressWarnings("deprecation")
//	@Test
//	public void testArtistsGet() throws Exception {
//		String url = "http://localhost:8080/artists";
//		HttpClient client = new HttpClient();
//		client.start();
//
////		for (int i = 1; i <= numThreads; i++) {
////			Request request = client.newRequest(url);
////			request.param("id", "45");
////			ContentResponse response = request.send();
////			assertThat(response.getStatus(), equalTo(200));
////
////			String responseContent = IOUtils.toString(response.getContent());
////			System.out.println(responseContent);
////		}
//
//		Request request = client.newRequest(url);
//		request.param("id", "id200");
//		ContentResponse response = request.send();
//
//		assertThat(response.getStatus(), equalTo(200));
//
//		String responseContent = IOUtils.toString(response.getContent());
//		System.out.println(responseContent);
//		client.stop();
//
//	}


	
	
	
	
//	@SuppressWarnings("deprecation")
//	@Test
//	public void testArtistsPost() throws Exception 
//	{
//		
//		
//		ConcurrentHashMap<String, Audio> skidb = new ConcurrentHashMap<String, Audio>();
//		
////		for(int i=1; i<50;i++)
////		{
////			String Id;
////			Id = Integer.toString(i);
////			Audio audio = new Audio(Id, getRandomArtistName(), getRandomTrackTitle(), getRandomAlbumName(), i+2, i+2000, i*5, i*13);
////			skidb.put(Id, audio);
////		}
//		
//		
//		
//		Thread thread = new Thread(){
//		    public void run(){
//		    	int i=50;
//				while(i>0)
//				{
//					String Id;
//					Id = Integer.toString(i);
//					Audio audio = new Audio(Id, getRandomArtistName(), getRandomTrackTitle(), getRandomAlbumName(), i+2, i+2000, i*5, i*13);
//					skidb.put(Id, audio);
//					i--;
//				}
//		    }
//		  };
//
//		 thread.start();
//		
//		Gson gson = new Gson();
//		//System.out.println();
//        //to display all the Elements
//	    JsonElement element = gson.toJsonTree(skidb);
//        System.out.println("GET RESPONSE IN JSON - all elements " + element.toString());
//
////		String url = "http://localhost:8080/artists";
//		HttpClient client = new HttpClient();
//		client.start();
//
//		for (int i = 1; i < 50; i++) {
//			Request request = client.POST(url);
//			String id = Integer.toString(i);
//			String name = "Mahesh"+id;
//			String title = "noname"+id;
//			request.param("id",id);
//			        request.param("name", name);
//			        request.param("title",title);
//
//			
////			request.param("id", "id203");
////			request.param("name", "artist203");
////			request.param("title", "Noname203");
//			ContentResponse response = request.send();
//			String res = new String(response.getContent());
//			System.out.println(res);
//		}

//		client.stop();

//		Request request = client.POST(url);
        
		//ClientPart1 obj = new ClientPart1();
		//Gson gson = new Gson();
		//System.out.println();
        //to display all the Elements
	    //JsonElement element = gson.toJsonTree(obj.skidb);
        //System.out.println("GET RESPONSE IN JSON - all elements " + element.toString());
		//String Id;
//		for(int j=1; j<50;j++)
//		{
//			String Id1 = Integer.toString(j);
//			//Audio audioObj = new Audio(Id, getRandomArtistName(), getRandomTrackTitle(), getRandomAlbumName(), i+2, i+2000, i*5, i*13);
//			String key = Id1;
//	        Audio audioObj = skidb.get(Id1);
//	       	String id = audioObj.getId();
//			String name = audioObj.getArtistName();
//			String title = audioObj.getAlbumTitle();
//			request.param("id",id);
//	        request.param("name", name);
//	        request.param("title",title);
//	        
//	        ContentResponse response = request.send();		
//	        String res = new String(response.getContent());
//			System.out.println(res);
//		}
//        String key = "22";
//        Audio audioObj = obj.skidb.get(key);
//       	String id = audioObj.getId();
//		String name = audioObj.getArtistName();
//		String title = audioObj.getAlbumTitle();
		
//		String id = "66";
//		String name = "mahesh";
//		String title = "No name";
//        request.param("id",id);
//        request.param("name", name);
//        request.param("title",title);
//        
//        ContentResponse response = request.send();		
//        String res = new String(response.getContent());
//		System.out.println(res);
//		client.stop();
//	}

	// @Test
	void testHelloServletGet() throws Exception {

		HttpClient client = new HttpClient();
		client.start();

		ContentResponse res = client.GET("http://155.248.224.107:8080/HelloServlet");

		System.out.println(res.getContentAsString());

		client.stop();

	}

	// @Test
	void testBlockingServletGet() throws Exception {

		HttpClient client = new HttpClient();
		client.start();

		ContentResponse res = client.GET("http://localhost:9090/coen6317/BlockingServlet");

		System.out.println(res.getContentAsString());

		client.stop();

	}

	// @Test
	void testAsyncServletGet() throws Exception {

		String url = "http://localhost:9090/coen6317/longtask";
		HttpClient client = new HttpClient();
		client.start();

		ContentResponse response = client.GET(url);

		assertThat(response.getStatus(), equalTo(200));

		String responseContent = IOUtils.toString(response.getContent());

		System.out.println(responseContent);
		// assertThat(responseContent, equalTo( "This is some heavy resource that will
		// be served in an async way"));

	}

	public String getRandomArtistName()
	{
        String[] artistNames = {"Adele", "Bruno Mars", "Coldplay", "Dua Lipa", "Ed Sheeran", "Foo Fighters",
                "Green Day", "Hozier", "Imagine Dragons", "Justin Bieber", "Katy Perry", "Lady Gaga", "Maroon 5",
                "Nirvana", "One Direction", "Pink", "Queen", "Rihanna", "Shawn Mendes", "Taylor Swift", "U2",
                "Van Halen", "Whitney Houston", "X Ambassadors", "Yellowcard", "Zara Larsson"};
        return artistNames[(int) (Math.random() * artistNames.length)];
    }

    public String getRandomTrackTitle()
    {
        String[] trackTitles = {"Hello", "Uptown Funk", "Viva La Vida", "New Rules", "Shape Of You", "Learn To Fly",
                "Basket Case", "Take Me To Church", "RadioInactive", "Sorry", "Roar", "Poker Face", "Sugar", "RadioInactive", "UpRoar", "Shape Of Me"};
        
        return trackTitles[(int) (Math.random() * trackTitles.length)];
    }
    
    public String getRandomAlbumName()
    {
    	String[] albumTitles = {"Thriller", "Sgt. Pepper's Lonely Hearts Club Band", "The Dark Side of the Moon", 
    			"Nevermind", "Purple Rain", "Abbey Road", "Kind of Blue", "Back in Black", "Hotel California", 
    			"The Joshua Tree", "Born in the U.S.A.", "Hysteria", "The Chronic", "Appetite for Destruction", 
    			"Sign o' the Times", "A Night at the Opera", "The Wall", "Rumours", "Pet Sounds", "The Queen Is Dead"};
        return albumTitles[(int) (Math.random() * albumTitles.length)];
    }
	
	//get random skier id
}
