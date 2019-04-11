package com.arefin.sunshinefarm.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "equipment")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Enter equipment name")
    private String name;

    @Column(name = "product_code")
    @NotBlank(message = "Enter equipment product code")
    private String productCode;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "purchase_price")
    private Double purchasePrice;

    @Column(name = "person_name")
    @NotBlank(message = "Enter person's name, responsible for purchasing this equipment")
    private String personName;

    @ManyToMany
    @JoinTable(
            name = "equipment_crops",
            joinColumns = @JoinColumn(name = "equipment_id"),
            inverseJoinColumns = @JoinColumn(name = "crops_id"))
    private Set<Crops> crops;

    public Equipment() {
    }

    public Equipment(@NotBlank(message = "Enter equipment name") String name, @NotBlank(message = "Enter equipment product code") String productCode, int quantity, Double purchasePrice, @NotBlank(message = "Enter person's name, responsible for purchasing this equipment") String personName, Set<Crops> crops) {
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
        Equipment equipment = (Equipment) o;
        return quantity == equipment.quantity &&
                Objects.equals(id, equipment.id) &&
                Objects.equals(name, equipment.name) &&
                Objects.equals(productCode, equipment.productCode) &&
                Objects.equals(purchasePrice, equipment.purchasePrice) &&
                Objects.equals(personName, equipment.personName) &&
                Objects.equals(crops, equipment.crops);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, productCode, quantity, purchasePrice, personName, crops);
    }

    @Override
    public String toString() {
        return "Equipment{" +
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
