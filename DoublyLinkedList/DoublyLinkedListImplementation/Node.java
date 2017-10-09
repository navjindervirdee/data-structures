//Class Node
public class Node{
	int key;   //data value.
	Node next; //points to next element in the list.
	Node prev; //points to prev element in the list.
	
	public Node(int data){
		this.key=data;
		this.next=null;
		this.prev=null;
	}
}