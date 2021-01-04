package tech.geek.flu.classic.computer.problems.compress;

import lombok.extern.slf4j.Slf4j;
import tech.geek.flu.classic.computer.datastructres.tree.HuffmanNode;

@Slf4j
public class Huffman {
  private String encoded;
  private HuffmanNode<Character> left;
  private HuffmanNode<Character> right;
}
