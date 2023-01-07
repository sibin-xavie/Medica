package com.gerimedica.medica.facade;

import com.gerimedica.medica.exceptions.DateFomatException;
import com.gerimedica.medica.exceptions.ProductNotFoundException;
import com.gerimedica.medica.model.ProductDetails;
import com.gerimedica.medica.repository.ProductRepository;
import com.gerimedica.medica.util.RestResponse;
import org.apache.commons.validator.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
public class ProductFacade {

    @Autowired
    ProductRepository productRepository;

    /**
     * @Desc : fetch the product by code
     */
    public List<ProductDetails> fetchProducts() {
        List<ProductDetails> productDetails = new ArrayList<>();
        Iterator<ProductDetails> productsItr = productRepository.findAll().iterator();
        while (productsItr.hasNext()) {
            productDetails.add(productsItr.next());
        }
        return productDetails;
    }
    /**
     * @Desc : Save product
     */
    public RestResponse<ProductDetails> saveProduct(ProductDetails productDetails) {
        try {
            String fromDate = productDetails.getFromDate();
            String toDate = productDetails.getToDate();
            boolean isValidFromDate = GenericValidator.isDate(fromDate,"yyyy-MM-dd", true);
            boolean isValidToDate = GenericValidator.isDate(toDate,"yyyy-MM-dd", true);
            System.out.println(isValidFromDate);
            if(!isValidFromDate) {
                throw new DateFomatException("Invalid from date provided.");
            } else if(!isValidToDate){
                throw new DateFomatException("Invalid To date provided.");
            }
            productRepository.save(productDetails);
        } catch (DataIntegrityViolationException uniqueValue){
            return new RestResponse<>().setMessage("Duplicate Entry!!.");
        }catch (Exception e) {
            e.printStackTrace();
            return new RestResponse<>().setMessage("Failed to Save");
        }
        return new RestResponse<>().setMessage("Success");
    }

    public ProductDetails findByCode(String code) throws ProductNotFoundException {
        ProductDetails byCode = null;
        byCode = productRepository.findByCode(code);
        if (Objects.isNull(byCode)) {
            throw new ProductNotFoundException("Product with Code Invalid.");
        }
        return byCode;
    }

    public void deleteByCode() {
        productRepository.deleteAll();
    }


}
