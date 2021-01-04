package tech.geek.flu.classic.computer.problems;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestUtils {

  public static List<Integer> getSampleData(int numData, int bound) {
    return IntStream.generate(() -> new Random().nextInt(bound))
        .boxed()
        .limit(numData)
        .collect(Collectors.toList());
  }

  public static List<Integer> getSampleData(int numData) {
    return getSampleData(numData, 100);
  }

}
