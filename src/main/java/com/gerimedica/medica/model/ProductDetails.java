package com.gerimedica.medica.model;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "product_dtls")

public class ProductDetails implements Serializable {

    private static final long serialVersionUID = 6085954502846213959L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "code", unique = true, nullable = false)
    private String code;
    @Column(name = "code_list_code" , nullable = false, length = 12)
    private String codeListCode;
    @Column(name = "source", nullable = false, length = 14)
    private String source;
    @Column(name = "display_value",length = 80)
    private String displayValue;
    @Column(name = "long_desc", length = 255)
    private String longDiscription;
    @Column(name = "from_date",nullable = false,length = 55)
    private Date fromDate;
    @Column(name = "to_date", nullable = false, length = 55)
    private Date toDate;

    @Column(name = "sort_prior", nullable = false, length = 4)
    private Integer sortingPriority;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeListCode() {
        return codeListCode;
    }

    public void setCodeListCode(String codeListCode) {
        this.codeListCode = codeListCode;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getLongDiscription() {
        return longDiscription;
    }

    public void setLongDiscription(String longDiscription) {
        this.longDiscription = longDiscription;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Integer getSortingPriority() {
        return sortingPriority;
    }

    public void setSortingPriority(Integer sortingPriority) {
        this.sortingPriority = sortingPriority;
    }
}
