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

		node.next = head;
		head = node;
		size++;
	}

	//method to get the element at top of the stack
	static public int top(){
		if(head==null){
			System.out.println("Stack is Empty!");
			return -1;
		}
		
		System.out.println("Element at top of stack : " + head.key);
		return head.key;
	}


	//function to remove topmost element from the stack.
	static public int pop(){
		//if head is null = stack empty.
		if(head==null){
			System.out.println("Empty Stack.");
			return -1;
		}

		System.out.println("Pop Operation.");	

		int temp = head.key;
		head = head.next;
		size--;

		return temp;
	}

	//function to display the stack.
	static public void display(){
		//if stack is empty.
		if(head==null){
			System.out.println("Stack is empty.");
			return;
		}

		System.out.println();
		System.out.println("Stack ");
		Node temp=head;
		while(temp!=null){
			System.out.println("----------");
			System.out.println("|   " + temp.key + "   |");
			temp=temp.next;
		}
		System.out.println("----------");
		System.out.println();
	}

	//method to get the number of elements in the stack.
	static public int getSize(){
		return size;
	}
	
	static public void main(String [] args){
		Stack stack = new Stack(); //create new stack.
		stack.push(10);            //push num = 10
		stack.push(20);            //push num = 20
		stack.push(30);            //push num = 30

		stack.display();           //display stack.
		stack.top();
		
		stack.pop();               //pop topmost element
		stack.pop();               //pop topmost element
		stack.display();           //display stack.
		stack.pop();               //pop topmost element
		stack.display();           //display stack.
	}
}	
	
			