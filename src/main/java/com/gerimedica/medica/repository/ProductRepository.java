package com.gerimedica.medica.repository;

import com.gerimedica.medica.model.ProductDetails;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<ProductDetails, Integer> {
    public ProductDetails findByCode(String code);
}
