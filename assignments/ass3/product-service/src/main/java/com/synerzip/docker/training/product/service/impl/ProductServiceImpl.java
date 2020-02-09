package com.synerzip.docker.training.product.service.impl;

import java.util.Arrays;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.synerzip.docker.training.product.DTO.ProductDTO;
import com.synerzip.docker.training.product.DTO.ReviewDTO;
import com.synerzip.docker.training.product.model.ProductModel;
import com.synerzip.docker.training.product.repo.ProductRepository;
import com.synerzip.docker.training.product.service.ProductService;

@Service("userService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	 @Override
	public ProductDTO createProduct(ProductDTO productDTO) {
		ProductModel productModel = new ProductModel();
		BeanUtils.copyProperties(productDTO, productModel);
		productRepository.save(productModel);
		productDTO.setProductID(productModel.getProductID());
		return productDTO;
	}

	@Override
	public ProductDTO getProduct(Long productId,Boolean featchReviews) {
		ProductDTO dto = new ProductDTO();
		ProductModel productModel =  this.productRepository.getOne(productId);
		BeanUtils.copyProperties(productModel, dto);
		if(featchReviews) {
			  HttpHeaders headers = new HttpHeaders();
		      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		      HttpEntity <String> entity = new HttpEntity<String>(headers);
		      
			ResponseEntity<ReviewDTO[]> response= restTemplate.getForEntity("http://localhost:9002/api/v1/review/getReviewByProductId/"+productId,ReviewDTO[].class);
			ReviewDTO[] reviews = response.getBody();
			dto.setReviews(Arrays.asList(reviews));
			return dto;
		}else {
			return dto;
		}
	}

}
