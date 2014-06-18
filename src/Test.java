
/**
 * 					TIPOS E ESTRUTURAS DE DADOS (SCC-5763)
							TRABALHO – 2014
						Prof. Ricardo J. G. B. Campello

	nome(s): 

	Paul Augusto Bustios Belizario	 nº: 9060101
	Edson Francisco Luque Mamani     nº: 9057024

 */




import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		//other variables
		String valueStr="";int n=0;		
		PrintWriter pw = null;FileWriter fichero = null;File in=null;Scanner s = new Scanner(System.in);		

		//CREATE A PRIORITY QUEUE
		PriorityQueue pq = new PriorityQueue();

		//Start program		
		System.out.println("number of items (random) -1 to end program : \n");
		n = s.nextInt();
		while(n!=-1)
		{			

			if(n>100) System.out.println("number of items > 100 introduce other: \n");
			else{
				try {
					fichero = new FileWriter("Heap_Sort.txt");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pw= new PrintWriter(fichero);

				//create random "keys" and "values";
				for(int y=0;y<n;y++){		

					pw.println((int)Math.floor(Math.random()*(100-0+1)+0));

					int lenghValue=(int) Math.floor(Math.random()*(8-1+1)+1);
					for(int yy=0;yy<lenghValue;yy++)
					{
						valueStr+=(char)Math.floor(Math.random()*(90-65+1)+65);			
					}
					pw.println(valueStr);
					valueStr="";		
				}
				pw.close();
				System.out.println("file Heap_Sort.txt finished! \n");
				System.out.println("reading file....\n");


				in=new File("Heap_Sort.txt");	
				Scanner sc = null;
				try {
					sc = new Scanner(in);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				while(sc.hasNextLine()) {
					// Read entry's key
					int key = Integer.valueOf(sc.nextLine().trim());
					// Read entry's value
					String value = sc.nextLine();

					Element e = new Element(key, value);
					// Priority queue insertion
					if(!pq.insert(e)){
						System.out.println("key = "+ e.getKey()+" already exits , value : "+ e.getValue());}
				}

				System.out.println("=========================\nKey ---> Value\n=========================\n");
				while(pq.size() != 0) {
					// Remove
					Tipo_Element e = pq.remove();
					System.out.println(e.getKey() + "  --->  " + e.getValue());
				}
			}
			System.out.println("number of items (random) -1 to end program : \n");
			n = s.nextInt();
		}
		
	}


}


