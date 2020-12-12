package tech.geek.flu.classic.computer.problems.trees;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.geek.flu.classic.computer.datastructres.tree.Node;

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

}
