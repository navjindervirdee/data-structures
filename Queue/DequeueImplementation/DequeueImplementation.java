//Program to execute Dequeue.
public class DequeueImplementation{
	public static void main(String [] args){
		Dequeue queue = new Dequeue(5);
		queue.addRight(10);
		queue.display();

		queue.addLeft(20);
		queue.display();

		queue.addRight(12);
		queue.display();

		queue.addLeft(18);
		queue.display();
	
		queue.addRight(16);
		queue.display();
	}
}