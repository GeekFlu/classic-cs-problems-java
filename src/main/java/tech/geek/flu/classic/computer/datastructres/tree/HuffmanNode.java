package tech.geek.flu.classic.computer.datastructres.tree;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class HuffmanNode<T> {
  private Integer frequency;
  private T letter;
  private HuffmanNode<T> left;
  private HuffmanNode<T> right;
  private boolean isInternal;

  @Override
  public String toString() {
    return "HuffmanNode{" +
        "frequency=" + frequency +
        ", value=" + letter +
        ", left=" + left +
        ", right=" + right +
        '}';
  }

  public boolean hasLeft() {
    return this.left != null;
  }

  public boolean hasRight() {
    return this.right != null;
  }

  public boolean isLeaf() {
    return !hasLeft() && !hasRight();
  }
}
