package com.synerzip.docker.training.review.service;

import java.util.List;

import com.synerzip.docker.training.review.DTO.ReviewDTO;

/**
 * The Interface ReviewService.
 */
public interface ReviewService {

	/**
	 * Creates the review.
	 *
	 * @param reviewDTO the review DTO
	 * @return the review DTO
	 */
	public ReviewDTO createReview(ReviewDTO reviewDTO);
	
	/**
	 * Gets the review by id.
	 *
	 * @param reviewId the review id
	 * @return the review by id
	 */
	public ReviewDTO getReviewById(Long reviewId);
	
	/**
	 * Gets the reviews by product id.
	 *
	 * @param productId the product id
	 * @return the reviews by product id
	 */
	public List<ReviewDTO> getReviewsByProductId(Long productId);
	
	/**
	 * Gets the reviews by user id.
	 *
	 * @param productId the product id
	 * @return the reviews by user id
	 */
	public List<ReviewDTO> getReviewsByUserId(Long productId);
	
}
