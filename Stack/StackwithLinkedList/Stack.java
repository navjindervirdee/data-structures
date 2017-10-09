//Program to implement Stack using LinkedList.
public class Stack{
	//class Node for LinkedList.
	static class Node{
		int key;   //data value
		Node next; //next pointer
		
		public Node(int number){
			this.key=number;
			this.next=null;
		}
	}

	static Node head; //head of linkedlist
	static int size;
	
	public Stack(){
		head=null;
		size=0;	
	}

	//function to add elements into the stack.
	static public void push(int number){
		Node node = new Node(number); //create new node.
		System.out.println("Push data : " + number);

		if(head==null){
			head=node;
			size++;
			return;
		}

		Node temp = head;
		while(temp.next!=null){
			temp=temp.next ;
		}
		temp.next=node;
		size++;
	}

	//function to remove topmost element from the stack.
	static public int pop(){
		//if head is null = stack empty.
		if(head==null){
			System.out.println("Empty Stack.");
			return -1;
		}

		System.out.println("Pop Operation.");	
		Node temp = head;

		//if only single element is present in the stack.
		if(head.next==null){
			int temp1 = head.key;
			head=null;
			return temp1;
		}

		//if more than one element is present in the stack.
		while(temp.next.next!=null){
			temp=temp.next;
		}
		int temp1 = temp.next.key;
		temp.next=null;
		return temp1;
	}

	//function to display the stack.
	static public void display(){
		//if stack is empty.
		if(head==null){
			System.out.println("Stack is empty.");
			return;
		}
		System.out.print("Stack : ");
		Node temp=head;
		while(temp!=null){
			System.out.print(temp.key + " " );
			temp=temp.next;
		}
		System.out.println();
	}
	
	static public void main(String [] args){
		Stack stack = new Stack(); //create new stack.
		stack.push(10);            //push num = 10
		stack.push(20);            //push num = 20
		stack.push(30);            //push num = 30

		stack.display();           //display stack.
		
		stack.pop();               //pop topmost element
		stack.pop();               //pop topmost element
		stack.display();           //display stack.
		stack.pop();               //pop topmost element
		stack.display();           //display stack.
	}
}	
	
			