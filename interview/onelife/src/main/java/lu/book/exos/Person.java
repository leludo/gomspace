package lu.book.exos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private int age;

    // test
    public static Comparator<Person> ageComparatorAscending = (a, b) -> a.ageDifference(b);
    public static Comparator<Person> ageComparatorDescending = ageComparatorAscending.reversed();
    public static Comparator<Person> nameComparatorAscending = (a, b) -> a.name.compareTo(b.name);

    public int ageDifference(final Person anotherPerson) {
        return this.age - anotherPerson.age;
    }


}
