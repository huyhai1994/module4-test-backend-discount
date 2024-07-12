package com.codegym.module4test.repository;

import com.codegym.module4test.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface IDiscountRepository extends JpaRepository<Discount, Long> {
    @Query(value = "SELECT * FROM discounts WHERE discount_money >= :discountmoney", nativeQuery = true)
    Iterable<Discount> getDiscountsByDiscountMoney(BigDecimal discountMoney);
}
