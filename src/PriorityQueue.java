
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

	@Override
	public Tipo_Element get() {
		// Retorna o item com maior prioridade da fila F, sem removê-lo.
		return entries[0];
	}

	@Override
	public Tipo_Element remove() {
		// Remove e retorna o item com maior prioridade da fila F.
		if (size == 0) return null;
		
		size--;
		Tipo_Element min = entries[0];
		Tipo_Element last = entries[size];
		entries[0] = last;
		entries[size] = null;
		heapify(0);
		return min;
	}

	@Override
	public boolean insert(Tipo_Element e) {
		// Insere um item x na fila de prioridade F e retorna true, caso não exista item em
		// F com a mesma chave de x. Se já existir item em F com a mesma chave de x, retorna false
		if (containsKey(e.getKey())) return false;
		
		entries[size] = e;
		int i = size;
		int parent = (i-1)/2;
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

	private boolean containsKey(int key) {
		int i = 0;
		while (i < size) {
			if (entries[i].getKey() == key)
				return true;
			else {
				int p = entries[i].getKey() > key ? 1 : 2;
				i = i * 2 + p;
			}
		}
		return false;
	}
	
	/**
	 * The heapify method, which runs in O(log n) time, restores the heap
	 * property after a deletion. 
	 * @param i the index of the element to be checked
	 */
	private void heapify(int i) {
		int iLeft  = 2 * i + 1; // index of the left child 
		int iRight = 2 * i + 2; // index of the right child
		int shortest;
		
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
			heapify(shortest);
		}		
	}
}
