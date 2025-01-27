package com.upskill.product.model;


public class ProductWrapper {
	
	private int id;
	
	private String name;
	private int discount;
	private int price;
	
	private String brand;
	private int stock;
	private String category;
	private String image;
	
	public ProductWrapper() {
		super();
	}
	public ProductWrapper(int id, String name, int discount, int price, String brand, int stock, String category,
			String image) {
		super();
		this.id = id;
		this.name = name;
		this.discount = discount;
		this.price = price;
		this.brand = brand;
		this.stock = stock;
		this.category = category;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
