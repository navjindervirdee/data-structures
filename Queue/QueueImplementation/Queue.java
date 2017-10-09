//Program to implement Queue using array.

import java.lang.Exception;
public class Queue{
	int addPointer; //points to the position where new number is to be added.
	int removePointer; //points tot position of the element, which is to be deleted. 
	int sizeofQueue;   //number of elements in the queue.
	int [] array;      //array to store values.

	public Queue(int size){
		addPointer=0;
		removePointer=0;
		sizeofQueue=0;
		array=new int[size+1]; //because addPointer and removePointer cannot point at same index,so in order to create a buffer i.e space of one box or index between them.
	}
	
	//function to add elements into the queue.
	public void enqueue(int number) throws Exception{
		System.out.println("Inserting : " + number);
		//if addPointer point at last position so we have to check whether removePointer points at 0 position or not before adding an element at the last position,to maintain a space between the pointers.
		if(addPointer==array.length-1){
			if(addPointer+1-array.length==removePointer){
				throw new Exception("Cannot enqueue, Queue is full"); 
			}
			array[addPointer]=number;
			sizeofQueue++;
			addPointer=0;
		}
		else{
			if(addPointer+1==removePointer){
				throw new Exception("Cannot enqueue, Queue is full"); 
			}
			array[addPointer]=number;
			sizeofQueue++;
			addPointer++;
		}
	}

	//function to delete elements from the queue.
	public int dequeue() throws Exception{
		System.out.println("Dequeue Operation.");
		if(sizeofQueue==0){
			throw new Exception("Cannot remove, Queue is Empty");
		}
		if(removePointer==array.length-1){
			removePointer=0;
		}
		sizeofQueue--;
		removePointer++;
		return array[removePointer-1];
	}

	//function to check is queue empty?
	public boolean empty(){
		if(sizeofQueue==0){
			return true;
		}
		return false;
	}

	//function to ge the size of the array.
	public int size(){
		return sizeofQueue;	
	}
	
	//function to display the queue.
	public void display(){
		if(sizeofQueue==0){			
			System.out.println("Empty Queue.");
			return;
		}
		System.out.print("Queue : ");
		for(int i=removePointer; i<(sizeofQueue+removePointer);i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}	


	
	