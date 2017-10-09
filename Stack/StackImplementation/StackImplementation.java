//Using the MyStack class.
public class StackImplementation{
	public static void main(String [] args){
		MyStack stack = new MyStack(5); //create stack of size = 5
		try{
			stack.push(10); //push num=10
			stack.push(12); //push num=12
			stack.push(14); //push num=14

			System.out.println("Top Element : " + stack.top());

			stack.push(16); //push num=16
			stack.push(18); //push num=18
			
			stack.displayStack(); //display stack.
			System.out.println("Size = "+stack.size()); //get size
			
			stack.pop();          //remove topmost element
			stack.displayStack(); //display stack.
			stack.pop();          //remove topmost element
			stack.displayStack(); //display stack.
			stack.pop();          //remove topmost element
			stack.displayStack(); //display stack.
			stack.pop();          //remove topmost element
			stack.displayStack(); //display stack.
			stack.pop();          //remove topmost element
			stack.displayStack(); //display stack.
			
			System.out.println("Size = "+stack.size()); //get size
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
		 