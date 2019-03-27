package com.arefin.sunshinefarm.repo;

import com.arefin.sunshinefarm.entity.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ExpenseRepo extends JpaRepository<Expenses, Long> {

}
