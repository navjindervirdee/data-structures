//Program to implement Circular Queue using an array.

public class Queue{
	static int [] array;  //arary to store values.
	static int size;      //number of elements in the queue.
	static int addPointer;//points to position where the latest number is added.
	static int removePointer;//point to position of the number which is to be deleted.
	
	public Queue(int size){
		array=new int[size+1];
		this.size=0;
		addPointer=0;
		removePointer=0;
	}

	//function to add elements into the queue.
	static public void enqueue(int number){
		//if queue is full.
		if(addPointer+1==removePointer){
			System.out.println("Queue is Full.");			
			return;
		}
		if(addPointer==array.length-1){
			if(removePointer==0){
				System.out.println("Queue is Full.");
				return;
			}
			else{
				System.out.println("Enqueue num : " + number);
				array[addPointer]=number;
				addPointer=0;	
				size++;
				return;
			}
		}
	
		System.out.println("Enqueue num : " + number);
		array[addPointer]=number;
		addPointer++;
		size++;
	}
	
	//function to remove element. 
	static public int dequeue(){
		//if queue is empty.
		if(removePointer==addPointer){
			System.out.println("Empty Queue.");
			return -1;
		}

		System.out.println("Dequeue Operation.");

		if(removePointer==array.length-1){
			int temp = array[removePointer];
			removePointer=0;
			size--;
			return temp;
		}
		removePointer++;
		size--;
		return array[removePointer-1];
	}

	//function to display queue.
	static public void display(){
		if(size==0){
			System.out.println("Empty Queue.");
			return;
		}
		
		System.out.print("Queue : ") ;
		for(int i=removePointer;i<size+removePointer;i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	//main function to run the program.
	static public void main(String [] args){
		Queue queue = new Queue(5); //create a queue 
		queue.enqueue(10); //add num = 10
		queue.enqueue(20); //add num = 20
		queue.enqueue(30); //add num = 30
		queue.enqueue(40); //add num = 40 
		queue.enqueue(50); //add num = 50
		queue.enqueue(60); //add num = 60
		
		queue.display();   //display queue.

		queue.dequeue();   //dequeue
		queue.dequeue();   //dequeue

		queue.display();   //display queue.

		queue.enqueue(20); //add num = 20
		
		queue.dequeue();   //dequeue
		queue.display();   //display queue
		queue.dequeue();   //dequeue
		queue.display();   //display queue
		queue.dequeue();   //dequeue
		queue.display();   //display queue 
		queue.dequeue();   //dequeue
		queue.display();   //display queue   
		queue.dequeue();   //dequeue
		queue.display();   //display queue
		queue.dequeue();   //dequeue
		queue.display();   //display queue
		
	}
}
					
		
	
	
	