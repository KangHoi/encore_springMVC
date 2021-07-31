package com.encore.spring.domain;

//vo이름은 테이블명과 동일하게.. 인식알될까싶어 카멜케이스안썼음.. 하지만 쓰는게 맞다.
public class MyProduct {
	// 필드명은 컬럼명과 동일... 
	private int id;
	private String name;
	private String maker;
	private int price;
	
	//기본생성자
	public MyProduct() {}
	
	
	//auto-increment있음
	public MyProduct(int id, String name, String maker, int price) {
		super();
		this.id = id;
		this.name = name;
		this.maker = maker;
		this.price = price;
	}

	//auto-increment없음
	public MyProduct(String name, String maker, int price) {
		super();
		this.name = name;
		this.maker = maker;
		this.price = price;
	}



	//setter, getter
	
	
	public String getName() {
		return name;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getMaker() {
		return maker;
	}



	public void setMaker(String maker) {
		this.maker = maker;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}

	
	//toString
	
	@Override
	public String toString() {
		return "MyProduct [id=" + id + ", name=" + name + ", maker=" + maker + ", price=" + price + "]";
	}


	
	
	}
