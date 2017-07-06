//Done by Krishna Kanth
/**4)Reverse order of all elements of Java ArrayList Example*/

import java.util.ArrayList;
import java.util.Collections;

public class ReverseArraylist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList al = new ArrayList();
		al.add("Krishna");
		al.add(1);
		al.add("Kanth");
		al.add(30);
		al.add("Musunuru");
		System.out.println("*****Before reversing the arraylist********");
		for(Object a: al){
			System.out.println(a);
		}
		Collections.reverse(al);
		System.out.println("");
		System.out.println("********After reversing the arraylist*******");
		for(Object o:al)
			System.out.println(o);

	}

}
