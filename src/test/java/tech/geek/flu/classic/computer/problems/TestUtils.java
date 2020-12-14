package tech.geek.flu.classic.computer.problems;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestUtils {

  public static List<Integer> getSampleData(int numData) {
    return IntStream.generate(() -> new Random().nextInt(100))
        .boxed()
        .limit(numData)
        .collect(Collectors.toList());
  }

}
