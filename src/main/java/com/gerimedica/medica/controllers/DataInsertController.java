package com.gerimedica.medica.controllers;

import com.gerimedica.medica.csv.CsvExportService;
import com.gerimedica.medica.exceptions.ProductNotFoundException;
import com.gerimedica.medica.facade.ProductFacade;
import com.gerimedica.medica.model.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author sibin
 * @since 07 01 2023
 * */
@RestController
@RequestMapping("/")
public class DataInsertController {
    @Autowired
    private ProductFacade productFacade;

    @Autowired
    private CsvExportService csvExportService;

    @PostMapping(path = "upload")
    public ResponseEntity insertProductInfo(@RequestBody ProductDetails productDetails){
        return ResponseEntity.ok().body(productFacade.saveProduct(productDetails));
    }

    @PostMapping(path = "fetchByCode")
    public ResponseEntity fetchByProductCode(@RequestParam String code) throws ProductNotFoundException {
        return ResponseEntity.ok().body(productFacade.findByCode(code));
    }

    @PostMapping(path = "deleteAllData")
    public ResponseEntity deleteByProductCode(){
        productFacade.deleteByCode();
        return ResponseEntity.ok().body("All Data Cleared.");
    }

    @GetMapping(path = "writeCSV")
    public void writeToCSV(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"products.csv\"");
        csvExportService.writeProductsToCsv(servletResponse.getWriter());
    }


}
