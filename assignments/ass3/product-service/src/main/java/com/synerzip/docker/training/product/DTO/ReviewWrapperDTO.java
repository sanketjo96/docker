package com.synerzip.docker.training.product.DTO;

import java.util.List;


/**
 * The Class ReviewWrapperDTO.
 */
public class ReviewWrapperDTO {

	/** The review list. */
	private List<ReviewDTO> reviewList;

	/**
	 * Gets the review list.
	 *
	 * @return the review list
	 */
	public List<ReviewDTO> getReviewList() {
		return reviewList;
	}

	/**
	 * Sets the review list.
	 *
	 * @param reviewList the new review list
	 */
	public void setReviewList(List<ReviewDTO> reviewList) {
		this.reviewList = reviewList;
	}
	
}
