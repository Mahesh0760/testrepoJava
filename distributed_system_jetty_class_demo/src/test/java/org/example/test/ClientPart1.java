//import java.util.concurrent.TimeUnit;
//
//import com.google.gson.JsonElement;

/*
 * package org.example.test;
 * 
 * import java.util.concurrent.ConcurrentHashMap; import
 * java.util.concurrent.CountDownLatch;
 * 
 * import org.eclipse.jetty.client.HttpClient; import
 * org.eclipse.jetty.client.api.ContentResponse; import
 * org.eclipse.jetty.client.api.Request; import org.example.model.Audio; import
 * org.junit.jupiter.api.Test;
 * 
 * import com.google.gson.Gson; import com.google.gson.JsonElement;
 * 
 * public class ClientPart1 { int numClients = 10; // threads =32 int
 * numRequests = 10; // requests = 1000 int idleTimeout = 120;
 * 
 * ConcurrentHashMap<String, Audio> skidb;
 * 
 * @SuppressWarnings("deprecation")
 * 
 * @Test public void testArtistsPost1() throws Exception { CountDownLatch
 * startLatch = new CountDownLatch(1); CountDownLatch endLatch = new
 * CountDownLatch(numClients);
 * 
 * // skidb = new ConcurrentHashMap<String, Audio>(); // String Id; // for(int
 * i=1; i<=numClients;i++) // { // Id = Integer.toString(i); // Audio audio =
 * new Audio(Id, getRandomArtistName(), getRandomTrackTitle(),
 * getRandomAlbumName(), i+2, i+2000, i*5, i*13); // skidb.put(Id, audio); // }
 * // // Gson gson = new Gson(); // //System.out.println(); // //to display all
 * the Elements // JsonElement element = gson.toJsonTree(skidb); //
 * System.out.println("GET RESPONSE IN JSON - all elements " +
 * element.toString());
 * 
 * String url = "http://localhost:8080/artists"; HttpClient client = new
 * HttpClient(); client.start();
 * 
 * for (int i = 1; i < numClients; i++) { new Thread(() -> { try { // Wait for
 * the start latch to be released startLatch.await(); for (int j = 1; j <
 * numRequests; j++) { if (j < numRequests) { //Make a POST request to the
 * server long startTime = System.currentTimeMillis(); // String ID =
 * Integer.toString(j); // Audio obj = skidb.get(ID); Request requestpost =
 * client.POST(url); // String id = obj.getId(); // String name =
 * obj.getArtistName(); // String title = obj.getTrackTitle();
 * 
 * String id = Integer.toString(j); String name = getRandomArtistName(); String
 * title = getRandomTrackTitle(); requestpost.param("id", id);
 * requestpost.param("name", name); requestpost.param("title", title);
 * ContentResponse responsepost = requestpost.send(); // assert response if 200
 * elseif(500/400) for(,5) String res = new String(responsepost.getContent());
 * long endTime = System.currentTimeMillis(); System.out.println(res
 * +" "+(endTime-startTime));
 * 
 * } } // Count down the end latch to signal that the request has finished
 * endLatch.countDown(); } catch (Exception e) { throw new RuntimeException(e);
 * } }).start(); }
 * 
 * client.stop(); // // Request request = client.POST(url); // //
 * request.param("id","id200"); // request.param("name","artist200"); //
 * request.param("title","Noname"); // // ContentResponse response =
 * request.send(); // String res = new String(response.getContent()); //
 * System.out.println(res); // client.stop(); }
 * 
 * 
 * public String getRandomArtistName() { String[] artistNames = {"Adele",
 * "Bruno Mars", "Coldplay", "Dua Lipa", "Ed Sheeran", "Foo Fighters",
 * "Green Day", "Hozier", "Imagine Dragons", "Justin Bieber", "Katy Perry",
 * "Lady Gaga", "Maroon 5", "Nirvana", "One Direction", "Pink", "Queen",
 * "Rihanna", "Shawn Mendes", "Taylor Swift", "U2", "Van Halen",
 * "Whitney Houston", "X Ambassadors", "Yellowcard", "Zara Larsson"}; return
 * artistNames[(int) (Math.random() * artistNames.length)]; }
 * 
 * public String getRandomTrackTitle() { String[] trackTitles = {"Hello",
 * "Uptown Funk", "Viva La Vida", "New Rules", "Shape Of You", "Learn To Fly",
 * "Basket Case", "Take Me To Church", "RadioInactive", "Sorry", "Roar",
 * "Poker Face", "Sugar", "RadioInactive", "UpRoar", "Shape Of Me"};
 * 
 * return trackTitles[(int) (Math.random() * trackTitles.length)]; }
 * 
 * public String getRandomAlbumName() { String[] albumTitles = {"Thriller",
 * "Sgt. Pepper's Lonely Hearts Club Band", "The Dark Side of the Moon",
 * "Nevermind", "Purple Rain", "Abbey Road", "Kind of Blue", "Back in Black",
 * "Hotel California", "The Joshua Tree", "Born in the U.S.A.", "Hysteria",
 * "The Chronic", "Appetite for Destruction", "Sign o' the Times",
 * "A Night at the Opera", "The Wall", "Rumours", "Pet Sounds",
 * "The Queen Is Dead"}; return albumTitles[(int) (Math.random() *
 * albumTitles.length)]; } }
 */

