//Program to implement the created Queue.
public class QueueImplementation{
	public static void main(String [] args){
		Queue queue = new Queue(5); //create queue of size=5.
		try{
			System.out.println("Is Queue empty? : " + queue.empty());
		
			queue.enqueue(10);
			queue.enqueue(12);
			queue.enqueue(14);
			queue.enqueue(16);
			queue.enqueue(18);
			
			queue.display();
			
			System.out.println("Size of Queue : " + queue.size());
			
			queue.dequeue();
			queue.dequeue();
		
			queue.display();
	
			
			System.out.println("Size of Queue : " + queue.size());
			
			queue.enqueue(20);
			
			System.out.println("Is Queue empty? : " + queue.empty());
			
			System.out.println("Size of Queue : " + queue.size());
	
			queue.dequeue();
			queue.dequeue();
			
			queue.display();

			queue.dequeue();
			queue.dequeue();
			
			queue.display();
			
			System.out.println("Size of Queue : " + queue.size());
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}

		