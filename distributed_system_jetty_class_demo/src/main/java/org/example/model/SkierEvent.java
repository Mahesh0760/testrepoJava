package org.example.model;

public class SkierEvent 
{
	public int skierId;
	public int resortId;
	public int liftId;
	public int seasonId;
	public int dayId;
	public int time;
	
	
//	public SkierEvent()
//	{
//		//Empty Constructor
//	}
	
	
	public SkierEvent(int skierId, int resortId, int liftId, int seasonId, int dayId, int time) {
		super();
		this.skierId = skierId;
		this.resortId = resortId;
		this.liftId = liftId;
		this.seasonId = seasonId;
		this.dayId = dayId;
		this.time = time;
	}
	public SkierEvent() {
		// TODO Auto-generated constructor stub
	}
	public int getSkierId() {
		return skierId;
	}
	public void setSkierId(int skierId) {
		this.skierId = skierId;
	}
	public int getResortId() {
		return resortId;
	}
	public void setResortId(int resortId) {
		this.resortId = resortId;
	}
	public int getLiftId() {
		return liftId;
	}
	public void setLiftId(int liftId) {
		this.liftId = liftId;
	}
	public int getSeasonId() {
		return seasonId;
	}
	public void setSeasonId(int seasonId) {
		this.seasonId = seasonId;
	}
	public int getDayId() {
		return dayId;
	}
	public void setDayId(int dayId) {
		this.dayId = dayId;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
}
