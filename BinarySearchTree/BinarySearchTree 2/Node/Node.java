//Program for Node of the BinarySearchTree.
public class Node{
	int key;     //data value.
	Node parent; //points to the parent of the node.
	Node left;   //points to the left child of the node.
	Node right;  //points to the right child of the node.
	int height;  //height of the node.

	public Node(int data){
		this.key=data;
		this.parent=null;
		this.left=null;
		this.right=null;
		this.height=0;
	}
}