package com.gerimedica.medica.csv;

import com.gerimedica.medica.facade.ProductFacade;
import com.gerimedica.medica.model.ProductDetails;
import com.gerimedica.medica.repository.ProductRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.logging.Logger;

@Service
public class CsvExportService {
    @Autowired
    private ProductFacade productFacade;


    public void writeProductsToCsv(Writer writer) {
        List<ProductDetails> productDetailsList = productFacade.fetchProducts();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            String[] entries = {"Source","CodeListCode","Code","LongDiscription","DisplayValue","FromDate","ToDate", "SortingPriority"};
            csvPrinter.printRecord(entries);
            for (ProductDetails productDetails : productDetailsList) {
                csvPrinter.printRecord(productDetails.getSource(), productDetails.getCodeListCode(), productDetails.getCode(),
                        productDetails.getLongDiscription(), productDetails.getDisplayValue(),productDetails.getFromDate(),
                        productDetails.getToDate(), productDetails.getSortingPriority());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
