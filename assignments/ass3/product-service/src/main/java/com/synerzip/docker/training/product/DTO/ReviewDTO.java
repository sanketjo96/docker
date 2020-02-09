package com.synerzip.docker.training.product.DTO;

/**
 * The Class ReviewDTO.
 */
public class ReviewDTO {

	/** The review id. */
	private Long reviewId;
	
	/** The product id. */
	private Long productId;
	
	/** The rating. */
	private Integer rating;
	
	/** The user comment. */
	private String userComment;
	
	/** The user id. */
	private Long userId;

	/**
	 * Gets the review id.
	 *
	 * @return the review id
	 */
	public Long getReviewId() {
		return reviewId;
	}

	/**
	 * Sets the review id.
	 *
	 * @param reviewId the new review id
	 */
	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	/**
	 * Gets the product id.
	 *
	 * @return the product id
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * Sets the product id.
	 *
	 * @param productId the new product id
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public Integer getRating() {
		return rating;
	}

	/**
	 * Sets the rating.
	 *
	 * @param rating the new rating
	 */
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	/**
	 * Gets the user comment.
	 *
	 * @return the user comment
	 */
	public String getUserComment() {
		return userComment;
	}

	/**
	 * Sets the user comment.
	 *
	 * @param userComment the new user comment
	 */
	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
	
	
}
