package tech.geek.flu.classic.computer.problems;

import tech.geek.flu.classic.computer.datastructres.tree.HuffmanNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

  public static List<HuffmanNode<Character>> getHuffmanNodes(int numOfNodes) {
    Map<Character, Integer> maps = new HashMap<>();
    List<HuffmanNode<Character>> nodes = new ArrayList<>();
    Random rnd = new Random();
    char randomChar;
    List<Integer> frequencies = getSampleData(numOfNodes, 2 * numOfNodes);
    for (Integer f: frequencies) {
      randomChar = (char) (rnd.nextInt(95) + 32);
      if (maps.containsKey(randomChar)) {
        maps.put(randomChar, maps.get(randomChar) + f);
      }else {
        maps.put(randomChar, f);
      }
    }
    for (Character ch : maps.keySet()) {
      HuffmanNode<Character> characterHuffmanNode = new HuffmanNode<>();
      characterHuffmanNode.setLetter(ch);
      characterHuffmanNode.setFrequency(maps.get(ch));
      nodes.add(characterHuffmanNode);
    }
    return nodes;
  }

  public static void main(String[] args) {
    Random rnd = new Random();
    char randomChar = (char) ('a' + rnd.nextInt(26));
    System.out.println(randomChar);

    randomChar = (char) ('a' + rnd.nextInt(26));
    System.out.println(randomChar);

    randomChar = (char) ('a' + rnd.nextInt(26));
    System.out.println(randomChar);

    randomChar = (char) ('a' + rnd.nextInt(26));
    System.out.println(randomChar);
  }

}
