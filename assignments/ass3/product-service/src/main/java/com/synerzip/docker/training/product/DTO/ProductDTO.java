package com.synerzip.docker.training.product.DTO;

import java.util.List;

/**
 * The Class ProductDTO.
 */
public class ProductDTO {

	/** The product ID. */
	private Long productID;
	
	/** The product name. */
	private String productName;
	
	/** The product description. */
	private String productDescription;
	
	/** The product type. */
	private String productType;
	
	/** The product unit price. */
	private Float productUnitPrice;
	
	/** The reviews. */
	private List<ReviewDTO> reviews;

	/**
	 * Gets the product ID.
	 *
	 * @return the product ID
	 */
	public Long getProductID() {
		return productID;
	}

	/**
	 * Sets the product ID.
	 *
	 * @param productID the new product ID
	 */
	public void setProductID(Long productID) {
		this.productID = productID;
	}

	/**
	 * Gets the product name.
	 *
	 * @return the product name
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Sets the product name.
	 *
	 * @param productName the new product name
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Gets the product description.
	 *
	 * @return the product description
	 */
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * Sets the product description.
	 *
	 * @param productDescription the new product description
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	/**
	 * Gets the product type.
	 *
	 * @return the product type
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * Sets the product type.
	 *
	 * @param productType the new product type
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}

	/**
	 * Gets the product unit price.
	 *
	 * @return the product unit price
	 */
	public Float getProductUnitPrice() {
		return productUnitPrice;
	}

	/**
	 * Sets the product unit price.
	 *
	 * @param productUnitPrice the new product unit price
	 */
	public void setProductUnitPrice(Float productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}

	/**
	 * Gets the reviews.
	 *
	 * @return the reviews
	 */
	public List<ReviewDTO> getReviews() {
		return reviews;
	}

	/**
	 * Sets the reviews.
	 *
	 * @param reviews the new reviews
	 */
	public void setReviews(List<ReviewDTO> reviews) {
		this.reviews = reviews;
	}

	
	
}
