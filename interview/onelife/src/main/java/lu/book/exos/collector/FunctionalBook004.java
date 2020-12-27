package lu.book.exos.collector;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import lu.book.exos.Person;

import java.util.*;
import java.util.function.BinaryOperator;

import static java.util.stream.Collectors.*;

@Log4j2
@Data
public class FunctionalBook004 {

    private final static List<Person> persons = Arrays.asList(new Person("Noob",25) , new Person("John",40),
            new Person("Nico",18) ,new Person("Tom",18), new Person("Toto", 43));

    public static void main(String[] args) {

        // Comparator builder by age
        Comparator<Person> byAge = Comparator.comparing(Person::getAge);

        // grouping on the first character of the firstname by only selecting the oldest
        Map<Character, Optional<Person>> integerListMap = persons.stream().collect(groupingBy(p -> p.getName().charAt(0), reducing(BinaryOperator.maxBy(byAge))));
        System.out.println(integerListMap);

    }
}