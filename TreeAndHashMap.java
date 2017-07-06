//done by Krishna Kanth
/**5)Check if a particular key exists in Java HashMap example
6)Check if a particular value exists in Java HashMap example
7)Get lowest and highest key stored in Java TreeMap example*/



import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class TreeAndHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		student s1 = new student(10,"Krishna",78,5000.00);
		student s2 = new student(34,"Kanth",85,5720.00);
		student s3 = new student(43,"Venkata",49,44100.00);
		student s4 = new student(67,"Musunuru",64,4040.00);
		
		HashMap<Integer, student> hm = new HashMap<>();
		TreeMap<Integer,student> tm=new TreeMap<>(); 
		hm.put(s1.getId(), s1);
		hm.put(s2.getId(), s2);
		hm.put(s3.getId(), s3);
		hm.put(s4.getId(), s4);
		tm.put(s1.getId(), s1);
		tm.put(s2.getId(), s2);
		tm.put(s3.getId(), s3);
		tm.put(s4.getId(), s4);
		
		Set hashMapKeys= hm.keySet();
		Set treeMapKeys = tm.keySet();
		
		//checking whether the key is present in hashmap or not.
		System.out.println("Checking whether key 10 is present in the hashmap: ");
		if(hashMapKeys.contains(10))
			System.out.println("Yes the key 10 is present in the hashMap and its value is: "+hm.get(10));
		else
			System.out.println("Nope. The key 10 is not present in the hashMap");
		
		//6.) Checking whether the value is present in hashmap or not
		System.out.println("Checking whether value of a student s5 = new student(10,\"Krishna\",78,5000.00) is present in the hashmap: ");
		student s5 = new student(10,"Krishna",78,5000.00);
				
		for (Map.Entry m:hm.entrySet()){
			if(m.getValue().equals(s5)){
				System.out.println("Yes the given value is present in the hashMap");
				}			
		}
		
		if(!(hm.containsValue(s5)))
			System.out.println("No, the given value is not found in the HashMap");
		
		//7.) Getting the Highest and lowest key in treeMap.
		System.out.println("Minimum key in the treeMap is: "+Collections.min(treeMapKeys));
		System.out.println("Maximum key in the treeMap is: "+Collections.max(treeMapKeys));
		
		

	}

}

class student{
	private int id;	
	private String name;
	private int marks;
	private double fee;
	
	public student(int id, String name, int marks, double fee) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.fee = fee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name + ", marks=" + marks + ", fee=" + fee + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(fee);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + marks;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		student other = (student) obj;
		if (Double.doubleToLongBits(fee) != Double.doubleToLongBits(other.fee))
			return false;
		if (id != other.id)
			return false;
		if (marks != other.marks)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
