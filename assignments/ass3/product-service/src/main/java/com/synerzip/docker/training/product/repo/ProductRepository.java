package com.synerzip.docker.training.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synerzip.docker.training.product.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long>{

}
