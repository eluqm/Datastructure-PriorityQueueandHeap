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
			String k = sc.nextLine();
			String value = sc.nextLine();
			
			int key = Integer.valueOf(k);
			Entry entry = new Entry(key, value);
			pq.insert(entry);
		}
		
		while(pq.size() != 0) {
			Tipo_Entry e = pq.remove();
			System.out.println(e.getKey() + " " + e.getValue());
		}

	}

}
