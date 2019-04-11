package com.arefin.sunshinefarm.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "designation")
public class Designation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "designation_name", unique = true)
    @NotBlank(message = "Enter designation name")
    private String designationName;

    public Designation() {
    }

    public Designation(@NotBlank(message = "Enter designation name") String designationName) {
        this.designationName = designationName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Designation that = (Designation) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(designationName, that.designationName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, designationName);
    }

    @Override
    public String toString() {
        return "Designation{" +
                "id=" + id +
                ", designationName='" + designationName + '\'' +
                '}';
    }
}
