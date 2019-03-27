package com.arefin.sunshinefarm.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "sales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    @NotBlank(message = "Enter product name")
    private String productName;

    @Column(name = "product_code")
    @NotBlank(message = "Enter product code")
    private String productCode;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "per_unit_sales_price")
    private Double perUnitSalesPrice;

    @Column(name = "sales_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private Date salesDate;

    @ManyToOne
    @JoinColumn(name = "crops_id")
    private Crops crops;

    public Sales() {
    }

    public Sales(@NotBlank(message = "Enter product name") String productName, @NotBlank(message = "Enter product code") String productCode, int quantity, Double perUnitSalesPrice, Date salesDate, Crops crops) {
        this.productName = productName;
        this.productCode = productCode;
        this.quantity = quantity;
        this.perUnitSalesPrice = perUnitSalesPrice;
        this.salesDate = salesDate;
        this.crops = crops;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }

    public Double getPerUnitSalesPrice() {
        return perUnitSalesPrice;
    }

    public void setPerUnitSalesPrice(Double perUnitSalesPrice) {
        this.perUnitSalesPrice = perUnitSalesPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Crops getCrops() {
        return crops;
    }

    public void setCrops(Crops crops) {
        this.crops = crops;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sales sales = (Sales) o;
        return quantity == sales.quantity &&
                Objects.equals(id, sales.id) &&
                Objects.equals(productName, sales.productName) &&
                Objects.equals(productCode, sales.productCode) &&
                Objects.equals(perUnitSalesPrice, sales.perUnitSalesPrice) &&
                Objects.equals(salesDate, sales.salesDate) &&
                Objects.equals(crops, sales.crops);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, productCode, quantity, perUnitSalesPrice, salesDate, crops);
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productCode='" + productCode + '\'' +
                ", quantity=" + quantity +
                ", perUnitSalesPrice=" + perUnitSalesPrice +
                ", salesDate=" + salesDate +
                ", crops=" + crops +
                '}';
    }
}
