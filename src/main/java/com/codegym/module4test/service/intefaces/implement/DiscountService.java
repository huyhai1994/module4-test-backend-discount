package com.codegym.module4test.service.intefaces.implement;

import com.codegym.module4test.entity.Discount;
import com.codegym.module4test.exception.OurException;
import com.codegym.module4test.repository.IDiscountRepository;
import com.codegym.module4test.service.intefaces.IDiscountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DiscountService implements IDiscountService {
    private final IDiscountRepository discountRepository;

    @Override
    public void save(Discount discount) {
        discountRepository.save(discount);
    }

    @Override
    public void deleteById(Long id) {
        if (discountRepository.findById(id).isPresent())
            discountRepository.deleteById(id);
        else
            throw new OurException("Discount" + id + " not found");
    }

    @Override
    public Optional<Discount> findById(Long id) {
        if (discountRepository.findById(id).isPresent())
            return discountRepository.findById(id);
        else
            throw new OurException("Discount " + id + " not found");
    }

    @Override
    public Iterable<Discount> findAll() {
        return discountRepository.findAll();
    }

    @Override
    public Iterable<Discount> getDiscountsByDiscountMoneyGreaterThanEqual(BigDecimal discountMoney) {
        return discountRepository.getDiscountsByDiscountMoney(discountMoney);
    }
}
