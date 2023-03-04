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

		
		

	