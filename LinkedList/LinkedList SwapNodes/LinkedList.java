//Program to swap data values of first and last node.
//e.g List = 1->2->3->4 , after swap List = 4->2->3->1

public class LinkedList{
	static class Node{
		int key;    //store the data value.
		Node next;  //points to next element of the list.
	
		public Node(int data){
			this.key=data;
			this.next=null;
		}
	}

	static Node head;  //head node i.e first element.
	static int size;   //number of elements in the list.

	public LinkedList(){
		head=null;
	}

	//function to add elements at the front of the list.
	static public void pushFront(int number){
		System.out.println("Inserting data at front : " + number);
		Node node = new Node(number);
		if(head==null){
			head=node;
			size++;
			return;
		}

		node.next=head;
		head=node;
		size++;
	}

	//function to add elements at the back of the list.
	static public void pushBack(int number){
		System.out.println("Inserting data at back  : " + number);
		Node node = new Node(number);
		if(head==null){
			head=node;
			size++;
			return;
		}
		Node temp=head;
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next=node;
		size++;
	}
	
	//function to swap the data values of the first and last element.
	public static void swap(){
		System.out.println("Swapping data values of first and last node.");
		//if either list is empty or contains only single element.
		if(head==null || head.next==null){
			return;
		}

		Node temp=head;
		Node headNode = head;
		while(temp.next!=null){
			temp=temp.next;
		}
		int data = headNode.key;
		headNode.key=temp.key;
		temp.key=data;
	}

	//function to display the list.
	static public void display(){
		System.out.print("List : ");
		if(head==null){
			System.out.println("Empty.");
			return;
		}

		Node temp=head;
		while(temp!=null){
			System.out.print(temp.key +  " ");
			temp=temp.next;
		}
		System.out.println();
	}

	//main function to run the program.
	public static void main(String [] args){
		LinkedList list = new LinkedList();
		list.pushFront(10);
		list.pushBack(12);
		list.pushFront(8);
		list.pushFront(6);
		
		list.display();
	
		list.swap();
		list.display();
	}
}
		
