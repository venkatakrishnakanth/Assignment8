//Done by Krishna Kanth
/**Find Minimum element of Java ArrayList Example*/


import java.util.ArrayList;
import java.util.Scanner;

public class minOfArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayList<Integer> al = new ArrayList<>();
		Scanner s= new Scanner(System.in);
		System.out.println("\nEnter the numbers from which you want to find the minimum number, and enter any character to see the answer:");
		while(s.hasNextInt()){
		al.add(s.nextInt());}
		al.sort(null);
		System.out.println("Elements in ArrayList are:");
		for(Integer i:al)
			System.out.print(i+"  ");
		
		System.out.println("\n******************Minimum Number is: "+al.get(0)+" **********");
	}

}
