package com.guillerdev97.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test multiply two numbers")
    void test_multiply() {
        assertEquals(12, calculator.multiplyTwoNumbers(3, 4));
    }

    @Test
    @DisplayName("Test sum two numbers")
    void test_sum() {
        assertEquals(5, calculator.sumTwoNumbers(2, 3));
    }
}
