package org.example.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
//import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
//import java.nio.charset.StandardCharsets;
import java.util.concurrent.*;


import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

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

public class WebServletTest {

	int numClients = 10;
	int numRequests = 200;
	int idleTimeout = 120;
	String url = "http://localhost:8080/artists";
	//String url = "http://155.248.224.107:8080/artists";
	
	@SuppressWarnings("deprecation")
	@Test
	public void AudioTestMethod() throws Exception
	{
		CountDownLatch startLatch = new CountDownLatch(1);
		CountDownLatch endLatch = new CountDownLatch(numClients);
		HttpClient client = new HttpClient();
		client.start();
		
		
		for (int i = 0; i < numClients; i++) {
            new Thread(() -> {
                try {
                    // Wait for the start latch to be released
                    startLatch.await();
                    
                    for (int j = 0; j < numRequests; j++) {
                        if (j % 6 == 0) {
                        	//Make a POST request to the server
                        	long startTime = System.currentTimeMillis();  
                        	Request requestpost = client.POST(url);
                			requestpost.param("id", "111");
                			requestpost.param("name", "Sidhu Moosewala");
                			requestpost.param("title", "LastRide1");
                			ContentResponse responsepost = requestpost.send();
                			String res = new String(responsepost.getContent());
                			long endTime = System.currentTimeMillis();
                			System.out.println(res +" "+(endTime-startTime));
                        	
                        } else {
                        	//Make a GET request to the server
                        	long startTime = System.currentTimeMillis();
                        	Request request = client.newRequest(url);
                			request.param("name", "Adele");
                            ContentResponse response = request.send();
                			assertThat(response.getStatus(), equalTo(200));
                			String responseContent = IOUtils.toString(response.getContent());
                			long endTime = System.currentTimeMillis();
                			System.out.println(responseContent +"  "+(endTime-startTime));
                        }
                    }
                    // Count down the end latch to signal that the request has finished
                    endLatch.countDown();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
		
		
		// Release the start latch to start the requests
        startLatch.countDown();

        // Wait for all requests to finish
        endLatch.await(10, TimeUnit.SECONDS);
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
//	public void testArtistsPost() throws Exception {
//
//		String url = "http://localhost:8080/artists";
//		HttpClient client = new HttpClient();
//		client.start();
//
//		for (int i = 1; i < numThreads; i++) {
//			Request request = client.POST(url);
//			request.param("id", "id203");
//			request.param("name", "artist203");
//			request.param("title", "Noname203");
//			ContentResponse response = request.send();
//			String res = new String(response.getContent());
//			System.out.println(res);
//		}
//
//		client.stop();
//
////       Request request = client.POST(url);
////        
////        request.param("id","id200");
////        request.param("name","artist200");
////        request.param("title","Noname");
////        
////        ContentResponse response = request.send();		
////        String res = new String(response.getContent());
////		System.out.println(res);
////		client.stop();
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

}