//skierDB.put(SkierId, ski);
//response.setStatus(200);
//	String skierId = request.getParameter("skierId");
//  String resortId = request.getParameter("resortId");
//  String liftId = request.getParameter("lift");
//  String seasonId = request.getParameter("seasonId");
//  String dayId = request.getParameter("dayId");
//  String time = request.getParameter("time");
    
//  ski.setSkierId(SkierId);
//  ski.setResortId(ResortId);
//  ski.setLiftId(LiftId);
//  ski.setSeasonId(SeasonId);
//  ski.setDayId(DayId);
//  ski.setTime(Time);
    
//  int SkierId = Integer.parseInt(skierId);
//  int ResortId = Integer.parseInt(resortId);
//  int LiftId = Integer.parseInt(liftId);
//  int SeasonId = Integer.parseInt(seasonId);
//  int DayId = Integer.parseInt(dayId);
//  int Time = Integer.parseInt(time);

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


//		ConcurrentHashMap<String, Audio> skidb = new ConcurrentHashMap<String, Audio>();
//		
//		for (int i = 1; i < numClients; i++) {
//			String Id;
//			Id = Integer.toString(i);
//			Audio audio = new Audio(Id, getRandomArtistName(), getRandomTrackTitle(), getRandomAlbumName(), i + 2,
//					i + 2000, i * 5, i * 13);
//			skidb.put(Id, audio);
//		}

//for (i = 1; i < numThreads; i++) {
//            new Thread(() -> {
//                try {
//                    // Wait for the start latch to be released
//                    startLatch.await();
//                    
//                    for (j = 1; j < numRequests; j++) 
//                    {
//                    	//Make a POST request to the server
//                    	long startTime = System.currentTimeMillis();
//                    	String skier = getRandomSkier();
//                    	JsonElement element = gson.toJsonTree(skier);
//                        System.out.println("skier event value " + element.toString());
//                    	int an = sendPostRequest(skier);
//                    	
//                    	if(an == 200)
//                    	{
//                    		SuccessReq++;
//                    	}
//            			long endTime = System.currentTimeMillis();
//            			System.out.println(an +" "+(endTime-startTime)); 
//            			
//            			if(i*j == 10000) 
//            			{
//            				
//            			}
//                    }
//                    
//                    // Count down the end latch to signal that the request has finished
//                    endLatch.countDown();
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//            }).start();
//        }
//		
//		
//		// Release the start latch to start the requests
//        startLatch.countDown();
//
//        // Wait for all requests to finish
//        endLatch.await(10, TimeUnit.SECONDS);
//	}





//    private static final String POST_URL = "http://localhost:8080/SkiResorts_war_exploded/skiers";
//    private static final int NUM_THREADS = 32;
//    private static final int NUM_POSTS_PER_THREAD = 1000;
//    private static final int TOTAL_POSTS = NUM_THREADS * NUM_POSTS_PER_THREAD;
//    private static final int NUM_RETRIES = 5;
//
//    private static volatile int successfulRequests = 0;
//    private static volatile int failedRequests = 0;

//    public static void main(String[] args) throws InterruptedException, ExecutionException {
//
//        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
//        CountDownLatch startSignal = new CountDownLatch(1);
//        CountDownLatch endSignal = new CountDownLatch(NUM_THREADS);
//
//        List<Future<?>> futures = new ArrayList<>();
//
//        for (int i = 0; i < NUM_THREADS; i++) {
//            futures.add(executor.submit(new PostingThread(startSignal, endSignal, NUM_POSTS_PER_THREAD)));
//        }
//
//        System.out.println("Waiting for all threads to start...");
//        startSignal.countDown();
//        endSignal.await();
//        System.out.println("All threads have finished!");
//
//        executor.shutdown();
//
//        System.out.println("Successful requests: " + successfulRequests);
//        System.out.println("Failed requests: " + failedRequests);
//    }
//
//    static class PostingThread implements Runnable {
//
//        private final CountDownLatch startSignal;
//        private final CountDownLatch endSignal;
//        private final int numPosts;
//
//        public PostingThread(CountDownLatch startSignal, CountDownLatch endSignal, int numPosts) {
//            this.startSignal = startSignal;
//            this.endSignal = endSignal;
//            this.numPosts = numPosts;
//        }
//
//        @Override
//        public void run() {
//            try {
//                startSignal.await();
//                for (int i = 0; i < numPosts; i++) {
//                    int statusCode = sendPostRequest();
//                    int retries = 0;
//                    while (statusCode >= 500 && retries < NUM_RETRIES) {
//                        System.out.println("Retrying request " + i + " on thread " + Thread.currentThread().getId() +
//                                " due to status code " + statusCode);
//                        statusCode = sendPostRequest();
//                        retries++;
//                    }
//                    if (statusCode == 201) {
//                        successfulRequests++;
//                    } else {
//                        failedRequests++;
//                    }
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                endSignal.countDown();
//            }
//        }
//
//        private int sendPostRequest() {
//            int statusCode = -1;
//            try {
//                URL url = new URL(POST_URL);
//                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                conn.setDoOutput(true);
//                conn.setRequestMethod("POST");
//                conn.setRequestProperty("Content-Type", "application/json");
//
//                String jsonInputString = LiftRide.generateRandomLiftRideJson(10000,40,360,10);
//                byte[] input = jsonInputString.getBytes("utf-8");
//                conn.getOutputStream().write(input);
//
//                statusCode = conn.getResponseCode();
//                conn.disconnect();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return statusCode;
//        }
//    }
//}

		
		

	