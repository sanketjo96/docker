package com.synerzip.docker.training.review.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synerzip.docker.training.review.DTO.ReviewDTO;
import com.synerzip.docker.training.review.model.ReviewModel;
import com.synerzip.docker.training.review.repo.ReviewRepository;
import com.synerzip.docker.training.review.service.ReviewService;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Override
	public ReviewDTO createReview(ReviewDTO reviewDTO) {
		ReviewModel reviewModel = new ReviewModel();
		BeanUtils.copyProperties(reviewDTO, reviewModel);
		this.reviewRepository.save(reviewModel);
		reviewDTO.setReviewId(reviewModel.getReviewId());
		return reviewDTO;
	}

	@Override
	public ReviewDTO getReviewById(Long reviewId) {
		ReviewModel reviewModel = this.reviewRepository.getOne(reviewId);
		ReviewDTO dto = new ReviewDTO();
		BeanUtils.copyProperties(reviewModel, dto);
		return dto;
	}

	@Override
	public List<ReviewDTO> getReviewsByProductId(Long productId) {
		List<ReviewModel> reviewList = this.reviewRepository.findByProductId(productId);
		List<ReviewDTO> reviewDTOList = new ArrayList<ReviewDTO>();
		for (ReviewModel reviewModel : reviewList) {
			ReviewDTO dto = new ReviewDTO();
			BeanUtils.copyProperties(reviewModel, dto);
			reviewDTOList.add(dto);
		}
		return reviewDTOList;
	}

	@Override
	public List<ReviewDTO> getReviewsByUserId(Long userId) {
		List<ReviewModel> reviewList = this.reviewRepository.findByUserId(userId);
		List<ReviewDTO> reviewDTOList = new ArrayList<ReviewDTO>();
		for (ReviewModel reviewModel : reviewList) {
			ReviewDTO dto = new ReviewDTO();
			BeanUtils.copyProperties(reviewModel, dto);
			reviewDTOList.add(dto);
		}
		return reviewDTOList;
	}

}
