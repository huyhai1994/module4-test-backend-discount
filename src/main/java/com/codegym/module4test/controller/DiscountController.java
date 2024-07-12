package com.codegym.module4test.controller;

import com.codegym.module4test.entity.Discount;
import com.codegym.module4test.service.intefaces.IDiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/discounts")
@RequiredArgsConstructor
public class DiscountController {

    private final IDiscountService discountService;

    @GetMapping
    @CrossOrigin("*")
    ResponseEntity<Iterable<Discount>> getAllDiscounts() {
        List<Discount> Discounts = (List<Discount>) discountService.findAll();
        return new ResponseEntity<>(Discounts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Discount> getDiscountById(@PathVariable Long id) {
        Optional<Discount> Discount = discountService.findById(id);
        return Discount.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    ResponseEntity<Discount> addDiscount(@RequestBody Discount Discount) {
        discountService.save(Discount);
        return new ResponseEntity<>(Discount, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<Discount> updateDiscount(@PathVariable Long id, @RequestBody Discount updatedDiscount) {
        Optional<Discount> oldDiscount = discountService.findById(id);
        if (oldDiscount.isPresent()) {
            Discount Discount = oldDiscount.get();
            Discount.setTitle(updatedDiscount.getTitle());
            Discount.setDiscountMoney(updatedDiscount.getDiscountMoney());
            Discount.setDetail(updatedDiscount.getDetail());
            Discount.setStartDate(updatedDiscount.getStartDate());
            Discount.setEndDate(updatedDiscount.getEndDate());
            discountService.save(Discount);
            return new ResponseEntity<>(Discount, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Discount> removeDiscount(@PathVariable Long id) {
        Optional<Discount> oldDiscount = discountService.findById(id);
        if (oldDiscount.isPresent()) {
            discountService.deleteById(id);
            return new ResponseEntity<>(oldDiscount.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/find/{discountMoney}")
    ResponseEntity<Iterable<Discount>> getDiscountsByDiscountMoneyGreaterThanEqual(@PathVariable BigDecimal discountMoney) {
        Iterable<Discount> discounts = discountService.getDiscountsByDiscountMoneyGreaterThanEqual(discountMoney);
        return new ResponseEntity<>(discounts, HttpStatus.OK);
    }

}
