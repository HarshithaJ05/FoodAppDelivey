package com.fooddilivery.module;

public class Restaurant {

	private int resturantId;
	private String Name;
	private String adress;
	private long phoneNum;
	private double rating;
	private String cousineType;
	private String isActive;
	private int eta;
	private int admineId;
	private String imagePath;
	
	
	public Restaurant() {
		// TODO Auto-generated constructor stub
	}


	public Restaurant(int resturantId, String name, String adress, long phoneNum, double rating, String cousineType,
			String isActive, int eta, int admineId, String imagePath) {
		super();
		this.resturantId = resturantId;
		Name = name;
		this.adress = adress;
		this.phoneNum = phoneNum;
		this.rating = rating;
		this.cousineType = cousineType;
		this.isActive = isActive;
		this.eta = eta;
		this.admineId = admineId;
		this.imagePath = imagePath;
	}


	public int getResturantId() {
		return resturantId;
	}


	private void setResturantId(int resturantId) {
		this.resturantId = resturantId;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public long getPhoneNum() {
		return phoneNum;
	}


	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}


	public String getCousineType() {
		return cousineType;
	}


	public void setCousineType(String cousineType) {
		this.cousineType = cousineType;
	}


	public String getIsActive() {
		return isActive;
	}


	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}


	public int getEta() {
		return eta;
	}


	public void setEta(int eta) {
		this.eta = eta;
	}


	public int getAdmineId() {
		return admineId;
	}


	public void setAdmineId(int admineId) {
		this.admineId = admineId;
	}


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
	
	
	
	
}
