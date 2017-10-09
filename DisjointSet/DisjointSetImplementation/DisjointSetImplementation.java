//Program to execute the Disjoint Set.
public class DisjointSetImplementation{
	public static void main(String [] args){
		DisjointSet set = new DisjointSet(5);  //create Disjoint Set of size = 5.
		try{
			set.makeSet(0);   
			set.makeSet(1);
			set.makeSet(2);
			set.makeSet(3);
			set.makeSet(4);

			System.out.println("Find 0 : " + set.find(0));
			System.out.println("Find 1 : " + set.find(1));
			System.out.println("Find 2 : " + set.find(2));
			System.out.println("Find 3 : " + set.find(3));
			System.out.println("Find 4 : " + set.find(4));
		
			set.union(4,3);
			System.out.println("Find 4 : " + set.find(4));
			System.out.println("Find 3 : " + set.find(3));
	
			set.union(0,1);
			System.out.println("Find 1 : " + set.find(1));
			System.out.println("Find 0 : " + set.find(0));

			set.union(1,2);
			System.out.println("Find 2 : " + set.find(2));
			System.out.println("Find 1 : " + set.find(1));

			set.union(2,3);
			System.out.println("Find 3 : " + set.find(3));
			System.out.println("Find 2 : " + set.find(2));

			System.out.println("\nFind 0 : " + set.find(0));
			System.out.println("Find 1 : " + set.find(1));
			System.out.println("Find 2 : " + set.find(2));
			System.out.println("Find 3 : " + set.find(3));
			System.out.println("Find 4 : " + set.find(4));
			System.out.println("Find 5 : " + set.find(5));
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}