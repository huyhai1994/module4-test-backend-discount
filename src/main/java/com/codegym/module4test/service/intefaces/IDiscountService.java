package com.codegym.module4test.service.intefaces;

import com.codegym.module4test.entity.Discount;

import java.math.BigDecimal;

public interface IDiscountService extends IGenericService<Discount> {
    Iterable<Discount> getDiscountsByDiscountMoneyGreaterThanEqual(BigDecimal discountMoney);
}
