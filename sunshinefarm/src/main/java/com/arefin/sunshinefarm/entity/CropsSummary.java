package com.arefin.sunshinefarm.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "crops_summary")
public class CropsSummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", unique = true)
    @NotBlank(message = "Enter product name")
    private String productName;

    @Column(name = "product_code", unique = true)
    @NotBlank(message = "Enter product code")
    private String productCode;

    @Column(name = "total_quantity")
    private int totalQuantity;

    @Column(name = "sales_quantity")
    private int salesQuantity;

    @Column(name = "available_quantity")
    private int availableQuantity;

    @Column(name = "last_update")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date lastUpdate;

    public CropsSummary() {
    }

    public CropsSummary(@NotBlank(message = "Enter product name") String productName, @NotBlank(message = "Enter product code") String productCode, int totalQuantity, int salesQuantity, int availableQuantity, Date lastUpdate) {
        this.productName = productName;
        this.productCode = productCode;
        this.totalQuantity = totalQuantity;
        this.salesQuantity = salesQuantity;
        this.availableQuantity = availableQuantity;
        this.lastUpdate = lastUpdate;
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

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(int salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CropsSummary that = (CropsSummary) o;
        return totalQuantity == that.totalQuantity &&
                salesQuantity == that.salesQuantity &&
                availableQuantity == that.availableQuantity &&
                Objects.equals(id, that.id) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(productCode, that.productCode) &&
                Objects.equals(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, productCode, totalQuantity, salesQuantity, availableQuantity, lastUpdate);
    }

    @Override
    public String toString() {
        return "CropsSummary{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productCode='" + productCode + '\'' +
                ", totalQuantity=" + totalQuantity +
                ", salesQuantity=" + salesQuantity +
                ", availableQuantity=" + availableQuantity +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
