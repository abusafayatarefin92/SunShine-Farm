package com.arefin.sunshinefarm.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Enter employee's name")
    private String name;

    @Column(name = "mobile", unique = true)
    @NotBlank(message = "Enter employee's mobile number")
    private String mobile;

    @Column(name = "starting_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startingDate;

    @Column(name = "monthly_salary")
    private Double monthlySalary;

    @ManyToOne
    @JoinColumn(name = "designation_id", nullable = false)
    private Designation designation;

    public Employees() {
    }

    public Employees(@NotBlank(message = "Enter employee's name") String name, @NotBlank(message = "Enter employee's mobile number") String mobile, Date startingDate, @NotBlank(message = "Enter employee's monthly salary") Double monthlySalary, Designation designation) {
        this.name = name;
        this.mobile = mobile;
        this.startingDate = startingDate;
        this.monthlySalary = monthlySalary;
        this.designation = designation;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public Double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees = (Employees) o;
        return Objects.equals(id, employees.id) &&
                Objects.equals(name, employees.name) &&
                Objects.equals(mobile, employees.mobile) &&
                Objects.equals(startingDate, employees.startingDate) &&
                Objects.equals(monthlySalary, employees.monthlySalary) &&
                Objects.equals(designation, employees.designation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mobile, startingDate, monthlySalary, designation);
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", startingDate=" + startingDate +
                ", monthlySalary=" + monthlySalary +
                ", designation=" + designation +
                '}';
    }
}
