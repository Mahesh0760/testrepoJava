package org.example.model;

public class Audio 
{
	
	//properties for Audio Item
	private String Id;
	private String ArtistName;
	private String TrackTitle;
	private String AlbumTitle;
	private int TrackNumber;
	private int Year;
	private int NumOfReviews;
	private int NumOfCopiesSold;
	
	
	public Audio()
	{
		//Empty Constructor
	}
	
	public Audio(String Id, String ArtistName, String TrackTitle)
	{
		//Constructor with 3 properties
		this.Id = Id;
		this.ArtistName = ArtistName;
		this.TrackTitle = TrackTitle;
	}
	
	public Audio(String Id, String ArtistName, String TrackTitle, String AlbumTitle, int TrackNumber, int Year, int NumOfReviews, int NumOfCopiesSold)
	{
		this.Id = Id;
		this.ArtistName = ArtistName;
		this.TrackTitle = TrackTitle;
		this.AlbumTitle = AlbumTitle;
		this.TrackNumber = TrackNumber;
		this.Year = Year;
		this.NumOfReviews = NumOfReviews;
		this.NumOfCopiesSold = NumOfCopiesSold;
	}
	
	public String getId()
	{
		return Id;
	}
	public void setId(String Id)
	{
		this.Id = Id;
	}
	
	public String getArtistName()
	{
		return ArtistName;
	}
	public void setArtistName(String ArtistName)
	{
		this.ArtistName = ArtistName;
	}
	
	public String getTrackTitle()
	{
		return TrackTitle;
	}
	public void setTrackTitle(String TrackTitle)
	{
		this.TrackTitle = TrackTitle;
	}
	
	public String getAlbumTitle()
	{
		return AlbumTitle;
	}
	public void setAlbumTitle(String AlbumTitle)
	{
		this.AlbumTitle = AlbumTitle;
	}
	
	public int getTrackNumber()
	{
		return TrackNumber;
	}
	public void setTrackNumber(int TrackNumber)
	{
		this.TrackNumber = TrackNumber;
	}
	
	public int getYear()
	{
		return Year;
	}
	public void setYear(int Year)
	{
		this.Year = Year;
	}
	
	public int getNumOfReviews()
	{
		return NumOfReviews;
	}
	public void setNumOfReviews(int NumOfReviews)
	{
		this.NumOfReviews = NumOfReviews;
	}
	
	public int getNumOfCopiesSold()
	{
		return NumOfCopiesSold;
	}
	public void setNumOfCopiesSold(int NumOfCopiesSold)
	{
		this.NumOfCopiesSold = NumOfCopiesSold;
	}
}
