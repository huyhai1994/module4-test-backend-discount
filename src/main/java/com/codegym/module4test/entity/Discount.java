package com.codegym.module4test.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Getter
@Setter
@Table(name = "discounts")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @NotNull
    @Future
    private LocalDate startDate;

    @NotNull
    @Future
    private LocalDate endDate;

    private String detail;

    @NotNull
    @Min(value = 10000)
    private BigDecimal discountMoney;
}
