package tech.geek.flu.classic.computer.datastructres.tree;

import lombok.extern.slf4j.Slf4j;
import tech.geek.flu.classic.computer.datastructres.stack.StackLL;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class TreeUtils {

  private TreeUtils(){}

  public static <T> List<T> iterativePreOrderTraversal_DFS(TreeNode<T> root) {
    StackLL<TreeNode<T>> tracker = new StackLL<>();
    List<T> traversalList = new ArrayList<>();
    TreeNode<T> current = root;
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

  public static <T> List<T> recursivePreOrderTraversal_DFS(TreeNode<T> root) {
    List<T> traversalOrder = new ArrayList<>();
    preOrder(root, traversalOrder);
    return traversalOrder;
  }

  private static <T> void preOrder(TreeNode<T> root, List<T> traversalOrder) {
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

  public static <T> List<T> recursivePostOrderTraversal_DFS(TreeNode<T> root) {
    List<T> traversalOrder = new ArrayList<>();
    postOrder(root, traversalOrder);
    return traversalOrder;
  }

  private static <T> void postOrder(TreeNode<T> root, List<T> traversalOrder) {
    if(Objects.isNull(root)) {
      return;
    }
    // we traverse left sub ree
    postOrder(root.getLeft(), traversalOrder);

    // we traverse right subtree
    postOrder(root.getRight(), traversalOrder);

    // add data to list
    traversalOrder.add(root.getValue());
  }

  private static <T> void inOrder(TreeNode<T> root, List<T> traversalOrder) {
    if(Objects.isNull(root)) {
      return;
    }
    // we traverse left sub ree
    inOrder(root.getLeft(), traversalOrder);

    // add data to list
    traversalOrder.add(root.getValue());

    // we traverse right subtree
    inOrder(root.getRight(), traversalOrder);
  }

  public static <T> List<T> iterativePostOrderTraversal_DFS(TreeNode<T> root) {
    StackLL<TreeNode<T>> stackLL = new StackLL<>();
    stackLL.push(root);
    StackLL<T> traversalOrder = new StackLL<>();
    while (!stackLL.isEmpty()) {
      TreeNode<T> current = stackLL.pop();
      traversalOrder.push(current.getValue());
      if (current.hasLeftChild())
        stackLL.push(current.getLeft());
      if (current.hasRightChild())
        stackLL.push(current.getRight());
    }
    return traversalOrder.toList();
  }
}
