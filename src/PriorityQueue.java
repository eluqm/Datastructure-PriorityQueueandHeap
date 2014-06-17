


public class PriorityQueue implements Tipo_PriorityQueue {
	
	private Tipo_Element[] entries;
	private int size;

	public PriorityQueue() {
		entries = new Tipo_Element[100];
		size = 0;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	/**
	 * Tipo_Element get(): 
	 * return an item with major priority , without remove it
	 * @return 
	 */
	@Override
	public Tipo_Element get() {
		
		return entries[0];
	}
	
	/**
	 * Tipo_Element remove(): 
	 * remove a element with major priority 
	 * calls another function heapify(int i) to rebuild the heap
	 * @return 
	 */
	@Override
	public Tipo_Element remove() {
		
		if (size == 0) return null;
		
		size--;
		Tipo_Element min = entries[0];
		Tipo_Element last = entries[size];
		entries[0] = last;						
		entries[size] = null;
		heapify(0);
		return min;
	}
	
	/**
	 * insert(Tipo_ELement e): 
	 * insert an item "e" into priority queue and return true, otherwise
	 * whether item  already exist with the same "key", return false
	 * @return true or false.
	 */
	@Override
	public boolean insert(Tipo_Element e) {
		
		if (containsKey(e.getKey())) return false;
		
		entries[size] = e;
		int i = size;
		int parent = (i-1)/2;
		//searching  position's "item e" 
		while(i > 0 && entries[parent].getKey() > entries[i].getKey()) {
			Tipo_Element tmp = entries[parent];
			entries[parent] = entries[i];
			entries[i] = tmp;
			i = parent;
			parent = (i-1)/2;
		}
		size++;
		return true;
	}

	/**
	 * containsKey(int key): 
	 * search if a "key" already exist on priority queue, return true,
	 * otherwise return false
	 * @return true or false.
	 */
	private boolean containsKey(int key) {
		int i = 0;
		while (i < size) {
			if (entries[i].getKey() == key)
				return true;
			else {
				i ++;
			}
		}
		return false;
	}
	
	/**
	 * heapify(int i):
	 * The heapify method, which runs in O(log n) time, restores the heap
	 * property after a deletion. 
	 * @param i the index of the element to be checked
	 */
	private void heapify(int i) {
		int iLeft  = 2 * i + 1; // index of the left child 
		int iRight = 2 * i + 2; // index of the right child
		int shortest;			// temporal value 
		
		if (iLeft < size && entries[iLeft].getKey() < entries[i].getKey()) 
			shortest = iLeft;
		else
			shortest = i;
		if (iRight < size && entries[iRight].getKey() < entries[shortest].getKey())
			shortest = iRight;
		
		if (shortest != i) {
			Tipo_Element emax = entries[i];
			Tipo_Element emin = entries[shortest];
			entries[i] = emin;
			entries[shortest] = emax;
			heapify(shortest);	//The recursive call "heapify" for index of  'shortest'
		}		
	}
}
