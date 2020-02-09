package com.synerzip.docker.training.review.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synerzip.docker.training.review.model.ReviewModel;

public interface ReviewRepository extends JpaRepository<ReviewModel, Long>{
	
	public List<ReviewModel> findByProductId(Long productId);
	
	public List<ReviewModel> findByUserId(Long userId);

}
