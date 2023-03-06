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
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

//import org.example.model.Artist;
import org.example.model.Audio;
import org.example.model.SkierEvent;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;


@WebServlet(name = "skiers", value = "skiers")
public class ResourceServlet extends HttpServlet {
   
	//ConcurrentHashMap is thread safe; 
	ConcurrentHashMap<Integer, SkierEvent> skierDB;
	
	//ConcurrentHashMap<String, Audio> skierdb;
	
	//simply emulation of in memory database;
	@Override
	 public void init() throws ServletException 
	{
		// should be in post req of client in testclass
		
		skierDB = new ConcurrentHashMap<Integer, SkierEvent>();
	 }
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		//String name = request.getParameter("name");
		String id = request.getParameter("id");
		
		int ids = Integer.parseInt(id);
		
		SkierEvent ski1 = skierDB.get(ids);
		

		
		
	    Gson gson = new Gson();
	 
		PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.println("GET RESPONSE IN JSON - single element: " + gson.toJson(ski1));
     
        out.println();
        //to display all the Elements
	    JsonElement element = gson.toJsonTree(skierDB);
        out.println("GET RESPONSE IN JSON - all elements " + element.toString());
     
        out.flush();   
	
	}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
       

    	
    	PrintWriter out = response.getWriter();
        
    	Gson gson = new Gson();
    	StringBuilder sb = new StringBuilder();		
		Scanner scanner = new Scanner(request.getReader());
		while (scanner.hasNextLine()) {
		    sb.append(scanner.nextLine());
		}
		
		SkierEvent ski = gson.fromJson(sb.toString(), SkierEvent.class);
        
        JsonElement element = gson.toJsonTree(ski);
        
        out.println();
        out.println("Display SKi value from stringbuilder" + ski.getSkierId());
        
		int SkierId = ski.skierId;
		int ResortId = ski.resortId;
		int LiftId = ski.liftId;
		int SeasonId = 2022;
		int DayId = 1;
		int Time = ski.time;
		
		SkierEvent skier = new SkierEvent(SkierId,ResortId,LiftId,SeasonId,DayId,Time);
		
		if (SkierId >= 1 & SkierId <= 100000) 
		{
		    skier.setSkierId(SkierId);
		    if (ResortId >= 1 & ResortId <= 10) 
		    {
		        skier.setResortId(ResortId);
		        if (LiftId >= 1 & LiftId <= 40) 
		        {
		            skier.setLiftId(LiftId);
		            if (Time >= 1 & Time <= 360) 
		            {
		                skier.setTime(Time);
		                skier.setSeasonId(2022);
		                skier.setDayId(1);
		                skierDB.put(SkierId, skier);
		                out.println("POST RESPONSE: Skier " + SkierId + " is added to the database.");
		                response.setStatus(200);
		            }
		            else 
		            {
		            	out.println("Invalid value for time, must be between 1 and 360");
		            }
		        } 
		        else 
		        {
		        	out.println("Invalid value for liftID, must be between 1 and 10");
		        }
		    } 
		    else 
		    {
		    	out.println("Invalid value for resortID, must be between 1 and 10");
		    }
		} 
		else 
		{
		    out.println("Invalid value for skierID, must be between 1 and 100000");
		}	
		
		out.flush();
		
	}


}
