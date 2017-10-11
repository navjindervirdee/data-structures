//Program to implement Insertion Algorithm in an AVL Tree.

public class AvlTree{
	static class Node{
		int data;   //data value
		Node left;  //points to left child.
		Node right; //points to right child.
		Node parent;//points to parent node.
		int height; //height of the node.
	
		public Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
			this.parent = null;
			this.height = 1;
		}
	}
	
	static Node root = null;   //root of the tree.
	
	//function to add elements in the tree.
	public static void add(int data){
		System.out.println("Inserting node with data  : " +  data );
		Node node  = new Node(data);
		if(root == null){
			root = node;
			return;
		}
		
		Node temp = root;
		while(temp!=null){
			if(temp.data<data){
				if(temp.right==null){
					temp.right = node;
					node.parent = temp;
					Node prob = updateHeight(node); //updation of height as new node is inserted
					if(prob!=null){
						rotations(prob);        //balancing of the tree as tree can become unbalanced on insertion.
					}
					return;
				}
				temp = temp.right;
				continue;
			}
			if(temp.data>data){
				if(temp.left==null){
					temp.left=node;
					node.parent = temp;
					Node prob = updateHeight(node); //updation of height as new node is inserted
					if(prob!=null){
						rotations(prob);        //balancing of the tree as tree can become unbalanced on insertion.
					}
					return;
				}
				temp = temp.left;
				continue;
			}
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
			
	//function for performing the rotations in the tree to make it balanced.
	private static void rotations(Node node){
		System.out.println("Problematic Node : " + node.data);
		int leftC = 0; //left child height
		int rightC = 0; // right child height 

		if(node.left != null){
			leftC = node.left.height;
		}
		if(node.right != null){
			rightC = node.right.height;
		}
		
		int leftgC = 0; //left grand child height
		int rightgC = 0; //right grand child height

		if(leftC>rightC){
			Node left = node.left;
			if(left.left!=null){
				leftgC = left.left.height;
			}
			if(left.right!=null){
				rightgC = left.right.height;
			}
			
			//right rotation.
			if(leftgC>rightgC){
				rotateRight(left);
				node = updateHeight(left);
				if(node!=null){
					rotations(node);
				}
			}
		
			//left rotation then right rotation.
			else{
				Node leftR = left.right;
				rotateLeft(leftR);
				rotateRight(leftR);
				node = updateHeight(leftR);
				if(node!=null){
					rotations(node);
				}
			}
		}
		else{
			Node right = node.right;
			if(right.left!=null){
				leftgC = right.left.height;
			}
			if(right.right!=null){
				rightgC = right.right.height;
			}
	
			//left rotation.
			if(leftgC<rightgC){
				rotateLeft(right);
				node  = updateHeight(right);
				if(node!=null){
					rotations(node);
				}
			}
			
			//right rotation then left rotation.
			else{
				Node rightL = right.left;
				rotateRight(rightL);
				rotateLeft(rightL);
				node = updateHeight(rightL);
				if(node!=null){
					rotations(node);
				}
			}
		}
	}
	
	//function to calculate height of a node.
	private static int calcHeight(Node node){
		if(node==null){
			return 0;
		}
		if(node.left==null&&node.right==null){
			node.height = 1;
			return 1;
		}
		int left = calcHeight(node.left);
		int right = calcHeight(node.right);
		node.height = Math.max(left,right) + 1;
		return node.height;
	}
			

	//function to update heights after every rotation.
	private static Node updateHeight(Node node){
		while(node!=null){
			int leftH = 0;
			int rightH = 0;
			if(node.left!=null){
				leftH = node.left.height;
			}
			if(node.right!=null){ 
				rightH = node.right.height;
			}
			int diff = Math.abs(leftH-rightH);
			node.height = Math.max(leftH,rightH) + 1;
			if(diff>1){
				return node;
			}
			node = node.parent;
		}
		return null;
	}
		
	//function to find balance factor i.e  bf = (left.child.height - right.chile.height)
	private static int calcBalance(Node temp){
		int leftheight = 0;
		if(temp.left!=null){
			leftheight = temp.left.height;
		}
		int rightheight = 0;
		if(temp.right!=null){
			rightheight = temp.right.height;
		}
		return Math.abs(leftheight-rightheight);
	}	
	
	//function for right rotation.
	private static void rotateRight(Node temp){
		System.out.println("Rotating Right node : " + temp.data);
		Node right = temp.right;
		Node gparent = temp.parent.parent;
		temp.right = temp.parent;
		temp.parent.left = right;
		if(right!=null){
			right.parent = temp.parent;
		}
		temp.parent.parent = temp;
		temp.parent = gparent;
		if(gparent==null){
			root = temp;
		}

		else{
			if(gparent.right==temp.right){
				gparent.right = temp;
			}
		
			else{
				gparent.left = temp;
			}
		}
		calcHeight(temp);
	}
	
	//function for left rotation.
	private static void rotateLeft(Node temp){
		System.out.println("Rotating Left node : " + temp.data);
		Node gparent = temp.parent.parent;
		Node left = temp.left;
		temp.left = temp.parent;
		temp.parent.right = left;
		if(left!=null){
			left.parent = temp.parent;
		}
		temp.parent.parent = temp;
		temp.parent = gparent;
		if(gparent==null){
			root = temp;
		}
		else{
			if(gparent.left==temp.left){
				gparent.left = temp;
			}

			else{
				gparent.right = temp;
			}
		}
		calcHeight(temp);
	}
	
	//function to display the tree.
	private static void display(){
		System.out.print("Tree's preOrder traversal : ");
		preOrder(root);
		System.out.println();
	}

	//main function to run the program.
	public static void main(String [] args){
		add(10);
		display();

		add(1);
		display();

		add(12);
		display();

		add(65);
		display();

		add(22);
		display();

		add(5);
		display();

		add(45);
		display();

		add(34);
		display();
		
		add(95);
		display();
		
		add(8);
		display();		

		add(59);
		display();
		
		add(90);
		display();
		
		add(100);
		display();
		
		add(13);
		display();
		
		add(11);
		display();
	}
}
	
	