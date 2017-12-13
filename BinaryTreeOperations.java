package com.example.serialization;

import java.util.Queue;

public class BinaryTreeOperations {

	
	public static void main(String[] args) {
						
		//1.Check given tree is foldable or not
		BinaryTree btree8=new BinaryTree();
		BinaryTree btree9=new BinaryTree();
		
		btree8.addNode(20);
		btree8.addNode(8);
		btree8.addNode(22);
		btree8.addNode(12);
		btree8.addNode(4);
		btree8.addNode(14);
		btree8.addNode(10);
						
		btree9.addNode(10);
		btree9.addNode(2);
		btree9.addNode(1);
		btree9.addNode(3);
		btree9.addNode(15);
		btree9.addNode(14);
		btree9.addNode(16);
		
		if(btree8.isFoldable()){
			System.out.println("Tree is Foldable\n");
		}else{
			System.out.println("Tree is not Foldable\n");
		}
		if(btree9.isFoldable()){
			System.out.println("Tree is Foldable\n");
		}else{
			System.out.println("Tree is not Foldable\n");
		}
		
		
		//2.Check whether two given trees are mirror to each other	
		BinaryTree btree10=new BinaryTree();
		BinaryTree btree11=new BinaryTree();
		
		btree10.setRootNode(new Node(10));
		btree10.getRootNode().leftNode=new Node(5);
		btree10.getRootNode().rightNode=new Node(20);
		btree10.getRootNode().leftNode.leftNode=new Node(3);
		btree10.getRootNode().leftNode.rightNode=new Node(8);
		btree10.getRootNode().leftNode.rightNode.leftNode=new Node(7);
		btree10.getRootNode().rightNode.leftNode=new Node(18);
		btree10.getRootNode().rightNode.rightNode=new Node(25);
		
		btree11.setRootNode(new Node(10));
		btree11.getRootNode().leftNode=new Node(20);
		btree11.getRootNode().leftNode.leftNode=new Node(25);
		btree11.getRootNode().leftNode.rightNode=new Node(18);
		btree11.getRootNode().rightNode=new Node(5);
		btree11.getRootNode().rightNode.leftNode=new Node(8);
		btree11.getRootNode().rightNode.leftNode.rightNode=new Node(7);
		btree11.getRootNode().rightNode.rightNode=new Node(3);
		
		if(btree10.isMirror(btree10.getRootNode(), btree11.getRootNode())){
			System.out.println("Tree1 and Tree2 are mirror to  each other\n");
		}else{
			System.out.println("Tree1 and Tree2 are not mirror to  each other\n");
		}
		
		
		//3.check whether tree is identical or not
		BinaryTree btree1=new BinaryTree();
		BinaryTree btree2=new BinaryTree();
		btree1.addNode(20);
		btree1.addNode(8);
		btree1.addNode(22);
		btree1.addNode(12);
		btree1.addNode(4);
		btree1.addNode(14);
		btree1.addNode(10);
		//btree1.addNode(9); //uncomment for check hieght of tree
		
		btree2.addNode(20);
		btree2.addNode(8);
		btree2.addNode(22);
		btree2.addNode(12);
		btree2.addNode(4);
		btree2.addNode(14);
		btree2.addNode(10);
				
		if(btree1.isIdentical(btree1.getRootNode(), btree2.getRootNode())){
			System.out.println("Tree1 and Tree2 are identical\n");
		}else{
			System.out.println("Tree1 and Tree2 are not identical\n");
		}
		
		//4.print Inorder, postorder and preorder traversal
		btree1.printTree("inorder",btree1.getRootNode());
		btree1.printTree("postorder",btree1.getRootNode());
		btree1.printTree("preorder",btree1.getRootNode());
		
		//5.print level order traversal
		btree1.levelOrderTraversal(btree1.getRootNode());
		
		//6.print minimum value of tree
		btree1.printMinimumElement(btree1.getRootNode());
		
		//7.print maximum value of tree
		btree1.printMaximumElement(btree1.getRootNode());
		
		//8.Find Height or Maximum Depth of Binary Tree 
		btree1.findHightOrMaxDepth(btree1.getRootNode());
		
		//9.Calculate size of tree.
		btree1.size(btree1.getRootNode());
		
		//10.Convert Binary Tree into Double Linked List.
		//Queue approach Binary To Double Linked List:
		BinaryTree btree3=new BinaryTree();
		btree3.addNode(20);
		btree3.addNode(8);
		btree3.addNode(22);
		btree3.addNode(12);
		btree3.addNode(4);
		btree3.addNode(14);
		btree3.addNode(10);		
		btree3.binaryToDLL(btree3.getRootNode());
		
		//Second approach Binary to Double Linked List
		BinaryTree btree4=new BinaryTree();
		btree4.addNode(20);
		btree4.addNode(8);
		btree4.addNode(22);
		btree4.addNode(12);
		btree4.addNode(4);
		btree4.addNode(14);
		btree4.addNode(10);
		btree4.BinaryTree2DoubleLinkedList(btree4.getRootNode());
		
		//11.Print all nodes which don't have sibling and all sibling
		BinaryTree btree5=new BinaryTree();
		btree5.setRootNode(new Node(1));
        btree5.getRootNode().leftNode = new Node(2);
        btree5.getRootNode().rightNode = new Node(3);
        btree5.getRootNode().leftNode.rightNode = new Node(4);
        btree5.getRootNode().rightNode.leftNode = new Node(5);
        btree5.getRootNode().rightNode.leftNode.rightNode = new Node(6);
        btree5.getRootNode().rightNode.leftNode.leftNode = new Node(7);
        btree5.getRootNode().rightNode.leftNode.leftNode.leftNode = new Node(8);
        System.out.println("\nThese nodes have not sibling (have not same parent).");
        btree5.findNotSibling(btree5.getRootNode());        
        System.out.println("\nThese nodes are sibling:");
        btree5.findSibling(btree5.getRootNode());
        
        //12.Convert Mirror of Binary Tree
        BinaryTree btree6=new BinaryTree();
		btree6.setRootNode(new Node(1));
        btree6.getRootNode().leftNode = new Node(2);
        btree6.getRootNode().rightNode = new Node(3);
        btree6.getRootNode().leftNode.rightNode = new Node(4);
        btree6.getRootNode().rightNode.leftNode = new Node(5);
        btree6.getRootNode().rightNode.leftNode.rightNode = new Node(6);
        btree6.convertBinaryTreeToMirror(btree6.getRootNode());
        
      //13.Print all path from Root to leaf node.
        BinaryTree btree7=new BinaryTree();
		btree7.setRootNode(new Node(1));
        btree7.getRootNode().leftNode = new Node(2);
        btree7.getRootNode().rightNode = new Node(3);
        btree7.getRootNode().leftNode.rightNode = new Node(4);
        btree7.getRootNode().rightNode.leftNode = new Node(5);
        btree7.getRootNode().rightNode.leftNode.rightNode = new Node(6);
        btree7.getRootNode().leftNode.leftNode=new Node(8);
        btree7.getRootNode().leftNode.leftNode.leftNode=new Node(9);
        btree7.getRootNode().leftNode.leftNode.rightNode=new Node(10);
        btree7.printPathFromRootToLeaf(btree7.getRootNode());
        
        //14.Construct Binary with given Inorder and Preorder travsersal
        int inOrder[] =   {20, 30, 35, 40, 45, 50, 55, 60, 70};
        int postOrder[] = {20, 35, 30, 45, 40, 55, 70, 60, 50};
        BinaryTree btree12=new BinaryTree();
        System.out.println("\nConstructed Binary Tree from Inorder and Postorder:");
        btree12.constructBtreeFromInorderPostOrder(inOrder, postOrder);
        
        //15.Check whether Binary tree is balanced or not
        BinaryTree btree13=new BinaryTree();
        btree13.setRootNode(new Node(1));
		btree13.getRootNode().rightNode = new Node(3);
		btree13.getRootNode().leftNode=new Node(2);
		btree13.getRootNode().leftNode.leftNode = new Node(4);
		btree13.getRootNode().leftNode.rightNode = new Node(5);
		btree13.getRootNode().leftNode.rightNode.leftNode = new Node(7);
		btree13.getRootNode().rightNode.rightNode = new Node(6);
		if(btree13.isBalancedTree(btree13.getRootNode())){
			System.out.println("\nTree is balanced!!");
		}else{
			System.out.println("\nTree is not balanced!!");
		}
		//we added one extra node to left-subtree then check again
		btree13.getRootNode().leftNode.rightNode.leftNode.rightNode = new Node(8);	
		if(btree13.isBalancedTree(btree13.getRootNode())){
			System.out.println("\nTree is balanced!!");
		}else{
			System.out.println("\nTree is not balanced!!");
		}
		
		//16.Check whether Binary Tree is Binary Search Tree(BST) or not.
		BinaryTree btree14=new BinaryTree();
        btree14.setRootNode(new Node(1));
		btree14.getRootNode().rightNode = new Node(3);
		btree14.getRootNode().leftNode=new Node(2);
		btree14.getRootNode().leftNode.leftNode = new Node(4);
		btree14.getRootNode().leftNode.rightNode = new Node(5);
		btree14.getRootNode().leftNode.rightNode.leftNode = new Node(7);
		btree14.getRootNode().rightNode.rightNode = new Node(6);
		boolean isBst=btree14.isBsT(btree14.getRootNode());
		if(isBst){
			System.out.println("\nTree is Binary Search Tree(BST).");
		}else{
			System.out.println("\nTree is not Binary Search Tree(BST).");
		}
		btree14.printTree("inorder", btree14.getRootNode());
		
		btree14=new BinaryTree();
		btree14.addNode(20);
		btree14.addNode(8);
		btree14.addNode(22);
		btree14.addNode(12);
		btree14.addNode(4);
		btree14.addNode(14);
		btree14.addNode(10);	
		isBst=btree14.isBsT(btree14.getRootNode());
		if(isBst){
			System.out.println("\nTree is Binary Search Tree(BST).");
		}else{
			System.out.println("\nTree is not Binary Search Tree(BST).");
		}
		btree14.printTree("inorder", btree14.getRootNode());
	}

}
class Node{
	int data;
	Node leftNode;
	Node rightNode;
	public Node(){
		
	}
	public Node(int data){
		this.data=data;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}
	public Node getRightNode() {
		return rightNode;
	}
	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	
}
class BinaryTree{
	
