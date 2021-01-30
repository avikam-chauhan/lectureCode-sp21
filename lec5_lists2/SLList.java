package lec5_lists2;

/** An SLList is a list of integers, which hides the terrible truth
   * of the nakedness within. */
public class SLList {	
	private static class IntNode {
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode n) {
			item = i;
			next = n;
			// System.out.println(size);
		}
	} 

	/** The first item (if it exists) is at sentinel.next. */
	private IntNode sentinel;
	private int size;

	private static void lectureQuestion() {
		SLList L = new SLList();
		IntNode n = new IntNode(5, null);
	}

	/** Creates an empty SLList. */
	public SLList() {
		sentinel = new IntNode(63, null);
		size = 0;
	}

	/** Creates a SLList with x as the first value. */
	public SLList(int x) {
		sentinel = new IntNode(63, null);
		sentinel.next = new IntNode(x, null);
		size = 1;
	}

	/** Creates a SLList from an array of integers. */
	public SLList(int[] lst) {
		sentinel = new IntNode(63, null);
		size = 0;
		IntNode ptr = sentinel;
		for (int x: lst) {
			ptr.next = new IntNode(x, null);
			ptr = ptr.next;
			size++;
		}
	}

 	/** Adds x to the front of the list. */
 	public void addFirst(int x) {
 		sentinel.next = new IntNode(x, sentinel.next);
 		size = size + 1;
 	}

 	/** Squares the list by adding a squared node after each original node. */
 	public void square() {
 		IntNode ptr = sentinel.next;
 		while (ptr != null) {
 			ptr.next = new IntNode((int) Math.pow(ptr.item, 2), ptr.next);
 			ptr = ptr.next.next;
		}
	}

	/** Adds x to the front of the list and squares the list. */
	public void addFirstSquare(int x) {
		square();
		addFirst(x);
	}

	/** Adds x to the end of the list and squares the list. */
	public void addLastSquare(int x) {
		square();
		addLast(x);
	}

 	/** Returns the first item in the list. */
 	public int getFirst() {
 		return sentinel.next.item;
 	}

 	/** Deletes the first item in the list. */
 	public void deleteFirst() {
 		sentinel.next = sentinel.next.next;
	}

 	/** Adds x to the end of the list. */
 	public void addLast(int x) {
 		size = size + 1; 		

 		IntNode p = sentinel;

 		/* Advance p to the end of the list. */
 		while (p.next != null) {
 			p = p.next;
 		}

 		p.next = new IntNode(x, null);
 	}
 	
 	/** Returns the size of the list. */
 	public int size() {
 		return size;
 	}

	/** Combine adjacent nodes that have equal values. */
	public void addAdjacent() {
 		IntNode ptr = sentinel.next;
 		while (ptr.next != null) {
 			if (ptr.item == ptr.next.item) {
 				ptr.item *= 2;
 				ptr.next = ptr.next.next;
			} else {
 				ptr = ptr.next;
			}
		}
	}

	public static void main(String[] args) {
 		/* Creates a list of one integer, namely 10 */
 		SLList L = new SLList();
 		L.addLast(20);
 		System.out.println(L.size());

 		SLList L2 = new SLList(new int[] {1, 2, 3, 4, 5, 4, 3, 2, 1});

		SLList L3 = new SLList(new int[] {1, 1, 2, 3});
		L3.addAdjacent();

		SLList L4 = new SLList(new int[] {1, 2});
		L4.addLastSquare(5);
		L4.addLastSquare(7);
 	}
}