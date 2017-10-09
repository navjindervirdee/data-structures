//Program to implement Circular LinkedList.

public class CircularLinkedList{
	static class Node{
		int key;    //Data value
		Node next;  //points to next element in the list.

		public Node(int data){
			this.key=data;
			this.next=null;
		}

	}

	static Node head;   //head of the list.

	public CircularLinkedList(){
		head=null;
	}

	//function to add element at the front of the list.
	static public void pushFront(int number){
		System.out.println("Inserting data at front : " + number);
		Node node = new Node(number);
		if(head==null){
			head=node;
			node.next=head;
			return;
		}
		
		//if list contains only single element.
		if(head.next==head){
			node.next=head;
			head=node;
			node.next.next=head;  //point the last element to head of the list.
			return;
		}
		
		Node temp=head;
		while(temp.next!=head){
			temp=temp.next;
		}

		node.next=head;
		head=node;
		temp.next=head;  //point the last element to the head of the list.
	}
		
		
	//fucntion to add elements at the back of the list.
	static public void pushBack(int number){
		System.out.println("Inserting data at back  : " + number);
		Node node = new Node(number);
	
		if(head==null){
			head=node;
			node.next=head;
			return;
		} 		
	
		//if list contains only single element.	
		if(head.next==head){
			head.next=node;
			node.next=head;
			return;
		}
		Node temp = head;
		while(temp.next!=head){
			temp=temp.next;
		}
		temp.next=node;
		node.next=head;
	}

	//function to remove elements from the front of the list.
	public static void popFront(){
		System.out.print("PopFront Operation : ");
		if(head==null){
			System.out.println("Empty List.");
			return;
		}

		if(head.next==head){
			head=null;
			System.out.println("Successfull.");
			return;
		}
		
		Node temp=head;
		while(temp.next!=head){
			temp=temp.next;
		}
		head=head.next;
		temp.next=head;  //update the last element to point to new head.
		System.out.println("Successfull.");
	}

	//function to remove elements from the back of the list.
	public static void popBack(){
		System.out.print("PopBack Operation  : ");
		if(head==null){
			System.out.println("Empty List.");
			return;
		}
		
		if(head.next==head){
			head=null;
			System.out.println("Successfull.");
			return;
		}

		Node temp=head;
		while(temp.next.next!=head){
			temp=temp.next;
		}
		temp.next=temp.next.next; //update new last element to point to head.
		System.out.println("Successfull.");
	}

	//function to display the list.
	public static void display(){
		System.out.print("List : ");
		if(head==null){
			System.out.println("Empty List.");
			return;
		}

		Node temp=head;
		while(temp.next!=head){
			System.out.print(temp.key + " ");
			temp=temp.next;
		}
		System.out.println(temp.key);
	}

	//main function to run the program.
	public static void main(String [] args){
		CircularLinkedList list = new CircularLinkedList();
		list.pushFront(10);
		list.pushBack(12);
		list.pushFront(8);
		list.pushBack(14);

		list.display();

		list.popFront();
		list.display();

		list.popBack();
		list.display();
		list.popFront();
		list.popBack();
		list.display();
	}
}

		

			
		