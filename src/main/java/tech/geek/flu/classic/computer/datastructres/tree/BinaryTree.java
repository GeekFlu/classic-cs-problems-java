package tech.geek.flu.classic.computer.datastructres.tree;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Slf4j
@Getter
@Setter
public class BinaryTree<T> {
  private Node<T> root;

  public List<T> preOrderTraversal(boolean recursive) {
    if (Objects.isNull(root)) {
      return Collections.emptyList();
    }
    if(recursive) {
      return TreeUtils.recursivePreOrderTraversal_DFS(this.root);
    }else{
      return TreeUtils.iterativePreOrderTraversal_DFS(this.root);
    }
  }


}
