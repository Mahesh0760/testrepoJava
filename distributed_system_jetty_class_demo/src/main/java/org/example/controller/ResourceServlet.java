package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//import org.example.model.Artist;
import org.example.model.Audio;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;


@WebServlet(name = "artists", value = "artists")
public class ResourceServlet extends HttpServlet {
    
	

	
	//ConcurrentHashMap is thread safe; 
	
	ConcurrentHashMap<String, Audio> artistDB;

	
	
	//simply emulation of in memory database;
	@Override
	 public void init() throws ServletException 
	{
		artistDB = new ConcurrentHashMap<String, Audio>();
		String Id;
		for(int i=1; i<=100;i++)
		{
			Id = Integer.toString(i);
			Audio audio = new Audio(Id, getRandomArtistName(), getRandomTrackTitle(), getRandomAlbumName(), i+2, i+2000, i*5, i*13);
			artistDB.put(Id, audio);
		}
	 }
	
	
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String id = request.getParameter("id");
		String propName = request.getParameter("property");
		
		
		
		
		String aname = null;
		String atitle = null;
		Audio result = new Audio(id, aname, atitle);
		result.setId(id);
		result.setArtistName(artistDB.get(id).getArtistName());
		result.setTrackTitle(artistDB.get(id).getTrackTitle());
		
	    Gson gson = new Gson();
	 
		PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.println("GET RESPONSE IN JSON - single element: " + gson.toJson(result));
        
      //to display all the Elements
	    JsonElement element = gson.toJsonTree(artistDB);
        out.println("GET RESPONSE IN JSON - all elements " + element.toString());
     
        out.flush();   
	
	}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	String id = request.getParameter("id");
        String name = request.getParameter("name");
        String title = request.getParameter("title");
        
        Audio audioInp = new Audio(id, name, title);
        
        audioInp.setId(id);
        audioInp.setArtistName(name);
        audioInp.setAlbumTitle(title);
        
        artistDB.put(id, audioInp);
        response.setStatus(200);
    	
    	response.getOutputStream().println("POST RESPONSE: Artist " + name + " is added to the database.");
    }
	
	
    //Methods to generate random values for audio item in audioDB.
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
}
