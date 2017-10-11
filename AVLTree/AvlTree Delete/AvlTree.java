//Program to implement AVL Tree. Insertion, Search and Deletion.
public class AvlTree{
	static class Node{
		int data;   //data value 
		Node left;  //points to left child
  		Node right; //points to right child
		Node parent;//points to parent node.
		int height; //height of the tree.
	
		public Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
			this.parent = null;
			this.height = 1;
		}
	}
	
	static Node root = null;  //root of the tree.
	
	//function to add new elements in the tree.
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
					Node prob = updateHeight(node);    //updation of height after inserting the node.
					if(prob!=null){
						rotations(prob);           //perform rotations to balance the tree.
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
					Node prob = updateHeight(node);     //updation of height after inserting the node.
					if(prob!=null){
						rotations(prob);            //perform rotations to balance the tree.
					}
					return;
				}
				temp = temp.left;
				continue;
			}
		}
	}

	//fuction for PreOrder Traversal of the tree.
	private static void preOrder(Node node){
		if(node==null){
			return;
		}
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
			
	
	//function for performing the rotations in the tree.
	private static void rotations(Node node){
		if(node==null){
			return;
		}	
		System.out.println("Problematic Node : " + node.data);
		int leftC = 0; //left child
		int rightC = 0; // right child.

		if(node.left != null){
			leftC = node.left.height;
		}
		if(node.right != null){
			rightC = node.right.height;
		}
		
		int leftgC = 0; //left grand child
		int rightgC = 0; //right grand child

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
	
	//function to calculate the height of the node.
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
			
	//function to update heights after the rotations.
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
		
	
	//function to calculate the balance factor i.e bf=(left.child.height-right.child.height)
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
	
	//function for performing the right rotation.
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
	
	//function for performing the left rotation.
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

	//function to search for a data value.
	private static Node find(int data){
		System.out.println("Finding node : " + data);
		Node temp = root;
		while(temp!=null){
			if(temp.data == data){
				return temp;
			}
			
			if(temp.data>data){
				temp=temp.left;
			}
			else{
				temp = temp.right;
			}
		}
		return null;
	}
		
	//function to remove elements from the tree.
	private static void remove(int data){
		Node node = find(data);
		if(node==null){
			System.out.println("Data not found!");
			return;
		}
		System.out.println("Found! Deleting.");
		Node right = node.right;
		if(right!=null){
			Node left = right;
			while(left.left!=null){
				left = left.left;
			}
			node.data = left.data;
			if(left.parent.left == left){
				left.parent.left = left.right;
				if(left.right!=null){
					left.right.parent = left.parent;
				}
				Node prob = updateHeight(left.parent);
				if(prob!=null){
					rotations(prob);
				}
			}
			else{
				left.parent.right = left.right;
				if(left.right!=null){
					left.right.parent = left.parent;
				}
				Node prob = updateHeight(left.parent);
				if(prob!=null){
					rotations(prob);
				}
			}
			left = null;
		}
		else{
			Node parent = node.parent;
			if(parent==null){
				root = node.left;
				node.left.parent = null;
				rotations(root);
			}
			else{
				if(parent.left == node){
					parent.left = node.left;
					if(node.left!=null){
						node.left.parent = parent;
					}
					Node prob = updateHeight(parent);
					if(prob!=null){
						rotations(prob);
					}
					node = null;
				}
				else{
					parent.right = node.left;
					if(node.left !=null){
						node.left.parent = parent;
					}
					Node prob = updateHeight(parent);
					if(prob!=null){
						rotations(prob);
					}
					node = null;
				}
			}
		}			
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
		
		remove(90);
		display();

		remove(59);
		display();

	}
}
	
	