//Use of the ArrayList.

public class ArrayListImplementation{
	public static void main(String [] args){
		ArrayList list = new ArrayList(); //create ArrayList.
		
		list.addElement(10); //add num=10 to the ArrayList.
		System.out.println("Element at pos" + 0 + "=" + list.getElement(0)); //print element at pos=0.
		
		list.setValue(12,0); //change value of the element at pos=0.
		System.out.println("Element at pos" + 0 + "=" + list.getElement(0)); //print the value of the element at pos=0.
		
		list.addElement(14); //add num=14 to the ArrayList.
		list.addElement(16); //add num=16 to the ArrayList.
		list.addElement(18); //add num=18 to the ArrayList.
		list.addElement(20); //add num=20 to the ArrayList.
		
		System.out.println("Size = " + list.size()); //print the num of elements in the ArrayList.
		
		list.removeElement(0); //remove the element at pos=0.
		list.addElement(22); //add num=22 to the ArrayList.
		list.removeElement(3); //remove element at pos=3.
		
		System.out.println("Size = " + list.size());

		//print entire ArrayList.
		System.out.println("ArrayList: ");
		for(int i=0;i<list.size();i++){
			System.out.print(list.getElement(i) + " ");
		}
		System.out.println();
	}
}
		
		
