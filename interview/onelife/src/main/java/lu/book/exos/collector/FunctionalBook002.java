package lu.book.exos.collector;

import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
@Log4j2
@Data
public class FunctionalBook002 {

    private final static List<String> firstListOfFriends = Arrays.asList("Noob" , "John","Nico" , "Toto");
    private final static List<String> secondListOfFriends = Arrays.asList("Noob2" , "John2","Nico2" , "Toto2");

    private int toto;

    public static void main(String[] args) {

        String startingLetter = "N";
        Optional<String> first = firstListOfFriends.stream().filter(startWithLetter.apply(startingLetter)).findFirst();
        System.out.printf("Found name starting with %s: %s", startingLetter, first.orElse("Not found"));

        log.error("Something else is wrong here");

        IntStream intStreamOne = firstListOfFriends.stream().mapToInt(String::length);
        IntStream intStreamTwo = secondListOfFriends.stream().mapToInt(String::length);

        // Concatenate two streams into a single one

        IntStream.concat(intStreamOne,intStreamTwo).forEach(System.out::println);

        List<List<String>> listsOfFriends = Arrays.asList(firstListOfFriends, secondListOfFriends);

        List<String> flatListOfFriends = listsOfFriends.stream().flatMap(Collection::stream).collect(Collectors.toList());
        flatListOfFriends.forEach(System.out::println);

        // joining using a collector
        String jointList = flatListOfFriends.stream().collect(Collectors.joining(" | "));
        System.out.println(jointList);
        
    }

    final static Function<String, Predicate<String>> startWithLetter = letter -> name -> name.startsWith(letter);

}
