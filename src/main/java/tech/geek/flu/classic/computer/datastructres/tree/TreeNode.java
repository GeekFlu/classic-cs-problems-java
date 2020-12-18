package tech.geek.flu.classic.computer.datastructres.tree;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@Getter
@Setter
public class TreeNode<T> {
  private T value;
  private TreeNode<T> left;
  private TreeNode<T> right;
  private boolean isVisited;

  public TreeNode(T value){
    this.value = value;
  }

  public boolean hasLeftChild(){
    return Objects.nonNull(this.left);
  }

  public boolean hasRightChild(){
    return Objects.nonNull(this.right);
  }
}
