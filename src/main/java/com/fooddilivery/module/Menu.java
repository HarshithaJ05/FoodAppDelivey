package com.fooddilivery.module;

public class Menu {
	private int menuId;
	private int restuarantId;
	private String itemName;
	private String description;
	private double price;
	private double rating;
	private boolean isAvailable;
	private String imagePath;
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public Menu(int menuId, int restuarantId, String itemName, String description, double price, double rating,
			boolean isAvailable, String imagePath) {
		super();
		this.menuId = menuId;
		this.restuarantId = restuarantId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.rating = rating;
		this.isAvailable = isAvailable;
		this.imagePath = imagePath;
	}

	public int getMenuId() {
		return menuId;
	}

	private void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getRestuarantId() {
		return restuarantId;
	}

	public void setRestuarantId(int restuarantId) {
		this.restuarantId = restuarantId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
	
	
	

}
