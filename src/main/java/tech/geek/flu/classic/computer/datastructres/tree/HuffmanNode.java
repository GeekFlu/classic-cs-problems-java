package tech.geek.flu.classic.computer.datastructres.tree;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Builder
public class HuffmanNode<T> {
  private int frequency;
  private T value;
  private HuffmanNode<T> left;
  private HuffmanNode<T> right;
}
