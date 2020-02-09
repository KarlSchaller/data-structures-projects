// class TreeNode definition
class TreeNode<T extends Comparable<T>> {
   // package access members
   TreeNode<T> leftNode;
   T data; // node value
   TreeNode<T> rightNode;

   // constructor initializes data and makes this a leaf node
   public TreeNode(T nodeData) {
      data = nodeData;
      leftNode = rightNode = null; // node has no children
   }

   // locate insertion point and insert new node; ignore duplicate values
   public void insert(T insertValue) {
      // insert in left subtree
      if (insertValue.compareTo(data) < 0) {
         // insert new TreeNode
         if (leftNode == null)
            leftNode = new TreeNode<T>(insertValue);
         else // continue traversing left subtree recursively
            leftNode.insert(insertValue);
      }
      // insert in right subtree
      else if (insertValue.compareTo(data) > 0) {
         // insert new TreeNode
         if (rightNode == null)
            rightNode = new TreeNode<T>(insertValue);
         else // continue traversing right subtree recursively
            rightNode.insert(insertValue);
      }
   }
} // end class TreeNode

// class Tree definition
public class Tree<T extends Comparable<T>> {
   private TreeNode<T> root;

   // constructor initializes an empty Tree of integers
   public Tree() { root = null; }

   // insert a new node in the binary search tree
   public void insertNode(T insertValue) {
       if (root == null)
           root = new TreeNode<T>(insertValue); // create root node
       else
           root.insert(insertValue); // call the insert method
   }

   // begin preorder traversal
   public void preorderTraversal() {
      preorderHelper(root);
   }

   // recursive method to perform preorder traversal
   private void preorderHelper(TreeNode<T> node) {
       if (node == null) return;

       System.out.printf("%s ", node.data); // output node data
       preorderHelper(node.leftNode); // traverse left subtree
       preorderHelper(node.rightNode); // traverse right subtree
   }

   // begin inorder traversal
   public void inorderTraversal() {
      inorderHelper(root);
   }

   // recursive method to perform inorder traversal
   private void inorderHelper(TreeNode<T> node) {
       if (node == null)  return;

       inorderHelper(node.leftNode); // traverse left subtree
       System.out.printf("%s ", node.data); // output node data
       inorderHelper(node.rightNode); // traverse right subtree
   }

   // begin postorder traversal
   public void postorderTraversal() {
      postorderHelper(root);
   }

   // recursive method to perform postorder traversal
   private void postorderHelper(TreeNode<T> node) {
       if (node == null) return;

       postorderHelper(node.leftNode); // traverse left subtree
       postorderHelper(node.rightNode); // traverse right subtree
       System.out.printf("%s ", node.data); // output node data
   }

   ///////////////////////////////////////////////////////////////////
   //////////////////// ADD YOUR OWN METHODS BELOW ///////////////////
   ///////////////////////////////////////////////////////////////////

   // return a reference to the root of this tree
   public TreeNode<T> getRoot() { return this.root;}

   // display this tree with rows output vertically
   public void outputTree() {
      outputTree(root, 0);
   }

   // recursive method to output tree
   private void outputTree(TreeNode<T> node, int totalSpaces) {
       while (node != null) {
           outputTree(node.rightNode, totalSpaces+5);
           for (int i = 0; i < totalSpaces; i++)
               System.out.print(" ");
           System.out.printf("%s\n", node.data);
           node = node.leftNode;
           totalSpaces += 5;
       }
   }

   // get the depth of this node
   private int depth(TreeNode<T> node) {
      // YOUR CODE HERE
       if (node == null) return 0;

       int leftDepth = (depth(node.leftNode));
       int rightDepth = (depth(node.rightNode));
       if (leftDepth > rightDepth) return leftDepth+1;
       return rightDepth+1;
   }

   // get depth of this tree
   public int depth() {
      return depth(this.root);
   }

   // search for key in this tree
   public T contains(T key) {
       TreeNode<T> current = root;
       while (current != null && current.data != key) {
          if (key.compareTo(current.data) > 0)
              current = current.rightNode;
          else
              current = current.leftNode;
       }
       if (current == null) return null;
       return current.data;
   }

   // level-order or breadth-first-order traversal
   public void levelOrder() {
       Queue<TreeNode<T>> nodeQueue = new Queue<>();
       nodeQueue.enqueue(root);

       while (!nodeQueue.isEmpty()) {
           int queueSize = nodeQueue.size();
           for (int i = 0; i < queueSize; i++) {
               TreeNode<T> next = nodeQueue.dequeue();
               System.out.printf("%s ", next.data);
               if (next.leftNode != null)
                   nodeQueue.enqueue(next.leftNode);
               if (next.rightNode != null)
                   nodeQueue.enqueue(next.rightNode);
           }
           System.out.println();
       }
   }
} // end class Tree

