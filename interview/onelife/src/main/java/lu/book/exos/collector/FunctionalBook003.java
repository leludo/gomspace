package lu.book.exos.collector;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import lu.book.exos.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

@Log4j2
@Data
public class FunctionalBook003 {

    private final static List<Person> persons = Arrays.asList(new Person("Noob",25) , new Person("John",40),
            new Person("Nico",18) ,new Person("Tom",18), new Person("Toto", 43));

    public static void main(String[] args) {
        // The whole idea is to see how to sort a collection
        // instead of using (a,b) -> a.ageDifference(b) we can use the function ref lu.book.exos.Person::ageDifference
        List<Person> personAscending = persons.stream().sorted(Person::ageDifference).collect(toList());
        // it s also possible to use the comparator instead
        List<Person> personDescending = persons.stream().sorted(Person.ageComparatorDescending).collect(toList());
        personDescending.forEach(System.out::println);
        List<Person> personNamesAscending = persons.stream().sorted(Person.nameComparatorAscending).collect(toList());
        personNamesAscending.forEach(System.out::println);
        persons.stream().min(Person::ageDifference).ifPresent(person -> System.out.printf("%s is %d years old and is the youngest\n", person.getName(),person.getAge()));
        // the collector grouping function will group the elements of a list using a criteria, here we are using the age
        Map<Integer, List<Person>> groupedPersons = persons.stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println(groupedPersons);
        // same version but we transform the list of Persons to a list of names
        Map<Integer, List<String>> integerListMap = persons.stream().collect(Collectors.groupingBy(Person::getAge, mapping(Person::getName, toList())));
        System.out.println(integerListMap);

    }
}