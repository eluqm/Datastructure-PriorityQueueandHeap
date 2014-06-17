import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Test {
	
	public static void main(String[] args) {

		File in = new File("Heap_Sort.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		PriorityQueue pq = new PriorityQueue();
		
		while(sc.hasNextLine()) {
			// Read entry's key
			int key = Integer.valueOf(sc.nextLine().trim());
			// Read entry's value
			String value = sc.nextLine();
			
			Element e = new Element(key, value);
			// Priority queue insertion
			if(!pq.insert(e)){
				System.out.println("key "+ e.getKey()+" already exits");}
		}
		
		while(pq.size() != 0) {
			// Remove
			Tipo_Element e = pq.remove();
			System.out.println(e.getKey() + " " + e.getValue());
		}
	}

}
