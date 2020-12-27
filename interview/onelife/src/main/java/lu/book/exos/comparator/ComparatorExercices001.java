package lu.book.exos.comparator;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.Comparator;

@Log4j2
@Data
public class ComparatorExercices001 {


    public static void main(String[] args) {
        try {

            Comparator<String> stringComparator = Comparator.naturalOrder(); // (s1,s2) -> s1.compareTo(s2)
            int stringComparatorResult = stringComparator.compare("ass", "hole");
            System.out.println(stringComparatorResult);

            // The functional interface defines the apply method with no body.
            // we provide the implementation of the body while instantiating the variable. for this we are reusing the
            // previously defined comparator, but the body could be anything
            MyFunction f = (a,b) -> stringComparator.compare(a , b);

            // calling the function will call the body we just defined and will pass the given parameters
            int comparison = f.printIt("Hello,", " world!");

            System.out.println(comparison);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}