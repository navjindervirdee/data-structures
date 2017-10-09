//Program to execute the LinedList.
public class LinkedListImplementation{
	public static void main(String [] args){
		LinkedList list = new LinkedList(); //create a LinkedList.
		try{
			list.add(10);
			list.popFront();
			list.add(12);
			
			list.display();

			list.pushFront(22);
			list.display();
			
			list.add(14);
			list.display();

			list.add(16);
			list.display();
			
			System.out.println("Size : " + list.size());
			System.out.println("Top elements is : " + list.topFront());
			
			list.popFront();
			
			list.display();
			
			System.out.println("Size : " + list.size());
			System.out.println("Last element is : " + list.topBack());
			
			list.pushBack(24);
			
			System.out.println("Last element is : " + list.topBack());
			
			list.add(18);
			
			System.out.println("Size : " + list.size());
			
			list.pushFront(20);
			
			System.out.println("Size : " + list.size());
			
			list.display();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}