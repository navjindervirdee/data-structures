//Program to implement a Splay Tree.

public class SplayTree{
	static class Node{
		int data;    //data value
		Node left;   //points to left child.
		Node right;  //points to right child
		Node parent; //points to the parent node.
		
		public Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
			this.parent = null;
		}
	}
	
	static Node root;   //root of the tree.
	
	//function for performing a Left Rotation.
	private static void leftRotate(Node node){
		System.out.println("Rotating left : " + node.data);
		Node parent = node.parent;
		Node left = node.left;
		node.left = parent;
		parent.right = left;
		if(left!=null){
			left.parent = parent;
		}
		Node gp = node.parent.parent;
		parent.parent = node;
		node.parent = gp;
		
		if(gp==null){
			root = node;
		}
		else{
			if(gp.left == parent){
				gp.left = node;
			}
			else{
				gp.right = node;
			}
		}
	}
	
	//function for performing a Right Rotation.
	private static void rightRotate(Node node){
		System.out.println("Rotating right : " + node.data);
		Node parent = node.parent;
		Node right = node.right;
		node.right = parent;
		parent.left = right;
		if(right!=null){
			right.parent = parent;
		}
		Node gp = parent.parent;
		node.parent = gp;
		parent.parent = node;
		
		if(gp==null){
			root = node;
		}
		else{
			if(gp.left==parent){
				gp.left = node;
			}
			else{
				gp.right = node;
			}
		}
	}

	//function for performing the Splay Operation.
	private static void splay(Node node){
		System.out.println("Splaying node : " + node.data);

		if(node.parent == null){
			root = node;
			return;
		}
	
		//zig Rotation.
		if(node.parent.parent==null){
			if(node.parent.right == node){
				leftRotate(node);
				root = node;
			}
			else{
				rightRotate(node);
				root = node;
			}
			return;
		}
		
		//zig-zag rotation - left rotation then right rotation
		if(node.parent.right==node && node.parent.parent.left == node.parent){
			leftRotate(node);
			rightRotate(node);
			splay(node);
			return;
		}
	
		//zigzag rotation - right rotation then left rotaion.
		if(node.parent.left == node && node.parent.parent.right == node.parent){
			rightRotate(node);
			leftRotate(node);
			splay(node);
			return;
		}
	
		//zig-zig rotation left rotation then left rotation.
		if(node.parent.right==node && node.parent.parent.right == node.parent){
			leftRotate(node.parent);
			leftRotate(node);
			splay(node);
			return;
		}
		
		//zig-zig rotation right rotation then right rotation.
		if(node.parent.left == node && node.parent.parent.left == node.parent){
			rightRotate(node.parent);
			rightRotate(node);
			splay(node);
			return;
		}
	}
		
	//function to add new elements in the tree.
	public static void add(int data){
		System.out.println("Inserting data : " + data);
		Node node = new Node(data);
		if(root == null){
			root = node;
			return;
		}
		
		Node temp = root;
		
		while(temp!=null){
			if(temp.data>data){
				if(temp.left==null){
					temp.left = node;
					node.parent = temp;
					splay(node);                 //perform splay operation.
					return;
				}
				temp = temp.left;
			}
		
			if(temp.data<data){
				if(temp.right==null){				
					temp.right = node;
					node.parent = temp;
					splay(node);                 //perform splay opertaion.
					return;
				}
				temp = temp.right;
			}
		}
	}

	//function to search for a data value in the tree.
	public static Node find(int data){
		System.out.println("Searching for node : " + data);
		if(root==null){
			System.out.println("Empty Tree.");
			return null;
		}
		
		Node temp = root;
		while(temp!=null){
			if(temp.data == data){
				System.out.println("Found node : " + data);
				splay(temp);
				return temp;
			}
			if(temp.data>data){
				temp = temp.left;
			}
			else{
				temp = temp.right;
			}
		}
		System.out.println("Node not found.");
		return null;
	}

	//function to find the min value from the given node.
	public static Node findMin(Node node){
		if(node==null){
			System.out.println("Empty Tree.");
			return null;
		}
		System.out.println("Finding Minimum.");
		Node min = node;
		while(min.left!=null){
			min = min.left;
		}
		splay(min);
		System.out.println("Minimum node : " + min.data);
		return min;
	}

	//function to remove elements from the tree.
	public static void delete(int data){
		System.out.println("Deleting node : " + data);
		Node node = find(data);
		if(node==null){
			System.out.println("Node not present in the tree.");
			return;
		}

		Node min = findMin(node.right);
		if(min==null){
			root = root.left;
			root.parent = null;
			return;
		}
		root.left = root.left.left;
		if(root.left!=null){
			root.left.parent = root;
		}
	}
	
	//function for PreOrder Traversal of the tree.
	private static void preOrder(Node node){
		if(node==null){
			return;
		}
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	//function to display the tree.
	public static void display(){
		System.out.print("Tree's PreOrder Traveral : ");
		preOrder(root);
		System.out.println();
	}

	//main function to run the program.
	public static void main(String [] args){
		add(10);
		display();
		add(8);
		display();
		add(16);
		display();
		add(11);
		display();
		add(15);
		display();
		add(6);
		display();
		
		delete(16);
		display();
		
		delete(8);
		display();
	}
}				