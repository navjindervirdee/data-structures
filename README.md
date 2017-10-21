# data-structures

Implemented following Data Structures using Java Language :
1.   Arrays
2.   ArrayList
3.   LinkedList
4.   Doubly-LinkedList
5.   Circular LinkedList
6.   Stack using Array and LinkedList
7.   Queue using Array and LinkedList
8.   Dequeue - Double Sided Queue
9.   Priority-Queue using Max-Heap Property
10.  BinarySearch Tree
11.  AVL Tree
12.  Splay Tree
13.  Disjoint Sets
14.  Red-Black Tree


* **Arrays**: An array is a container object that holds a fixed number of values of a single type. The length of an array is established     when the array is created. After creation, its length is fixed.
    * Functions Implemented :
      * Insertion in an Array.
      * Deletion from an Array.
      * Binary Search
      * Linear Search
      * Bubble Sort
    
* **ArrayList**: In computer science, a dynamic array, growable array, or array list is a random access, variable-size list data           structure that allows elements to be added or removed. Dynamic arrays overcome a limit of static arrays, which have a fixed capacity     that needs to be specified at allocation.

* **LinkedList**: In computer science, a linked list is a linear collection of data elements, in which linear order is not given by       their physical placement in memory. Each pointing to the next node by means of a pointer. It is a data structure consisting of a         group of nodes which together represent a sequence. Under the simplest form, each node is composed of data and a reference (in           other words,a link) to the next node in the sequence. This structure allows for efficient insertion or removal of elements from any     position in the sequence during iteration. 

* **DoublyLinkedList**: In computer science, a doubly linked list is a linked data structure that consists of a set of sequentially       linked records called nodes. Each node contains two fields, called links, that are references to the previous and to the next node in   the sequence of nodes. The beginning and ending nodes' previous and next links, respectively, point to some kind of terminator,         typically a sentinel node or null, to facilitate traversal of the list. It can be conceptualized as two singly linked lists formed       from the same data items, but in opposite sequential orders.

* **CircularLinkedList**: Circular Linked List is a variation of Linked list in which the first element points to the last element and     the last element points to the first element. Both Singly Linked List and Doubly Linked List can be made into a circular linked list.

* **Stack**: In computer science, a stack is an abstract data type that serves as a collection of elements, with two principal             operations:
  * push, which adds an element to the collection, and
  * pop, which removes the most recently added element that was not yet removed.
  
  The order in which elements come off a stack gives rise to its alternative name, LIFO (last in, first out). Additionally, a peek         operation may give access to the top without modifying the stack.
  
* **Queue**: In computer science, a queue is a particular kind of abstract data type or collection in which the entities in the           collection are kept in order and the principle (or only) operations on the collection are the addition of entities to the rear           terminal position, known as enqueue, and removal of entities from the front terminal position, known as dequeue. This makes the queue   a First-In-First-Out (FIFO) data structure. In a FIFO data structure, the first element added to the queue will be the first one to be   removed.

* **PriorityQueue**: In computer science, a priority queue is an abstract data type where each element has a "priority" associated with   it. In a priority queue, an element with high priority is served before an element with low priority. Priority queues are often         implemented with heaps, they are conceptually distinct from heaps. A priority queue is an abstract concept. Just as a list can be       implemented with a linked list or an array, a priority queue can be implemented with a heap or a variety of other methods such as an     unordered array.

* **BinarySearchTree**: A binary search tree is a rooted binary tree, whose internal nodes each store a key (and optionally, an           associated value) and each have two distinguished sub-trees, commonly denoted left and right. The tree additionally satisfies the       binary search tree property, which states that the key in each node must be greater than or equal to any key stored in the left sub-     tree, and less than or equal to any key stored in the right sub-tree. They allow fast lookup, addition and removal of items, and can     be used to implement either dynamic sets of items, or lookup tables that allow finding an item by its key (e.g., finding the phone       number of a person by name).

* **AVL Tree**: In computer science, an AVL tree is a self-balancing binary search tree. It was the first such data structure to be       invented. In an AVL tree, the heights of the two child subtrees of any node differ by at most one; if at any time they differ by more   than one, rebalancing is done to restore this property. Lookup, insertion, and deletion all take O(log n) time in both the average and   worst cases, where n is the number of nodes in the tree prior to the operation. Insertions and deletions may require the tree to be     rebalanced by one or more tree rotations.

* **Splay Tree**: A splay tree is a self-adjusting binary search tree with the additional property that recently accessed elements are     quick to access again. It performs basic operations such as insertion, look-up and removal in O(log n) amortized time. All normal       operations on a binary search tree are combined with one basic operation, called splaying. Splaying the tree for a certain element       rearranges the tree so that the element is placed at the root of the tree. One way to do this is to first perform a standard binary     tree search for the element in question, and then use tree rotations in a specific fashion to bring the element to the top. 

* **Red-Black Tree**: A red–black tree is a kind of self-balancing binary search tree. Each node of the binary tree has an extra bit,     and that bit is often interpreted as the color (red or black) of the node. These color bits are used to ensure the tree remains         approximately balanced during insertions and deletions. The balancing of the tree is not perfect, but it is good enough to allow it to   guarantee searching in O(log n) time, where n is the total number of elements in the tree. The insertion and deletion operations,       along with the tree rearrangement and recoloring, are also performed in O(log n) time.

   * Each node is either red or black.
   * The root is black.
   * All leaves (NIL) are black.
   * If a node is red, then both its children are black.
   * Every path from a given node to any of its descendant NIL nodes contains the same number of black nodes.
 
* **Disjoint-Sets**: In computer science, a disjoint-set data structure, also called a union–find data structure or merge–find set, is a   data structure that keeps track of a set of elements partitioned into a number of disjoint (non-overlapping) subsets. It provides       near-constant-time operations to add new sets, to merge existing sets, and to determine whether elements are in the same set. In         addition to many other uses, disjoint-sets play a key role in Kruskal's algorithm for finding the minimum spanning tree of a graph.
