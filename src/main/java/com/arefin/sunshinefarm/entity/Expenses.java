package com.arefin.sunshinefarm.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "expenses")
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "expense_name")
    @NotBlank(message = "Enter expense name")
    private String expenseName;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;

    @Column(name = "person_name")
    @NotBlank(message = "Enter person's name, responsible for this expense")
    private String personName;

    public Expenses() {
    }

    public Expenses(@NotBlank(message = "Enter expense name") String expenseName, Double amount, Date date, @NotBlank(message = "Enter person's name, responsible for this expense") String personName) {
        this.expenseName = expenseName;
        this.amount = amount;
        this.date = date;
        this.personName = personName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        Expenses expenses = (Expenses) o;
        return Objects.equals(id, expenses.id) &&
                Objects.equals(expenseName, expenses.expenseName) &&
                Objects.equals(amount, expenses.amount) &&
                Objects.equals(date, expenses.date) &&
                Objects.equals(personName, expenses.personName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, expenseName, amount, date, personName);
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "id=" + id +
                ", expenseName='" + expenseName + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", personName='" + personName + '\'' +
                '}';
    }
}
