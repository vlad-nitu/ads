import interview.MatchReplacement;

import java.io.IOException;
import java.util.Comparator;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Everything works fine");
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7);
        stream.sorted(Comparator.reverseOrder()).forEachOrdered(System.out::println);


    }
}
