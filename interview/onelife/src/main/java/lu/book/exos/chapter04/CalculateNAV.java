package lu.book.exos.chapter04;

import java.math.BigDecimal;
import java.util.function.Function;

public class CalculateNAV {

    // Function with String parameter and BigDecimal
    private final Function<String, BigDecimal> priceFinder;

    // The actual implementation of the priceFinder function is passed as a parameter of the class constuctor
    public CalculateNAV(Function<String, BigDecimal> aPriceFinder) {
        this.priceFinder = aPriceFinder;
    }

    // The implementation of the computeStockWorth method is actually mixing the pricefinder implementation with some
    // specific implementation
    public Comparable<BigDecimal> computeStockWorth(String ticker, int shares) {
        return priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
    }

}
