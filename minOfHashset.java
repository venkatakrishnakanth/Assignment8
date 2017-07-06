//Done by Krishna Kanth
/**3)Find Minimum element of Java HashSet Example*/
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class minOfHashset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet<Integer> hs = new HashSet<>();
		Scanner s= new Scanner(System.in);
		System.out.println("\nEnter the numbers from which you want to find the minimum number, and enter any character to see the answer:");
		while(s.hasNextInt()){
		hs.add(s.nextInt());}
		System.out.println("Elements in hash set are:\n");
		for(Integer i:hs)
			System.out.print(i+"  ");
		System.out.println("\n************Minimum number is: "+Collections.min(hs)+"  **********");



	}

}
