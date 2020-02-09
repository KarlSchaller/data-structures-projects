import java.util.*;

public class Problem1Tree {
   private static List<Integer> nodeList = new LinkedList<>();

   // returns a list of binary-tree nodes in in-order.
   public static List<Integer> createList(TreeNode<Integer> node) {

      if (node.left != null)
         createList(node.left);
      nodeList.add(node.data);
      if (node.right != null)
         createList(node.right);

      return nodeList;
   }

   public static void main(String[] args) {
      // Declare the 11 nodes for the problem 1 example
      TreeNode               root,
                  node1,                node2,
          node3,         node4,     node5,
      node6, node7,  node8,  node9,    node10;

      // Initialize problem 1 tree data
      root = new TreeNode(49);
      node1 = new TreeNode(21);
      node2 = new TreeNode(68);
      node3 = new TreeNode(20);
      node4 = new TreeNode(40);
      node5 = new TreeNode(55);
      node6 = new TreeNode(11);
      node7 = new TreeNode(19);
      node8 = new TreeNode(33);
      node9 = new TreeNode(44);
      node10 = new TreeNode(66);

      // link the nodes as shown in the picture
      // (the tree picture is in the homework instructions)
      root.left = node1; root.right = node2;
      node1.left = node3; node1.right = node4;
      node2.left = node5;
      node3.left = node6; node3.right = node7;
      node4.left = node8; node4.right = node9;
      node5.right = node10;

      // print the list of tree nodes
      System.out.println(createList(root));
      //System.out.println(createList(node3));
   }
}
