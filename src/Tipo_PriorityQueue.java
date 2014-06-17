
public interface Tipo_PriorityQueue {
	
	/**
	 * Returns the number of elements in this priority queue.
	 * @return the number of elements in this priority queue.
	 */
	public int size();
	
	/**
	 * This method retrieves, but does not remove, the element with 
	 * the highest priority, i.e. the head of this priority queue or 
	 * null if this priority queue is empty.
	 * @return the head of this queue, or null if this queue is empty.
	 */
	public Tipo_Element get();
	
	/**
	 * This method retrieves and removes the element with the highest 
	 * priority, i.e. the head of this priority queue, or returns null
	 * if this priority queue is empty.
	 * @return the head of this queue, or null if this queue is empty.
	 */
	public Tipo_Element remove();
	
	/**
	 * This method inserts the specified element into this priority
	 * queue if and only if there are no elements with the same key.
	 * @param e the element to be inserted.
	 * @return true if the element was inserted successfully.
	 */
	public boolean insert(Tipo_Element e);
}
