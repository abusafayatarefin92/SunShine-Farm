package com.arefin.sunshinefarm.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "insecticides")
public class Insecticides {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Enter insecticides name")
    private String name;

    @Column(name = "product_code")
    @NotBlank(message = "Enter insecticides product code")
    private String productCode;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "purchase_price")
    private Double purchasePrice;

    @Column(name = "person_name")
    @NotBlank(message = "Enter person's name, responsible for purchasing this insecticides")
    private String personName;

    @ManyToMany
    @JoinTable(
            name = "insecticides_crops",
            joinColumns = @JoinColumn(name = "insecticides_id"),
            inverseJoinColumns = @JoinColumn(name = "crops_id"))
    private Set<Crops> crops;

    public Insecticides() {
    }

    public Insecticides(@NotBlank(message = "Enter insecticides name") String name, @NotBlank(message = "Enter insecticides product code") String productCode, int quantity, Double purchasePrice, @NotBlank(message = "Enter person's name, responsible for purchasing this insecticides") String personName, Set<Crops> crops) {
        this.name = name;
        this.productCode = productCode;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
        this.personName = personName;
        this.crops = crops;
    }

    public Set<Crops> getCrops() {
        return crops;
    }

    public void setCrops(Set<Crops> crops) {
        this.crops = crops;
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

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Insecticides that = (Insecticides) o;
        return quantity == that.quantity &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(productCode, that.productCode) &&
                Objects.equals(purchasePrice, that.purchasePrice) &&
                Objects.equals(personName, that.personName) &&
                Objects.equals(crops, that.crops);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, productCode, quantity, purchasePrice, personName, crops);
    }

    @Override
    public String toString() {
        return "Insecticides{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productCode='" + productCode + '\'' +
                ", quantity=" + quantity +
                ", purchasePrice=" + purchasePrice +
                ", personName='" + personName + '\'' +
                ", crops=" + crops +
                '}';
    }
}
