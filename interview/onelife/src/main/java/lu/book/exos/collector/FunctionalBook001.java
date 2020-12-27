package lu.book.exos.collector;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalBook001 {

    private final static List<String> friends= Arrays.asList("Noob" , "John","Nico" , "Toto");


    public static void main(String[] args) {

        List<String> filteredFriends = friends.stream().filter(startWithLetter.apply("N")).collect(Collectors.toList());

        //concat the list into a  string
        String collectedFriends = filteredFriends.stream().map(Objects::toString).collect(Collectors.joining(","));
        // display the list
        filteredFriends.forEach(System.out::println);// using a function reference


    }

    final static Function<String, Predicate<String>> startWithLetter = letter -> name -> name.startsWith(letter);

}