	private  Node rootNode;
		
	public Node getRootNode() {
		return rootNode;
	}

	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}

	//add operation using recursive approach.
	public  void addNode(int data){
		Node newNode=new Node(data);
		if(rootNode == null){
			rootNode=newNode;
			return;
		}
		addNode(rootNode,newNode);
	}
    //adding node to Binary Search Tree where new node data less than root will go to left and greater go to right. 
	private  void addNode(Node rootNode,Node newNode) {
		if(rootNode != null){
			if(newNode.data < rootNode.data){
				if(rootNode.leftNode != null){
					addNode(rootNode.leftNode,newNode);
				}else{
					rootNode.leftNode=newNode;
					return;
				}
			}else if(newNode.data > rootNode.data){
				if(rootNode.rightNode != null){
					addNode(rootNode.rightNode,newNode);
				}else{
					rootNode.rightNode=newNode;
					return;
				}
			}
		}		
	}
	//4.print Inorder, postorder and preorder traversal
	public  void printTree(String order,Node rootNode){
		
		if(rootNode == null){
			System.out.println("\nTree is empty!!");
			return;
		}else{
			if("INORDER".equalsIgnoreCase(order.toUpperCase())){			
				System.out.print("\nInorder:");			
				printInOrderTree(rootNode);	
				System.out.println();
			}
			else if("PREORDER".equalsIgnoreCase(order.toUpperCase())){
				System.out.print("\nPreorder:");			
				printPreOrderTree(rootNode);	
				System.out.println();
			}
			else if("POSTORDER".equalsIgnoreCase(order.toUpperCase())){
				System.out.print("\nPostorder:");			
				printPostOrderTree(rootNode);	
				System.out.println();
			}else{
				System.out.println("\nInvalid parameter:enter<inoorder><preorder><postorder>");
			}
		}
	}
	
	/*
	 * Inorder: Left -> Root -> Right
	 */
	private void printInOrderTree(Node rootNode) {
		if(rootNode != null){
			printInOrderTree(rootNode.leftNode);
			System.out.print(rootNode.data+"->");
			printInOrderTree(rootNode.rightNode);
		}
	}
	/*
	 * Preorder: Root -> Left -> Right
	 */
	private void printPreOrderTree(Node rootNode) {
		if(rootNode != null){
			System.out.print(rootNode.data+"->");
			printPreOrderTree(rootNode.leftNode);			
			printPreOrderTree(rootNode.rightNode);
		}
	}
	/*
	 * Postorder: Left -> Right -> Root
	 */
	private void printPostOrderTree(Node rootNode) {
		if(rootNode != null){
			printPostOrderTree(rootNode.leftNode);			
			printPostOrderTree(rootNode.rightNode);
			System.out.print(rootNode.data+"->");
		}
	}
	
	//1.Check given tree is foldable or not
	/*
	  A tree can be folded if left and right subtrees of the tree are structure wise mirror image of each other. 
	  same algorithm to check ismirror but here not consider data.
	  Left subtree of root of ‘tree1’ and right subtree root of ‘tree2’ are mirror.
	  Right subtree of ‘tree1’ and left subtree of ‘tree2’ are mirror.
	 */
	public  boolean isFoldable(){
		if(rootNode == null){
			return true;
		}
		return isFoldable(rootNode.leftNode,rootNode.rightNode);
	}

	private  boolean isFoldable(Node rootLeftNode, Node rootRightNode) {
		
		if(rootLeftNode == null && rootRightNode == null){
			return true;
		}
		if(rootLeftNode == null || rootRightNode == null){
			return false;
		}
		
		boolean left=isFoldable(rootLeftNode.leftNode,rootRightNode.rightNode);
		boolean right=isFoldable(rootRightNode.rightNode,rootLeftNode.leftNode);
		
		return (left && right);
	}
	
	//2.Check whether two given trees are mirror to each other
	/*
	    For two trees ‘tree1’ and ‘tree2’ to be mirror images, the following three conditions must be true:
		Their root node’s key must be same
		Left subtree of root of ‘tree1’ and right subtree root of ‘tree2’ are mirror.
		Right subtree of ‘tree1’ and left subtree of ‘tree2’ are mirror.
	 */
	public boolean isMirror(Node tree1,Node tree2){
		if(tree1 == null && tree2 == null){
			return true;
		}
		if(tree1 == null || tree2 == null){
			return false;
		}
		
		boolean left=isMirror(tree1.leftNode,tree2.rightNode);
		boolean right=isMirror(tree1.rightNode,tree2.leftNode);
		
		return ((tree1.data == tree2.data)&&(left && right));
	}
	
	//3.check whether tree is identical or not
	/*
	    For two trees ‘tree1’ and ‘tree2’ are identical, the following three conditions must be true:
		Their node data must be same
		Left subtree of root of ‘tree1’ and left subtree root of ‘tree2’ must be same.
		Right subtree of ‘tree1’ and right subtree of ‘tree2’ must be same.
	*/
	public boolean isIdentical(Node tree1,Node tree2){
		if(tree1 == null && tree2 ==null){
			return true;
		}
		if(tree1 == null || tree2 ==null){
			return false;
		}
		
		boolean left=isIdentical(tree1.leftNode,tree2.leftNode);
		boolean right=isIdentical(tree1.rightNode,tree2.rightNode);
		
		return ((tree1.data == tree2.data)&&(left && right));
	}
	
	//5.print level order traversal
	/*
	   We will use queue for collecting tree node of every level
	   take out node from queue and print one by one
	   if node's left not null then add to queue.
	   if node's right not null then add to queue.
	 */
	public void levelOrderTraversal(Node rootNode){
		System.out.print("\nLevelOrderTraversal:");
		if(rootNode != null){
			Queue<Node> queue=new java.util.LinkedList<Node>();
			queue.add(rootNode);
			
			while(!queue.isEmpty()){
				Node node=queue.poll();
				System.out.print(node.data+" ->");
				if(node.leftNode != null){
					queue.add(node.leftNode);
				}
				if(node.rightNode != null){
					queue.add(node.rightNode);
				}
			}
			System.out.println();
		}else{
			System.out.println("\nTree is empty!!");
		}
	}
	
	//6.print minimum value of tree
	public void printMinimumElement(Node root){
		if(root == null){
			System.out.println("\nTree is empty!");
		}else{
			Node minNode=printMinElement(root);
			System.out.println("\nMinimum Element:"+minNode.data);
		}
	}
	
	//7.print maximum value of tree
	public void printMaximumElement(Node root){
		if(root == null){
			System.out.println("\nTree is empty!");
		}else{
			Node minNode=printMaxElement(root);
			System.out.println("\nMaximum Element:"+minNode.data);
		}
	}
	//find minimum element from binary search tree
	//the minimum element lies on left subtree.
	//we will traverse left subtree of tree to the leaf node and the leaf node is minimum.
	private Node printMinElement(Node root){	
		
		if(root.leftNode == null){
			return root;
		}
		return printMinElement(root.leftNode);					
	}
	//find maximum element from binary search tree
	//the maximum element lies on right subtree of tree.
	//we will traverse right subtree of tree to the leaf node and the leaf node is maximum.
	private Node printMaxElement(Node root){	
		
		if(root.rightNode == null){
			return root;
		}
		return printMinElement(root.rightNode);					
	}
	
	//8.Find Height or Maximum Depth of Binary Tree 
	/*
	   Compute the "maxDepth" of a tree -- the number of 
       nodes along the longest path from the root node 
       down to the farthest leaf node.
       Algorithm:
        maxDepth()
		1. If tree is empty then return 0
		2. Else
		     (a) Get the max depth of left subtree recursively  i.e., 
		          call maxDepth( tree->left-subtree)
		     (a) Get the max depth of right subtree recursively  i.e., 
		          call maxDepth( tree->right-subtree)
		     (c) Get the max of max depths of left and right subtrees and add 1 to it for the current node.
		         max_depth = max(max dept of left subtree,  
		                             max depth of right subtree) 
		                             + 1
		     (d) Return max_depth
	 */
	/*
	maxDepth('1') = max(maxDepth('2'), maxDepth('3')) + 1
                               = 2 + 1
                                  /    \
                                /         \
                              /             \
                            /                 \
                          /                     \
               maxDepth('1')                  maxDepth('3') = 1
			   = max(maxDepth('4'), maxDepth('5')) + 1
			   = 1 + 1  = 2         
                   /    \
                 /        \
               /            \
             /                \
           /                    \
 maxDepth('4') = 1     maxDepth('5') = 1
	 
	 */
	public void findHightOrMaxDepth(Node root){
		if(root == null){
			System.out.println("\nHieght of tree:0");
			return;
		}
		int hieght=maxDepth(root);
		System.out.println("\nHieght or Max Depth of Tree:"+hieght);
	}

	private int maxDepth(Node root) {
		if(root == null){
			//base case
			return 0;
		}else{
			int leftDepth=maxDepth(root.leftNode);
			int rightDepth=maxDepth(root.rightNode);
			
			if(leftDepth > rightDepth){
				return leftDepth+1;
			}else{
				return rightDepth+1;
			}
		}
	}
	
	//9.Calculate size of tree.
	public void size(Node root){
		if(root == null){
			System.out.println("\nSize:"+0);
			return;
		}
		int size=sizeOfTree(root);
		System.out.println("\nSize of tree is:"+size);
	}
	//Find the size of binary tree
	//size of tree is total node
	//siz=size of left subtree + size of right subtree + 1
	private int sizeOfTree(Node root){
		if(root == null){
			return 0;
		}
		int leftSize=sizeOfTree(root.leftNode);
		int rightSize=sizeOfTree(root.rightNode);
		
		return (leftSize+rightSize+1);
	}
	//10.Convert Binary Tree into Double Linked List.
	
	/* Do inorder travsersal and put visited root into queue
	 * dequeue first node make head node.create a prev node and point to head node
	 * if queue is not empty then take out node one by one and put into next node
	 * 
	 */
	public void binaryToDLL(Node root){
		if(root == null){
			System.out.println("\nTree is Empty!");
			return;			
		}
		Queue<Node> queue=new java.util.LinkedList<Node>();
		convertBinaryToDLL(root,queue);
		//create DLL from queue
		Node head=null;
		Node nextNode=null;
		Node prevNode=null;
		
		head=queue.poll();
		prevNode=head;
		
		while(!queue.isEmpty()){
							
				nextNode=queue.poll();
				prevNode.rightNode=nextNode;
				nextNode.leftNode=prevNode;
				prevNode=nextNode;//move prevnode to current position.
			
		}
		//print data of DLL
		System.out.println("\nQueue approach Binary to Double linked list:");
		Node curr=head;
		Node back=null;
		while(curr != null){
			System.out.print(curr.data+"->");
			back=curr;
			curr=curr.rightNode;			
		}
		System.out.println("\nReverse printing of DLL:");
		while(back != null){
			System.out.print(back.data+"->");
			back=back.leftNode;
		}
	}
   /*
    * Do inorder traversal and marked root and put it into queue.
    */
	private void convertBinaryToDLL(Node root, Queue<Node> queue) {

		if(root != null){
			convertBinaryToDLL(root.leftNode,queue);
			queue.add(root);
			convertBinaryToDLL(root.rightNode,queue);
		}
	}
	
	//10.Convert Binary Tree into Double Linked List.
	/*
	 * Convert Binary Tree to Double linked list
	 * In this approach, we will do inorder traversal and make changes of visited root.
	 */
	public void BinaryTree2DoubleLinkedList(Node root){
		if(root == null){
			System.out.println("\nTree is empty!");
			return;
		}
		//Node head=null;
		System.out.println();
		BinaryToDoubleLinkedList(root);
		
		Node curr=head;
		System.out.println("\nSecond approach binary to DLL:");
		while(curr != null){
			System.out.print(curr.data+"->");
			curr=curr.rightNode;
		}
	}
	Node prev=null;
	Node head=null;
	private void BinaryToDoubleLinkedList(Node root) 
    {
        // Base case        
		if(root != null){
	        // Recursively convert left subtree
	        BinaryToDoubleLinkedList(root.leftNode);
	  
	        // Now convert this node
	        if (head == null) 
	            head = root;
	        else
	        {
	            root.leftNode = prev;
	            prev.rightNode = root;
	        }
	        prev = root;
	  	       
	        //Finally convert right subtree
	        BinaryToDoubleLinkedList(root.rightNode);        
		}
    }
	/*
	 * Print all nodes which don't have sibling
	 * a sibling is a node that has same parent. In a Binary Tree, there can be at most one sibling
	 * Traverse inorder and mark root,
	 * if left node of root is null but right node is not null then print right node data
	 * if right node of root is null but left node is not null then print left node data
	 */
	public void findNotSibling(Node root){
		if(root != null){
			findNotSibling(root.leftNode);
			
			if(root.leftNode == null && root.rightNode != null){
				System.out.print(root.rightNode.data+",");
			}else if(root.leftNode != null && root.rightNode == null){
				System.out.print(root.leftNode.data+",");
			}
			
			findNotSibling(root.rightNode);
		}
	}
	/*
	 * Print all nodes which are sibling
	 * a sibling is a node that has same parent. In a Binary Tree, there can be at most one sibling
	 * Traverse inorder and mark root,
	 * if left node of root and right node of root is not null then print left node and right node data	 
	 */
	public void findSibling(Node root){
		if(root != null){
			findSibling(root.leftNode);
			
			if(root.leftNode != null && root.rightNode != null){
				System.out.print(root.rightNode.data+","+root.leftNode.data +" have same parent "+root.data+"\n");
			}
			
			findSibling(root.rightNode);
		}
	}
  
	//12.Convert Mirror of Binary Tree
	public void convertBinaryTreeToMirror(Node root){
		if(root == null){
			System.out.println("\nTree is Empty!");
		}
		System.out.println("\nBefore mirror:");
		printTree("inorder",root);
		binaryToMirror(root);
		System.out.println("\nAfter mirror:");
		printTree("inorder",root);
	}
    /*
     * Mirror of Binary Tree:
     * Traverse left subtree
     * Traverse right subtree
     * Swap left-subtree and right-subtree
     */
	private void binaryToMirror(Node root) {

		if(root != null){
			binaryToMirror(root.leftNode);
			binaryToMirror(root.rightNode);
	
			Node temp=root.leftNode;
			root.leftNode=root.rightNode;
			root.rightNode=temp;				
		}
	
	}
	//13.Print all path from Root to leaf node.
	/*
	 * Print all path from root node to leaf node in each line.
	 * We do pre-order traversal of binary tree
	 * we visit root and put it into array
	 * we will check if root' left and right both are null then print array else tarverse left subtree and right sub tree
	 */
	public void printPathFromRootToLeaf(Node root){
		if(root == null){
			System.out.println("\nTree is Empty!");
			return;
		}
		
		int path[] = new int[1000];
		System.out.println("\nAll paths from Root to Leaf Node:");
		printPathFromRootToLeaf(root,path,0);		
	}

	private void printPathFromRootToLeaf(Node root, int[]path,int pathlen) {

		if(root != null){
								
			path[pathlen]=root.data;
			pathlen++;
			
			if(root.leftNode == null && root.rightNode == null){
				printPath(path,pathlen);
			}else{
				printPathFromRootToLeaf(root.leftNode,path,pathlen);
				printPathFromRootToLeaf(root.rightNode,path,pathlen);
			}
		}
	}	

	private void printPath(int[]path,int len) {
		for(int i=0;i<len;i++){
			System.out.print(path[i]+" ");
		}
		System.out.println();
	}	
	
	//14.Construct Binary with given Inorder and Preorder travsersal
	public void constructBtreeFromInorderPostOrder(int[]inorder,int[]postorder){
		
		Node root=constructTreeFromInOrderAndPostOrder(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
		printTree("inorder",root);
		printTree("preorder",root);
		printTree("postorder",root);
	}
    /*
     * Construct Binary Tree using inorder and postorder traversal:
     * We just saw that last element of Post order traversal is root node.

		Step 1:
		Read the last element from Post order traversal which is root node.
		Now, we come to know which is root node.(in our case it is 50)
		
		Step 2:  
		Search the same element (element 50) in In-order traversal, 
		when the element is found in In-order traversal, then we can very well say that all the elements present before the node found are Left children/sub-tree 
		and all the elements present after the node found are Right children/sub-tree of node found. 
		(as in In-order traversal Left child's are read first and then root node and then right nodes.)
		
		In our example,  
		(20, 30, 35, 40, 45)  will be part of Left Sub-tree of Node 50.
		(55, 60, 70) will be part of Right Sub-tree of Node 50.
		
		Now we got the fresh inOrder array (20, 30, 35, 40, 45) and (55, 60, 70)
		Repeat the  Step 1 and Step 2 for new inOrder arrays. 
		
		So, keeping the above rule in mind, 
		We will find the root node from Post-order traversal and then left child's and right child's from In-order traversals like shown below, 
		
		So if we repeat the process, we will get our Binary Tree ready.
     */
	private Node constructTreeFromInOrderAndPostOrder(int[] inorder, int inStart,int inEnd, int[] postorder, int postStart, int postEnd) {
		if(postStart > postEnd){
			   return null;
		}
		Node node = new Node(postorder[postEnd]);
		
		int index=0;
		  for (int i = inStart; i <= inEnd; i++) {
		   if(postorder[postEnd]==inorder[i]){
		    index = i;
		    break;
		   }  
		  }
		  int numberOfNodes = index - inStart;
		  
		  node.setLeftNode(constructTreeFromInOrderAndPostOrder(inorder, inStart, index-1, postorder, postStart, (postStart + numberOfNodes)-1));
		  node.setRightNode(constructTreeFromInOrderAndPostOrder(inorder, index+1, inEnd, postorder, postStart + numberOfNodes, postEnd-1));
		  
		return node;
	}
	
	//15.Check whether Binary tree is balanced or not
	/*
	 * How to check Binary Tree is balanced or not?
	 * What is bal­anced Tree: A bal­anced tree is a tree in which difference between heights of sub-trees of any node in the tree is not greater than one.
	 * Algorithm:
	 * 	1.Post order tra­ver­sal technique
		2.Travel all the way down to leaf nodes and then go up.
		3.while going up, cal­cu­late the left and right sub­tree height.
		4.If the dif­fer­ence between them is greater than 1, return –1.
		5.Else Max(leftHeight, rightHeight) +1 .
		Here you wont actu­ally cal­cu­late the height of the sub­trees by call­ing func­tion, 
		instead you will store the height at each level and when you go one level up, you add one to it.
	 * 
	 */
	public boolean isBalancedTree(Node root){
		int result=checkBalance(root);
		if(result > 0){
			return true;
		}else{
			return false;
		}
	}

	private int checkBalance(Node root) {
		if(root == null){
			return 0;
		}
		//post order traversal - Left Right Root
		int leftH=checkBalance(root.leftNode);
		if(leftH == -1){
			return -1;
		}
		int rightH=checkBalance(root.rightNode);
		if(rightH == -1){
			return -1;
		}
		int diff=leftH-rightH;
		if(Math.abs(diff)>1){
			return -1;
		}
		return 1+(Math.max(leftH, rightH));
	}
	
	//16.Check whether Binary Tree is Binary Search Tree(BST) or not.
	
	/*
	 * How to check Binary tree is Binary Search Tree or not
	 * Binary Search Tree: value less than root is lies on left node and value less than root lies on right node
	 * 	• The left subtree of a node contains only nodes with keys less than the node’s key.
		• The right subtree of a node contains only nodes with keys greater than the node’s key.
		• Both the left and right subtrees must also be binary search trees.
	 * Algorithm:
	 * 1. Do Inorder traversal of tree
	 * 2. check if the data of previous node is always less than next then return true else return false.
	 * 
	 * 
	 */	 
	private Node prevNode=null;
	
	public boolean isBsT(Node root){
		
		boolean isbst=checkBST(root);
		return isbst;
	}
      
	private boolean checkBST(Node root) {
		if(root !=  null){
		
			checkBST(root.leftNode);							
			
			if(prevNode != null && root.data <= prevNode.data){
				return false;
			}
			prevNode=root;
			
			checkBST(root.rightNode);
		}	
		return true;
	}
}