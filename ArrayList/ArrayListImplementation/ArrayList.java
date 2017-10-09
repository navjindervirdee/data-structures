//Program to implement ArrayList i.e Dynamic Array.
public class ArrayList{
	int [] array; //array
	int numofElements; //number of elements in the array.
	int addPointer; //pointer points to the position where new number will be added.
	
	public ArrayList(){
		array = new int[4]; //initial size of the array = 4
		numofElements=0;  
		addPointer=0;
	}
	
	//function to access elements at a given position.
	public int getElement(int index){
		return array[index];
	}

	//funciton to change the value of the element at the given position
	public void setValue(int value, int index){
		array[index]=value;
	}
	
	//function to add element in the array.
	public void addElement(int number){
		//If array is full, then create new array of twice the size and copy elements from previous array to the new array.
		if(addPointer>array.length-1){
			int [] newArray = new int[2*array.length];
			for(int i=0;i<array.length;i++){
				newArray[i]=array[i];
			}
			array=newArray;
			array[addPointer]=number;
			addPointer++;
			numofElements++;
			newArray=null;
		}
		else{
			array[addPointer]=number;
			addPointer++;
			numofElements++;
		}
	}

	//function to remove element from the array.
	public void removeElement(int index){
		if(addPointer==0){
			System.out.println("Empty Array");
			return;
		}
		for(int i=index;i<numofElements-1;i++){
			array[i]=array[i+1];
		}
		numofElements--;
		addPointer--;
	}

	//function to get the number of elements in the array.
	public int size(){
		return numofElements;
	}
}

 
	
		

	