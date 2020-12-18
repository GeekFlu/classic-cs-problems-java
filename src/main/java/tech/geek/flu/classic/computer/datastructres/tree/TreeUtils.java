package tech.geek.flu.classic.computer.datastructres.tree;

import lombok.extern.slf4j.Slf4j;
import tech.geek.flu.classic.computer.datastructres.stack.StackLL;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class TreeUtils {

  private TreeUtils(){}

  public static <T> List<T> iterativePreOrderTraversal_DFS(Node<T> root) {
    StackLL<Node<T>> tracker = new StackLL<>();
    List<T> traversalList = new ArrayList<>();
    Node<T> current = root;
    current.setVisited(true);
    tracker.push(current);
    while (!tracker.isEmpty()) {
      current = tracker.top();
      current.setVisited(true);
      traversalList.add(current.getValue());
      tracker.pop();
      if (current.hasRightChild() && !current.getRight().isVisited()) {
        tracker.push(current.getRight());
      }
      if (current.hasLeftChild() && !current.getLeft().isVisited()) {
        tracker.push(current.getLeft());
      }
    }
    return traversalList;
  }

  public static <T> List<T> recursivePreOrderTraversal_DFS(Node<T> root) {
    List<T> traversalOrder = new ArrayList<>();
    preOrder(root, traversalOrder);
    return traversalOrder;
  }

  private static <T> void preOrder(Node<T> root, List<T> traversalOrder) {
    if(Objects.isNull(root)) {
      return;
    }
    // add data to list
    traversalOrder.add(root.getValue());
    // we traverse left sub ree
    preOrder(root.getLeft(), traversalOrder);
    // we traverse right subtree
    preOrder(root.getRight(), traversalOrder);
  }
}
