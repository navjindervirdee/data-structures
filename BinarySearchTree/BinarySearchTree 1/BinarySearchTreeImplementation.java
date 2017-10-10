//Program to execute the BinarySearchTree.
public class BinarySearchTreeImplementation{
	public static void main(String [] args){
		BinarySearchTree tree = new BinarySearchTree();
		try{
			tree.add(10);
			tree.add(12);
			tree.add(20);
			tree.add(100);
			tree.add(56);
			tree.add(1);
			tree.add(67);
			tree.add(2);
			tree.add(4);
			tree.add(9);
			tree.add(82);
			
			System.out.println("Find 1 : " + tree.findNode(1));
			
			System.out.println("InOrder");
			tree.display("inOrder");
			
			System.out.println("PreOrder");
			tree.display("preOrder");
			
			System.out.println("PostOrder");
			tree.display("postOrder");
			
			System.out.println("LevelOrder");
			tree.display("levelOrder");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}