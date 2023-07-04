package com.ExcelProd.entity;

import jakarta.persistence.*;

@Entity
@Table(name="ExcelTable")
public class Product {

	@Id
	private int productID;
    private String productName;
    private String productDesc;
    private Double productPrice;
    
	public Product(int productID, String productName, String productDesc, Double productPrice) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
	}

	public Product() {
		
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}


}
