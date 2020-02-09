package com.synerzip.docker.training.product.service;

import com.synerzip.docker.training.product.DTO.ProductDTO;

/**
 * The Interface ProductService.
 */
public interface ProductService {

	/**
	 * Creates the product.
	 *
	 * @param productDTO the product DTO
	 * @return the product DTO
	 */
	public ProductDTO createProduct(ProductDTO productDTO);
	
	/**
	 * Gets the product.
	 *
	 * @param productId the product id
	 * @param fetchReviews the fetch reviews
	 * @return the product
	 */
	public ProductDTO getProduct(Long productId,Boolean fetchReviews);
}
