import interview.FairDistribution;
import interview.MatchReplacement;
import interview.MinPathCostGrid;

import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.util.Comparator;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println(new FairDistribution().distributeCookies(new int[]{6,1,3,2,2,4,1,2}, 3));


        /*System.out.println("Everything works fine");
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7);
        stream.sorted(Comparator.reverseOrder()).forEachOrdered(System.out::println);
    */


    }
}
