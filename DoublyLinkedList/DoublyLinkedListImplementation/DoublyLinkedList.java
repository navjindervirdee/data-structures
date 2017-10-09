//Program to implement Doubly Linked List.

public class DoublyLinkedList{
	Node head;  //head of the list. i.e first element.
	Node tail;  //tail of the list. i.e last element.
	int size;   //number of  elements in the list.
	
	public DoublyLinkedList(){
		head=null;
		tail=null;
		size=0;
	}

	//function to add elements at the front of the list.
	public void pushFront(int data){
		System.out.println("Inserting data at front : " + data);
		Node node = new Node(data);
		if(head==null && tail==null){
			head=node;
			tail=node;
			size++;
			return;
		}
		
		node.next=head;
		head.prev=node;
		head=node;
		size++;
	}

	//function to add elements at the back of the list.
	public void pushBack(int data){
		System.out.println("Inserting data at back  : " + data);
		Node node = new Node(data);
		if(tail==null && head==null){
			head=node;
			tail=node;
			size++;
			return;
		}

		tail.next=node;
		node.prev=tail;
		tail=node;
		size++;
	}

	//function to remove elements from the front of the list.
	public void popFront() throws Exception{
		System.out.println("PopFront Operation.");
		if(head==null && tail==null){
			throw new Exception("List is empty!");
		}
		if(head==tail){
			head=null;
			tail=null;
			size--;
			return;
		}
		
		head.next.prev=null;
		head=head.next;
		size--;
	}

	//function to remove elements from the back of the list.
	public void popBack() throws Exception{
		System.out.println("PopBack Operation.");
		if(head==null && tail==null){
			throw new Exception("List is empty!");
		}
		if(head==tail){
			head=null;
			tail=null;
			size--;
			return;
		}
		tail.prev.next=null;
		tail=tail.prev;
		size--;
	}
	
	//function to get the first element of the list.
	public int topFront() throws Exception{
		if(head==null){
			throw new Exception("List is empty!");
		}
		return head.key;
	}

	//function to get last element of the list.
	public int topBack() throws Exception{
		if(tail==null){
			throw new Exception("List is empty!");
		}
		return tail.key;
	}

	//function to find specific element in the list.
	public boolean Find(int data){
		Node temp=head;
		while(temp!=null){
			if(temp.key==data){
				return true;
			}
			temp=temp.next;
		}
		return false;
	}
	
	//function to get size of the list.
	public int size(){
		return size;
	}

	//function to display the list.
	public void forwardDisplay() throws Exception{
		System.out.print("List : ");
		Node temp = head;
		if(temp==null){
			throw new Exception("List is empty!");
		}
		while(temp!=null){
			System.out.print(temp.key + " ");
			temp=temp.next;
		}
		System.out.println();
	}

	//function to display the list in reverse direction.
	public void reverseDisplay() throws Exception{
		System.out.print("Reverse List : ");
		Node temp = tail;
		if(temp==null){
			throw new Exception("List is empty!");
		}
		while(temp!=null){
			System.out.print(temp.key + " ");
			temp=temp.prev;
		}
		System.out.println();
	}

	//function to remove specific element from the list.
	public void remove(int data) throws Exception{
		System.out.println("Remove data : " + data);
		Node temp = head;
		Node prevNode = null;
		if(temp==null){
			throw new Exception("List is empty!");
		}
		size--;
 		
		if(temp==tail){
			if(temp.key==data){
				head=null;
				tail=null;
				return;
			}
			else{
				throw new Exception("Data not found");
			}
		}
		if(head.key==data){
			head=head.next;
			head.prev=null;
			return;
		}
		while(temp!=null && temp.key!=data){
			prevNode=temp;
			temp=temp.next;
		}
		prevNode.next=prevNode.next.next;
		prevNode.next.prev=prevNode;
		temp=null;
	}
}

	
		
		

		
			
	