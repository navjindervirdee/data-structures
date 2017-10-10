//Program to implement BinarySearchTree.

public class BinarySearchTree{
	static class Node{
		int key;     //data value
		Node parent; //points to the parent node.
		Node left;   //points to the right child.
		Node right;  //points to the left child.
		
		public Node(int data){
			this.key=data;
			this.parent=null;
			this.left=null;
			this.right=null;
		}

	}

	static Node root;   //root of the tree.

	public BinarySearchTree(){
		root=null;
	}

	//function to find specific data elements in the tree.
	public static Node find(int data){
		Node temp=root;
		Node prev=null;
		
		while(temp!=null){
			prev=temp;
			
			if(temp.key==data){
				return prev;
			}
			if(temp.key>data){
				temp=temp.left;
			}
			else{
				temp=temp.right;
			}
		}
		return prev;
	}

	//function to add elements in the tree.
	public static void add(int data){
		System.out.println("Inserting data : " + data);
		Node node = new Node(data);
		Node positionNode = find(data);
		if(positionNode==null){
			root=node;
			return;
		}
	
		node.parent=positionNode;

		if(node.key>positionNode.key){
			positionNode.right=node;
		}
		else{
			positionNode.left=node;
		}
	}

	//function to find the next greater element from the given data value.
	public static Node next(int data){
		System.out.println("Find Next of : " + data);
		if(root==null){
			return null;
		}
		
		Node node = find(data);
		if(node.right!=null){
			return leftDecesdant(node.right);
		}
		else{
			return rightAncestor(node);
		}
	}

	//function to find leftmost node.
	private static Node leftDecesdant(Node node){
		Node temp=node;
		while(temp.left!=null){
			temp=temp.left;
		}
		return temp;
	}

	//function to find the parent node with data value greater than the given node data value.	
	private static Node rightAncestor(Node node){
		Node temp=node.parent;
		while(temp!=null){
			if(temp.key>node.key){
				break;
			}
			temp=temp.parent;
		}
		if(temp==null){
			System.out.println("Max Element");
			return node;
		}
		else{
			return temp;
		}
	}
	
	//function to remove elements from the tree.
	private static Node remove(int data){
		System.out.println("Remove : " + data);
		Node node = find(data);
		if(node.right==null){
			if(root==node){
				root=node.left;
				return node;
			}
			if(node.parent.left==node){
				node.parent.left=node.left;
			}
			else{
				node.parent.right=node.left;
			}
			return node;
		}
		
		else{
			Node temp = next(data);
			node.key=temp.key;
			if(temp.parent.left==temp){
				temp.parent.left=temp.right;
			}
			if(temp.parent.right==temp){
				temp.parent.right=temp.right;
			}
		}
		return node;
	}

	//function to find the max data value in the tree.
	public static Node maxNode(){
		if(root==null){
			return null;
		}
		Node temp=root;
		while(temp.right!=null){
			temp=temp.right;
		}
		return temp;
	}

	//function to find the min data value in the tree.
	public static Node minNode(){
		if(root==null){
			return null;
		}
		Node temp = root;
		while(temp.left!=null){
			temp=temp.left;
		}
		return temp;
	}

	//function for InOrder Traversal of the tree.
	private static void inorderTraversal(Node rootNode){
		if(rootNode==null){
			return;
		}
		inorderTraversal(rootNode.left);
		System.out.print(rootNode.key + " ");
		inorderTraversal(rootNode.right);
	}

	//function for PreOrder Traversal of the tree.
	private static void preorderTraversal(Node rootNode){
		if(rootNode==null){
			return;
		}
		System.out.print(rootNode.key + " " );
		preorderTraversal(rootNode.left);
		preorderTraversal(rootNode.right);
	}

	//function for  PostOrder Traversal of the Tree.
	private static void postorderTraversal(Node rootNode){
		if(rootNode==null){
			return;
		}
		postorderTraversal(rootNode.left);
		postorderTraversal(rootNode.right);
		System.out.print(rootNode.key + " ");
	}

	//function to display the tree.
	public static void display(){
		System.out.println();
		System.out.println("Inorder Traversal");
		inorderTraversal(root);

		System.out.println();
		System.out.println("PreOrder Traversal");
		preorderTraversal(root);

		System.out.println();
		System.out.println("PostOrder Traversal");
		postorderTraversal(root);

		System.out.println();
	}

	//main function to run the program.
	public static void main(String [] args){
		BinarySearchTree tree = new BinarySearchTree();
		tree.add(10);
		tree.add(6);
		tree.add(14);
		tree.add(8);
		tree.add(12);
		tree.add(4);
		tree.add(16);

		tree.display();

		System.out.println();
		Node maxNode = tree.maxNode();
		System.out.println("Max value : " + maxNode.key);
		Node minNode = tree.minNode();
		System.out.println("Min value : " + minNode.key);
	
		System.out.println();	
		Node node1 = tree.find(8);
		System.out.println("Find 8  : " + node1.key);
		Node node2 = tree.find(16);
		System.out.println("Find 16 : " + node2.key);
		Node node3 = tree.find(10);
		System.out.println("Find 10 : " + node3.key);
		Node node4 = tree.find(4);
		System.out.println("Find 4  : " + node4.key);

		System.out.println();
		tree.display();
		System.out.println();	

		Node next1 = tree.next(16);
		System.out.println(next1.key);

		Node next2 = tree.next(10);
		System.out.println(next2.key);

		Node next3 = tree.next(4);
		System.out.println( next3.key);

		Node next4 = tree.next(8);
		System.out.println(next4.key);

		Node next5 = tree.next(14);
		System.out.println(next5.key);

		Node next6 = tree.next(12);
		System.out.println(next6.key);

		Node next7 = tree.next(6);
		System.out.println(next7.key);		

		System.out.println();		

		Node del1 = tree.remove(14);
		System.out.println(del1.key);

		Node del2 = tree.remove(10);
		System.out.println(del2.key);

		Node del3 = tree.remove(4);
		System.out.println(del3.key);

		Node del4 = tree.remove(6);
		System.out.println(del4.key);

		Node del5 = tree.remove(16);
		System.out.println(del5.key);		

		System.out.println();
		tree.display();
		
		System.out.println();
		Node max = tree.maxNode();
		System.out.println("Max value : "  + max.key);
		Node min = tree.minNode();
		System.out.println("Min value : " + min.key);
		
	}
}

		

		
		
			
			

			
			

		
		






























							