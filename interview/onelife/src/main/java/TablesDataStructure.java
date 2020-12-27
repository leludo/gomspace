import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TablesDataStructure {

    private final static Integer[] employeeIdsToBeFired = {1, 2};
    private final static List<Integer> numbers = Arrays.asList(11,22,44,55,66,77,88,99);

    private static Employee[] arrayOfEmps = {
            new Employee(1, "Jeff Bezos", 100000.0),
            new Employee(2, "Bill Gates", 200000.0),
            new Employee(3, "Mark Zuckerberg", 300000.0)
    };

    public static void main(String[] args) {
        //System.out.println(Arrays.stream(tableOfInts).average());
        Predicate<Integer> p = i -> i >= 1;
        boolean matchAllSupToOne = Arrays.stream(employeeIdsToBeFired).allMatch(p);

        EmployeesRepository er = new EmployeesRepository(arrayOfEmps);
        System.out.println("matches all elements of the array equals 1 = " + matchAllSupToOne);

        Stream.of(arrayOfEmps).forEach(e -> e.incrementSalary(200d));

        List<Employee> employeesToBeFired = Stream.of(employeeIdsToBeFired).map(er::findById).collect(Collectors.toList());

        employeesToBeFired.stream().forEach(System.out::println);

        System.out.println(numbers.stream().filter( n -> n%2 ==0).mapToInt( n -> n*2).sum());

    }

}

