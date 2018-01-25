package com.example.week9text;

public class Student {
	String id=null;
	String name=null;
	String building=null;
	String floor=null;
	String room=null;
	String pic=null;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = new String(id);
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = new String(name);
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = new String(building);
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = new String(floor);
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = new String(room);
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = new String(pic);
	}
	public Student(String id, String name, String building, String floor,
			String room, String pic) {
		super();
		this.id = new String(id);
		this.name = new String(name);
		this.building = new String(building);
		this.floor = new String(floor);
		this.room =new String(room);
		this.pic = new String(pic);
	}
}
