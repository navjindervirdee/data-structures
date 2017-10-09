//Program to implement Stack using Array.

import java.lang.Exception;
public class MyStack{
	int topPointer; //points to the position of latest added element.
	int [] arraytostoreStack; //array.
		
	public MyStack(int size){
		topPointer=-1; //initially points to nothing as empty.
		arraytostoreStack = new int[size];
	}

	//function to add elements into the stack.
	public void push(int number) throws Exception {
		//if stack is full.
		if(topPointer>=arraytostoreStack.length-1){
			throw new Exception("Cannot push,Stack is full");
		}
		else{
			System.out.println("Push num : " + number);
			topPointer=topPointer+1;
			arraytostoreStack[topPointer]=number;
		}
	}

	//function to get the latest added element without removing it.
	public int top() throws Exception{
		//if stack is empty.
		if(topPointer==-1){
			throw new Exception("Stack is empty.");
		}
		return arraytostoreStack[topPointer];
	}

	//function to remove the latest added element.
	public int pop() throws Exception {
		//if stack is empty.
		if(topPointer==-1){
			throw new Exception("Cannot pop,Stack is empty.");
		}
		System.out.println("Poping.");
		int topElement=arraytostoreStack[topPointer];
		topPointer=topPointer-1;
		return topElement;
	}
	
	//function to get the number of elements in the stack.
	public int size(){
		return topPointer+1;
	}
	
	//function to display the stack.
	public void displayStack(){
		System.out.print("Stack : [" + " ");
		for(int i=0;i<=topPointer;i++){
			System.out.print(arraytostoreStack[i]+" ");
		}
		System.out.println("]"); 
	}
}
		
		

	
		