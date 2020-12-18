package tech.geek.flu.classic.computer.problems.trees;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.geek.flu.classic.computer.datastructres.tree.BinaryTree;
import tech.geek.flu.classic.computer.datastructres.tree.TreeNode;

import java.util.List;

@Slf4j
class TreeTest {
  @Test
  void test_tree_creation() {
    TreeNode<String> root = new TreeNode<>("ROOT");
    Assertions.assertNotNull(root);
    Assertions.assertNotNull(root.getValue());
    Assertions.assertEquals("ROOT", root.getValue());
    Assertions.assertNull(root.getLeft());
    Assertions.assertNull(root.getRight());

    TreeNode<String> left = new TreeNode<>("LEFT");
    root.setLeft(left);
    Assertions.assertNotNull(root.getLeft());
    Assertions.assertEquals("LEFT", root.getLeft().getValue());

    TreeNode<String> right = new TreeNode<>("RIGHT");
    root.setRight(right);
    Assertions.assertNotNull(root.getRight());
    Assertions.assertEquals("RIGHT", root.getRight().getValue());

    Assertions.assertTrue(root.hasLeftChild());
    Assertions.assertTrue(root.hasRightChild());

  }

  @Test
  void pre_order_traversal_iterative() {
    TreeNode<String> root = new TreeNode<>("1");
    root.setLeft(new TreeNode<>("2"));
    root.setRight(new TreeNode<>("6"));

    // for node 2
    TreeNode<String> treeNode_2 = root.getLeft();
    treeNode_2.setLeft(new TreeNode<>("3"));
    treeNode_2.setRight(new TreeNode<>("5"));

    // for node 3
    treeNode_2.getLeft().setLeft(new TreeNode<>("4"));

    // for node 7
    TreeNode<String> treeNode_6 = root.getRight();
    treeNode_6.setLeft(new TreeNode<>("7"));
    treeNode_6.setRight(new TreeNode<>("10"));

    TreeNode<String> treeNode_7 = treeNode_6.getLeft();
    treeNode_7.setLeft(new TreeNode<>("8"));
    treeNode_7.setRight(new TreeNode<>("9"));

    TreeNode<String> treeNode_11 = treeNode_6.getRight();
    treeNode_11.setRight(new TreeNode<>("11"));

    BinaryTree<String> bst = new BinaryTree<>();
    bst.setRoot(root);

    List<String> preOrderTraversal = bst.preOrderTraversal(false);
    Assertions.assertNotNull(preOrderTraversal);
    Assertions.assertEquals("1,2,3,4,5,6,7,8,9,10,11", String.join(",", preOrderTraversal));

    preOrderTraversal = bst.preOrderTraversal(true);
    Assertions.assertNotNull(preOrderTraversal);
    Assertions.assertEquals("1,2,3,4,5,6,7,8,9,10,11", String.join(",", preOrderTraversal));
  }

  @Test
  void post_order_traversal_iterative() {
    TreeNode<String> root = new TreeNode<>("1");
    root.setLeft(new TreeNode<>("2"));
    root.setRight(new TreeNode<>("6"));

    // for node 2
    TreeNode<String> treeNode_2 = root.getLeft();
    treeNode_2.setLeft(new TreeNode<>("3"));
    treeNode_2.setRight(new TreeNode<>("5"));

    // for node 3
    treeNode_2.getLeft().setLeft(new TreeNode<>("4"));

    // for node 6
    TreeNode<String> treeNode_6 = root.getRight();
    treeNode_6.setLeft(new TreeNode<>("7"));
    treeNode_6.setRight(new TreeNode<>("10"));

    TreeNode<String> treeNode_7 = treeNode_6.getLeft();
    treeNode_7.setLeft(new TreeNode<>("8"));
    treeNode_7.setRight(new TreeNode<>("9"));

    TreeNode<String> treeNode_11 = treeNode_6.getRight();
    treeNode_11.setRight(new TreeNode<>("11"));

    BinaryTree<String> bst = new BinaryTree<>();
    bst.setRoot(root);

    List<String> postOrderTraversal = bst.postOrderTraversal(false);
    Assertions.assertNotNull(postOrderTraversal);
    Assertions.assertEquals("4,3,5,2,8,9,7,11,10,6,1", String.join(",", postOrderTraversal));

    postOrderTraversal = bst.postOrderTraversal(true);
    Assertions.assertNotNull(postOrderTraversal);
    Assertions.assertEquals("4,3,5,2,8,9,7,11,10,6,1", String.join(",", postOrderTraversal));
  }

  @Test
  void in_order_traversal_iterative() {
    TreeNode<String> root = new TreeNode<>("1");
    root.setLeft(new TreeNode<>("2"));
    root.setRight(new TreeNode<>("6"));

    // for node 2
    TreeNode<String> treeNode_2 = root.getLeft();
    treeNode_2.setLeft(new TreeNode<>("3"));
    treeNode_2.setRight(new TreeNode<>("5"));

    // for node 3
    treeNode_2.getLeft().setLeft(new TreeNode<>("4"));

    // for node 6
    TreeNode<String> treeNode_6 = root.getRight();
    treeNode_6.setLeft(new TreeNode<>("7"));
    treeNode_6.setRight(new TreeNode<>("10"));

    TreeNode<String> treeNode_7 = treeNode_6.getLeft();
    treeNode_7.setLeft(new TreeNode<>("8"));
    treeNode_7.setRight(new TreeNode<>("9"));

    TreeNode<String> treeNode_11 = treeNode_6.getRight();
    treeNode_11.setRight(new TreeNode<>("11"));

    BinaryTree<String> bst = new BinaryTree<>();
    bst.setRoot(root);

    List<String> postOrderTraversal = bst.postOrderTraversal(false);
    Assertions.assertNotNull(postOrderTraversal);
    Assertions.assertEquals("4,3,5,2,8,9,7,11,10,6,1", String.join(",", postOrderTraversal));

    postOrderTraversal = bst.postOrderTraversal(true);
    Assertions.assertNotNull(postOrderTraversal);
    Assertions.assertEquals("4,3,5,2,8,9,7,11,10,6,1", String.join(",", postOrderTraversal));
  }

}
