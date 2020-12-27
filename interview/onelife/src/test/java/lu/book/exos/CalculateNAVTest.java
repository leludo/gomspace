/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package lu.book.exos;


import lu.book.exos.chapter04.CalculateNAV;
import lu.book.exos.chapter04.YahooFinance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CalculateNAVTest {

    @Test
    public void computeStockWorth_static() {
        final CalculateNAV calculateNAV = new CalculateNAV(ticker -> new BigDecimal("6.01"));

        BigDecimal expected = new BigDecimal("6010.00");

        Assertions.assertEquals(0,
                calculateNAV.computeStockWorth("GOOG", 1000).compareTo(expected),
                0.001);
    }

    @Test
    public void computeStockWorth_yahoo() {
        // passing the yahoo finance method with the right signature to the constructor of the calculate nav class this time
        final CalculateNAV calculateNAV = new CalculateNAV(YahooFinance::getPrice);
        Comparable<BigDecimal> stockWorth = calculateNAV.computeStockWorth("GOOG", 1000);


    }
}