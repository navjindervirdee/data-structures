//Program to Impelement DisjointSet Data Structure.

public class DisjointSet{
	int [] parent;   //array to store the elements ids.
	int [] rank;     //rank is the height of the tree. Because this set works on tree property. Elements in same set have common id which is the root of tree, tree is made from these elements.
	int numofElements;   //size of the set.

	public DisjointSet(int length){
		numofElements=length;
		parent= new int[numofElements];
		rank = new int[numofElements];
	}

	//function to make the Set. Id identifies one set from another.	
	public void makeSet(int id)throws Exception{
		System.out.println("Inserting Element with id : " + id);
		if(id>=numofElements){
			throw new Exception("Size exceeded!");
		}
		parent[id]=id;
		rank[id]=0;
	}

	//function to find root of set in which the element with the given id belong.
	public int find(int id)throws Exception{
		if(id>=numofElements){
			throw new Exception("Invalid Id!");
		}
		if(id==parent[id]){
			return parent[id]; 
		}
		return find(parent[id]);
	}

	//function to take union of two sets.
	public void union(int id1, int id2)throws Exception{
		System.out.println("Union Operation of " + id1 + " and " + id2);
		if(id1>=numofElements || id2>=numofElements){
			throw new Exception("Invalid Id!");
		}
		int parentid1 = find(id1);  //get the root of set with id1.
		int parentid2 = find(id2);  //get the root of set with id2.
		
		//if already in the same set
		if(parentid1==parentid2){
			return;
		}

		//find the tree with samller rank and change the root id of smaller set to larger set's root id.
		if(rank[parentid1]>rank[parentid2]){
			parent[parentid2]=parentid1;
		}
		else{
			parent[parentid1]=parentid2;
			if(rank[parentid1]==rank[parentid2]){
				rank[parentid2]=rank[parentid2]+1;
			}
		}
	}
}
			
		
	