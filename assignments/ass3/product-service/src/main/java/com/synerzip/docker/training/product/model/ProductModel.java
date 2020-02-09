package com.synerzip.docker.training.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tx_product")
public class ProductModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long productID;
	
	/** The product name. */
	@Column(name = "product_name")
	private String productName;
	
	/** The product description. */
	@Column(name = "product_description")
	private String productDescription;
	
	/** The product type. */
	@Column(name = "product_type")
	private String productType;
	
	/** The product unit price. */
	@Column(name = "product_unit_price")
	private Float productUnitPrice;

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Float getProductUnitPrice() {
		return productUnitPrice;
	}

	public void setProductUnitPrice(Float productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}

	
	
	
	
}
