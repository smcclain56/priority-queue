import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * A priority queue class implemented using a min heap. Priorities cannot be
 * negative.
 *
 * @author Gennie Cheatham, Sarah McClain
 * @version September 23, 2019
 * @param <E>
 *
 */
public class PriorityQueue {
	protected Map<Integer, Integer> location;
	protected List<Pair<Integer, Integer>> heap;
	/**
	 * Constructs an empty priority queue
	 */
	public PriorityQueue() {
		heap = new ArrayList<Pair<Integer, Integer>>();
		location = new HashMap<Integer, Integer>();
	}
	/**
	 * Insert a new element into the queue with the given priority.
	 *
	 * @param priority priority of element to be inserted
	 * @param element  element to be inserted <br>
	 *                 <br>
	 *                 <b>Preconditions:</b>
	 *                 <ul>
	 *                 <li>The element does not already appear in the priority
	 *                 queue.</li>
	 *                 <li>The priority is non-negative.</li>
	 *                 </ul>
	 *
	 */
	public void push(int priority, int element) {
		// checks to see if the priority is nonnegative
		if (priority < 0) {
			throw new AssertionError();
		}
		Pair newPair = new Pair<>(priority, element);
		int elementOfNewPair = (int) newPair.element;
		// checks to see if the newPair is already in the heap
		if (isPresent(elementOfNewPair) == true) {
			throw new AssertionError();
		}
		// attempts to add the newPair to the heap
		// NOTE: are we checking to see if the array is big enough here?
		try {
			heap.add(newPair);
		} catch (AssertionError e) {
		}
		int indexInArray = heap.indexOf(newPair);
		location.put(element, indexInArray);// adds the new pair values to the hash map
		int currIndex = heap.indexOf(newPair);
		percolateUp(currIndex);
	}
	/**
	 * Remove the highest priority element.
	 *
	 */
	public void pop() {
		if (heap.isEmpty()) {//if the heap is empty throw an error because there is no element to pop
			throw new AssertionError();
		}
		swap(0, heap.size() - 1);//swaps the root element with the last element in the queue
		Pair popPair = heap.get(heap.size()-1);//gets the element we want to remove
		int popelement = (int)popPair.element;
		location.remove(popelement);//removes the element from the hashmap
		heap.remove(heap.size() - 1);//removes the element from the heap
		pushDown(0);//adjusts the resulting heap
	}
	/**
	 * Returns the highest priority in the queue
	 *
	 * @return highest priority value <br>
	 *         <br>
	 *         <b>Preconditions:</b>
	 *         <ul>
	 *         <li>The priority queue is non-empty.</li>
	 *         </ul>
	 */
	public int topPriority() {
		if (heap.isEmpty()) {
			throw new AssertionError();
		}
		return (int) heap.get(0).priority;
	}
	/**
	 * Returns the element with the highest priority
	 *
	 * @return int, element with highest priority
	 */
	public int topElement() {
		if (heap.isEmpty()) {//checks to make sure that the heap is not empty
			throw new AssertionError();
		}
		return (int) heap.get(0).element;//returns the element at the head of the queue
	}
	/**
	 * Change the priority of an element already in the priority queue.
	 *
	 * @param newpriority the new priority
	 * @param element     element whose priority is to be changed <br>
	 *                    <br>
	 *                    <b>Preconditions:</b>
	 *                    <ul>
	 *                    <li>The element exists in the priority queue</li>
	 *                    <li>The new priority is non-negative</li>
	 *                    </ul>
	 */
	public void changePriority(int newpriority, int element) {
		if (isPresent(element) == false || newpriority < 0) {//checks to make sure that the element exists in the queue, and that the new priority is greater than 0
			throw new AssertionError();
		}
		int index = location.get(element);//gets the location of the pair in the priority queue
		int oldPriority = heap.get(index).priority;//the old priority that we want to change
		Pair changedPair = new Pair<Integer, Integer>(newpriority, element);//creates a new pair with the new priority
		heap.set(index, changedPair);//replaces the old pair with the new one
		if (newpriority > oldPriority) {
			pushDown(index);
		} else {
			percolateUp(index);
		}
	}
	/**
	 * Gets the priority of the element
	 *
	 * @param element the element whose priority is returned
	 * @return the priority value <br>
	 *         <br>
	 *         <b>Preconditions:</b>
	 *         <ul>
	 *         <li>The element exists in the priority queue</li>
	 *         </ul>
	 */
	public int getPriority(int element) {
		if (location.containsKey(element)) {
			int index = location.get(element);
			Pair searchPair = heap.get(index);
			return (int) searchPair.priority;
		}
		throw new AssertionError();
	}
	/**
	 * Returns true if the priority queue contains no elements
	 *
	 * @return true if the queue contains no elements, false otherwise
	 */
	public boolean isEmpty() {
		return heap.isEmpty();
	}
	/**
	 * Returns true if the element exists in the priority queue.
	 *
	 * @return true if the element exists, false otherwise
	 */
	public boolean isPresent(int element) {
		if (location.containsKey(element) == true) {// if the element exists in the Hashmap then it is in the priority
			// queue too
			return true;
		}
		return false;
	}
	/**
	 * Removes all elements from the priority queue
	 */
	public void clear() {
		heap.clear();
		location.clear();
	}
	/**
	 * Returns the number of elements in the priority queue
	 *
	 * @return number of elements in the priority queue
	 */
	public int size() {
		return heap.size();
	}
	/*********************************************************
	 * Private helper methods
	 *********************************************************/
	/**
	 * Push down the element at the given position in the heap
	 *
	 * @param start_index the index of the element to be pushed down
	 * @return the index in the list where the element is finally stored
	 */
	private int pushDown(int start_index) {
		int curr = start_index;
		int left = left(curr);
		int right = right(curr);
		int smallestChild;
		while (hasChild(curr) == true) {
			left = left(curr);
			smallestChild = left;
			if (hasTwoChildren(curr) == true) {
				right = right(curr);
				if ((int) heap.get(left).priority > (int) heap.get(right).priority) {
					smallestChild = right;
				}
			}

			if ((int) heap.get(smallestChild).priority <= (int) heap.get(curr).priority) {
				swap(smallestChild, curr);
				curr = smallestChild;
			} else {
				break;
			}
		}
		return curr;
	}
	/**
	 * Percolate up the element at the given position in the heap
	 *
	 * @param int, start_index the index of the element to be percolated up
	 * @return int, the index in the list where the element is finally stored
	 */
	private int percolateUp(int start_index) {
		int indexParent = parent(start_index);// index of current pairs' parent
		int currentIndex = start_index;//index of where to start to start percolate
		Pair parent = heap.get(indexParent);// parent pair
		int priorityParent = (int) parent.priority;// priority of the parent pair
		Pair current = heap.get(currentIndex);// the current pair we are on
		int priorityCurr = (int) current.priority;// priority of the current pair
		while (priorityCurr < priorityParent) {//while the min heap property is being violated, continue percolating
			swap(currentIndex, indexParent);//swap the two pairs
			currentIndex = indexParent;//change the current index that we are on
			indexParent = parent(currentIndex);//change the parent index
			parent = heap.get(indexParent);//get the new parent and current pairs and their priorities
			current = heap.get(currentIndex);
			priorityParent = (int) parent.priority;
			priorityCurr = (int) current.priority;
		}
		return currentIndex;//final index where the element is stored
	}
	/**
	 * Swaps two elements in the priority queue by updating BOTH the list
	 * representing the heap AND the map
	 *
	 * @param i The index of the element to be swapped
	 * @param j The index of the element to be swapped
	 */
	private void swap(int i, int j) {
		Pair firstElement = heap.get(i);
		Pair secondElement = heap.get(j);
		heap.set(i, secondElement);
		heap.set(j, firstElement);
		Pair temp = secondElement;
		location.put((int) firstElement.element, j);
		location.put((int) temp.element, i);
	}
	/**
	 * Computes the index of the element's left child
	 *
	 * @param parent index of element in list
	 * @return index of element's left child in list
	 */
	private int left(int parent) {
		return ((2 * parent) + 1);
	}
	/**
	 * Computes the index of the element's right child
	 *
	 * @param parent index of element in list
	 * @return index of element's right child in list
	 */
	private int right(int parent) {
		return ((2 * parent) + 2);
	}
	/**
	 * Computes the index of the element's parent
	 *
	 * @param child index of element in list
	 * @return index of element's parent in list
	 */
	private int parent(int child) {
		return (int) Math.floor((child - 1) / 2);
	}
	/*********************************************************
	 * These are optional private methods that may be useful
	 **********************************************************
	 * /** Returns true if element has a left child.
	 *
	 * @param i index of element in the heap
	 * @return true if element in heap has a left child
	 */
	private boolean hasChild(int i) {
		int leftChild = left(i);
		if (leftChild < heap.size() ) {
			return true;
		}
		return false;
	}
	/**
	 * Returns true if element has two children in the heap
	 *
	 * @param i index of element in the heap
	 * @return true if element in heap has two children
	 */
	private boolean hasTwoChildren(int i) {
		int rightChild = right(i);
		if (rightChild > heap.size() - 1) {
			return false;
		}
		return true;
	}
	/**
	 * Print the underlying list representation
	 */
	public void printHeap() {
		Pair currentPair;
		for (int i = 0; i < heap.size(); i++) {
			currentPair = heap.get(i);
			System.out.println("Priority = " + currentPair.priority + ", Element = " + currentPair.element);
		}
		System.out.print("\n");
	}
	/**
	 * Print the entries in the location map
	 */
	public void printMap() {
		Pair currentPair;
		System.out.println(location.entrySet());
	}
}