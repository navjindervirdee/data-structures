//Program to Implement LinkedList.

public class LinkedList{
	//Node class.
	static class Node{
		int key;   //data value.
		Node next; //next Pointer.
		
		public Node(int data){
			this.key=data;
			this.next=null;
		}
	}

	static Node head;  //head of the linked list. i.e first element.
	static int size;   //number of elements in the list.
	
	
	public LinkedList(){
		head=null;
		size=0;
	}

	//function to add elements at the front of the list.
	static public void pushFront(int number){
		System.out.println("Inserting node at front : " + number);
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
		System.out.println("Inserting node at back  : " + number);
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

	//function to remove element from the front of the list.
	static public void popFront(){
		System.out.println("PopFront Operation.");
		if(head==null){
			return;
		}
		
		head=head.next;
		size--;
	}

	//function to remove elements from the back of the list.
	static public void popBack(){
		System.out.println("PopBack Operation.");
		if(head==null){
			return;
		}
		
		if(head.next==null){
			head=null;
			size--;
			return;
		}
		
		Node temp=head;
		while(temp.next.next!=null){
			temp=temp.next;
		}
		temp.next=null;
		size--;
	}

	//function to remove element at a specific position.
	static public void pop(int position){
		System.out.println("Poping element at pos : " + position);
		if(head==null){
			return;
		}
		if(position==0){
			head=head.next;
			size--;
			return;
		}
			
		Node temp=head;
		int x=0;
		while(temp.next!=null && x<position-1){
			temp=temp.next;	
			x++;
		}
		
		
		
		if(temp.next==null){
			return;
		}
		
		temp.next=temp.next.next;
		size--;
	}
		
	//function to display the list.
	static public void display(){
		System.out.print("LinkedList : ");
		if(head==null){
			System.out.println(" ");
			return;
		}

		Node temp=head;
		while(temp!=null){
			System.out.print(temp.key +  " ");
			temp=temp.next;
		}
		System.out.println();
	}

	//main functon to run the program.
	public static void main(String [] args){
		LinkedList list = new LinkedList();
		list.pushFront(10);
		list.pushBack(12);

		list.display();

		list.pushFront(8);
		list.pushFront(6);
		list.pushBack(20);

		list.display();
		
		list.pop(3);
		list.display();

		list.popFront();
		list.display();

		list.popBack();
		list.display();
	}
}
	