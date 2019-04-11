package com.arefin.sunshinefarm.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "crops")
public class Crops {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Enter crop's name")
    private String name;

    @Column(name = "duration")
    @NotBlank(message = "Enter crop's duration")
    private String duration;

    @Column(name = "product_code")
    @NotBlank(message = "Enter crop's product code")
    private String productCode;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "per_unit_selling_price")
    private Double perUnitSellingPrice;

    public Crops() {
    }

    public Crops(@NotBlank(message = "Enter crop's name") String name, @NotBlank(message = "Enter crop's duration") String duration, @NotBlank(message = "Enter crop's product code") String productCode, int quantity, Double perUnitSellingPrice) {
        this.name = name;
        this.duration = duration;
        this.productCode = productCode;
        this.quantity = quantity;
        this.perUnitSellingPrice = perUnitSellingPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPerUnitSellingPrice() {
        return perUnitSellingPrice;
    }

    public void setPerUnitSellingPrice(Double perUnitSellingPrice) {
        this.perUnitSellingPrice = perUnitSellingPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crops crops = (Crops) o;
        return quantity == crops.quantity &&
                Objects.equals(id, crops.id) &&
                Objects.equals(name, crops.name) &&
                Objects.equals(duration, crops.duration) &&
                Objects.equals(productCode, crops.productCode) &&
                Objects.equals(perUnitSellingPrice, crops.perUnitSellingPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration, productCode, quantity, perUnitSellingPrice);
    }

    @Override
    public String toString() {
        return "Crops{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", productCode='" + productCode + '\'' +
                ", quantity=" + quantity +
                ", perUnitSellingPrice=" + perUnitSellingPrice +
                '}';
    }
}
