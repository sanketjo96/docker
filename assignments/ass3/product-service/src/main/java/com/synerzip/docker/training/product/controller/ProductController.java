package com.synerzip.docker.training.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.synerzip.docker.training.product.DTO.ProductDTO;
import com.synerzip.docker.training.product.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * The Class UserController.
 */
@RestController
@RequestMapping("/api/v1/product")
@Api(value = "Product APIs", tags = "Products")
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * Creates the User.
	 *
	 * @param userDTO the user DTO
	 * @return the response entity
	 */
	@ApiOperation(nickname = "createProduct", value = "Create Product", httpMethod = "POST")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Product created successfully") })
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<ProductDTO> createProduct(ProductDTO productDTO) {
		productDTO = this.productService.createProduct(productDTO);
		return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
	}
	
	@ApiOperation(nickname = "getProduct/{Id}/{fetchReviews}", value = "Fetch Product", httpMethod = "GET")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Product fetched successfully") })
	@RequestMapping(value = "/{Id}/{fetchReviews}",method = RequestMethod.GET)
	public ResponseEntity<ProductDTO> getUser( @ApiParam(name = "Id", value = "Unique Id of Product", required = true)@PathVariable(name = "Id")Long productId,
			@ApiParam(name = "fetchReviews", value = "Fetch review (true/false)", required = true)@PathVariable(name = "fetchReviews")Boolean fetchReviews
			) {
		ProductDTO productDTO = this.productService.getProduct(productId,fetchReviews);
		return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);	
	}
	
	
}
