package com.synerzip.docker.training.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.synerzip.docker.training.review.DTO.ReviewDTO;
import com.synerzip.docker.training.review.service.ReviewService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * The Class UserController.
 */
@RestController
@RequestMapping("/api/v1/review")
@Api(value = "Review APIs", tags = "Review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	/**
	 * Creates the User.
	 *
	 * @param userDTO the user DTO
	 * @return the response entity
	 */
	@ApiOperation(nickname = "createReview", value = "Create Product Review", httpMethod = "POST")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Review created successfully") })
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<ReviewDTO> createReview(ReviewDTO reviewDTO) {
		reviewDTO = this.reviewService.createReview(reviewDTO);
		return new ResponseEntity<ReviewDTO>(reviewDTO, HttpStatus.OK);
	}
	
	@ApiOperation(nickname = "getReview/{Id}", value = "Fetch User Profile", httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User fetched successfully") })
	@RequestMapping(value = "getReview/{Id}",method = RequestMethod.GET)
	public ResponseEntity<ReviewDTO> getReview( @ApiParam(name = "Id", value = "Unique Id of Review", required = true)@PathVariable(name = "Id")Long reviewId) {
		ReviewDTO reviewDTO = this.reviewService.getReviewById(reviewId);
		return new ResponseEntity<ReviewDTO>(reviewDTO, HttpStatus.OK);
	}
	
	@ApiOperation(nickname = "getReviewByProductId/{productId}", value = "Fetch Reviews By Product", httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User fetched successfully") })
	@RequestMapping(value = "getReviewByProductId/{productId}",method = RequestMethod.GET)
	public ResponseEntity<List<ReviewDTO>> getReviewByProductId( @ApiParam(name = "productId", value = "Unique Id of Product", required = true)@PathVariable(name = "productId")Long productId) {
		List<ReviewDTO> reviewDTOList = this.reviewService.getReviewsByProductId(productId);
		return new ResponseEntity<List<ReviewDTO>>(reviewDTOList, HttpStatus.OK);
	}
	
	@ApiOperation(nickname = "getReviewByUserId/{userId}", value = "Fetch Reviews By User", httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User fetched successfully") })
	@RequestMapping(value = "getReviewByUserId/{userId}",method = RequestMethod.GET)
	public ResponseEntity<List<ReviewDTO>> getReviewByUserId( @ApiParam(name = "userId", value = "Unique Id of User", required = true)@PathVariable(name = "userId")Long userId) {
		List<ReviewDTO> reviewDTOList = this.reviewService.getReviewsByUserId(userId);
		return new ResponseEntity<List<ReviewDTO>>(reviewDTOList, HttpStatus.OK);
	}
	
	
}
