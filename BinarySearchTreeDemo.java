package com.example.serialization;

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int data){
		this.data=data;
		this.left=null;
		this.right=null;
	}
}

public class BinarySearchTreeDemo {

	TreeNode root;
	
	/* Adding New Node Iterative Approach*/	
	public void addNode(int data){
		
		//create new node
		TreeNode newNode=new TreeNode(data);
		
		if(root == null){
			root=newNode;
		}else{
			TreeNode currNode=root;
			TreeNode parentNode=currNode;
			
			while(true){
				parentNode=currNode;
				//check duplicate data found then discard duplicate element
				if(data == currNode.data){
					System.out.println("Duplicate discarded!!");
					break;
				}
				//if data is less than root data then move to left subtree
				if(data < currNode.data){
					currNode=currNode.left;
					if(currNode == null){
						parentNode.left=newNode;
						break;
					}
				}
				
				//if data is greater than root data then move to right subtree
				if(data > currNode.data){
					currNode=currNode.right;
					if(currNode == null){
						parentNode.right=newNode;
						break;
					}
				}
			}
		}		
	}
	
	//add new node recursive approach
	public void addNodeRecursive(int data){
		
		//create new node 
		TreeNode newNode=new TreeNode(data);
		if(root == null){
			root=newNode;
		}else{
			addNodeRec(root,newNode);
		}
		
	}
	
	private void addNodeRec(TreeNode root,TreeNode newNode) {
		
		if(root != null){
			if(newNode.data < root.data){
				if(root.left != null){
					addNodeRec(root.left,newNode);
				}else{
					root.left=newNode;
					return;
				}
			}else if(newNode.data > root.data){
				if(root.right != null){
					addNodeRec(root.right,newNode);
				}else{
					root.right=newNode;
					return;
				}
			}			
		}		
	}

	//postorder traversal using recursive approach
	private void postorder(TreeNode root) {

		if(root != null){
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data+" ");
		}
	}

	//preorder traversal using recursive approach
	private void preorder(TreeNode root) {
		
		if(root != null){
			System.out.print(root.data+" ");
			preorder(root.left);
			preorder(root.right);
		}
	}

	//inorder traversal using recursive approach
	private void inorder(TreeNode root){
		if(root !=null){
		
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}
	
	//printTree based on parameter inorder, preorder or postorder
	public void printTree(String mode){
		if("inorder".equalsIgnoreCase(mode)){
			inorder(root);
		}else if("preorder".equalsIgnoreCase(mode)){
			preorder(root);
		}else if("postorder".equalsIgnoreCase(mode)){
			postorder(root);
		}else{
			System.out.println("Invalid parameter only inorder/preorder/postorder allow");
		}
	}
	
	//overloaded printTree method for default print
	public void printTree(){
		inorder(root);
	}
	
	public void inOrderSuccessor(TreeNode targetNode){
		TreeNode successor=inorderSuccessor(root,targetNode);
		if(successor != null){
		System.out.println("Successor of "+targetNode.data+" is "+successor.data);
		}else{
			System.out.println("Successor of "+targetNode.data+" doesnot exist!!");
		}
	}
	private TreeNode inorderSuccessor(TreeNode root,TreeNode targetNode){
		if(targetNode.right != null){
			return minValue(targetNode.right);
		}
		TreeNode succNode=null;
		while(root != null){
			if(targetNode.data < root.data){
				succNode=root;
				root=root.left;
			}else if(targetNode.data > root.data){
				root=root.right;
			}else
				break;
		}
		return succNode;
	}
	
	private TreeNode minValue(TreeNode right) {
		TreeNode currNode=right;
		while(currNode.left != null){
			currNode=currNode.left;
		}
		return currNode;
	}

	public int findHight(TreeNode root){
		return getHight(root);
	}
	private int getHight(TreeNode root){
		if(root == null) return 0;
		int leftHight=getHight(root.left);
		int rightHight=getHight(root.right);
		return maxOfHight(leftHight,rightHight)+1;
	}
	private int maxOfHight(int leftHight, int rightHight) {
		if(leftHight > rightHight){
			return leftHight;
		}else{
			return rightHight;
		}		
	}

	public int size(TreeNode root){
		if(root == null)
			return 0;
		else{
			return size(root.left)+size(root.right)+1;
		}
	}
	//Test Code
	public static void main(String[] args) {

		BinarySearchTreeDemo bst=new BinarySearchTreeDemo();
		bst.addNode(20);
		bst.addNode(8);
		bst.addNode(22);
		bst.addNode(12);
		bst.addNode(4);
		bst.addNode(14);
		bst.addNode(10);
		
		bst.printTree();
		int hight=bst.findHight(bst.root);
		System.out.println("hight:"+hight);
		System.out.println("Size:"+bst.size(bst.root));
		//bst.inOrderSuccessor(targetNode);
	}

}