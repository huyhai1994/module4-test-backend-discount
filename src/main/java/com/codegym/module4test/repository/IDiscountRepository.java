package com.codegym.module4test.repository;

import com.codegym.module4test.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDiscountRepository extends JpaRepository<Discount, Long> {
}
