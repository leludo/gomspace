package lu.book.exos.chapter04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;

public class YahooFinance {

    public static final String YAHOO_PRICE = "6.112";
    public static BigDecimal getPrice(final String ticker){
        try {

            // we are supposed to call the Yahoo finance's web services, but the URL is broken.. to lets mock this
            return new BigDecimal(YAHOO_PRICE);
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
