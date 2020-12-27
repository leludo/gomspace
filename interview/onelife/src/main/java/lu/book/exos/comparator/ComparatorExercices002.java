package lu.book.exos.comparator;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.Comparator;

@Log4j2
@Data
public class ComparatorExercices002 {


    public static void main(String[] args) {
        try {

            MyFunction f  = (a,b) -> { System.out.println(a + b); return a.compareTo(b) ;};
            int comparatorResult = f.printIt("hello", "babe"); // when calling the default method, the body is the one used during the init phase above
            int printItUppercase = f.printItUppercase("hello", "babe me amor ");
            System.out.printf("abstract method result is %s and default method result is %s", comparatorResult,printItUppercase);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}