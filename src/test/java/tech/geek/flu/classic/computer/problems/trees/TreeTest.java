package tech.geek.flu.classic.computer.problems.trees;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.geek.flu.classic.computer.datastructres.tree.BinaryTree;
import tech.geek.flu.classic.computer.datastructres.tree.Node;

import java.util.List;

@Slf4j
class TreeTest {
  @Test
  void test_tree_creation() {
    Node<String> root = new Node<>("ROOT");
    Assertions.assertNotNull(root);
    Assertions.assertNotNull(root.getValue());
    Assertions.assertEquals("ROOT", root.getValue());
    Assertions.assertNull(root.getLeft());
    Assertions.assertNull(root.getRight());

    Node<String> left = new Node<>("LEFT");
    root.setLeft(left);
    Assertions.assertNotNull(root.getLeft());
    Assertions.assertEquals("LEFT", root.getLeft().getValue());

    Node<String> right = new Node<>("RIGHT");
    root.setRight(right);
    Assertions.assertNotNull(root.getRight());
    Assertions.assertEquals("RIGHT", root.getRight().getValue());

    Assertions.assertTrue(root.hasLeftChild());
    Assertions.assertTrue(root.hasRightChild());

  }

  @Test
  void pre_order_traversal_iterative() {
    Node<String> root = new Node<>("1");
    root.setLeft(new Node<>("2"));
    root.setRight(new Node<>("6"));

    // for node 2
    Node<String> node_2 = root.getLeft();
    node_2.setLeft(new Node<>("3"));
    node_2.setRight(new Node<>("5"));

    // for node 3
    node_2.getLeft().setLeft(new Node<>("4"));

    // for node 7
    Node<String> node_6 = root.getRight();
    node_6.setLeft(new Node<>("7"));
    node_6.setRight(new Node<>("10"));

    Node<String> node_7 = node_6.getLeft();
    node_7.setLeft(new Node<>("8"));
    node_7.setRight(new Node<>("9"));

    Node<String> node_11 = node_6.getRight();
    node_11.setRight(new Node<>("11"));

    BinaryTree<String> bst = new BinaryTree<>();
    bst.setRoot(root);

    List<String> preOrderTraversal = bst.preOrderTraversal(false);
    Assertions.assertNotNull(preOrderTraversal);
    Assertions.assertEquals("1,2,3,4,5,6,7,8,9,10,11", String.join(",", preOrderTraversal));

    preOrderTraversal = bst.preOrderTraversal(true);
    Assertions.assertNotNull(preOrderTraversal);
    Assertions.assertEquals("1,2,3,4,5,6,7,8,9,10,11", String.join(",", preOrderTraversal));
  }

}
