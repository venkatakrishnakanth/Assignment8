//done by Krishna Kanth
/** 1) I have 3 classes called Hospital and Doctor, and Patient as below
Class Hospital {
    String hospitalName;
    Doctor doc;
    Address hospitalAddress;
}
Doctor {
   int docId;
   String name;
   String specialization;
   
}
Address {
   String address1;
   String address2;
   String city;
   String state;
   int zipCode;
}

1)Write a program to identify the eliminate the duplicate hospital, if I enter same hospitalName and hospitalAddress ?
2)If user enters his zipcode, identify the hospital near by( use logic by subtracting user zip code with hospital zip code, for example: if user enter 20170 and your hosiptal zipcodes 20186 and 20184 then 20184 is the near one.)
3)If user enters his zipcode, and his illness, identify the hospital near by which supports specialization.
4)Store all hospitalDetails with key as hospitalName and value as HospitalObject. Same for Doctor and Address. If I enter hospital name then list out all the doctor details that are part of the hospital(you can have same hospital name with different location. its like having branches. 
  Duplicate elimination is based on hospitalName and Address.)
5)If user request specialization availability then list out all hospital that have the doctor with those specialization.
*/




import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class docAndHospital {
	

	public static void main(String[] args) {
		
		Doctor d1 = new Doctor(10, "Krishna kanth", "Heart");
		Doctor d2 = new Doctor(20, "venu gopal", "Kidney");
		Doctor d3 = new Doctor(30,"Musunuru Venkata", "Brain");
		Address a1 = new Address("2439 Zink rd", "Apt 302", "Fairborn", "Ohio", 45324);
		Address a2 = new Address("13621 legacy circle", "Apt C", "Herndon", "Virginia", 20171);
		Hospital h1 = new Hospital("Raj soin Medical centre", d1, a1);
		Hospital h2 = new Hospital("United health Medical centre", d2, a2);
		Hospital h3 = new Hospital("United health Medical centre", d3, a2);
		
		ArrayList<Hospital> al = new ArrayList<>();
		al.add(h1);
		al.add(h2);
		al.add(h3);
		
		List<Hospital> ho1 = new ArrayList<>();
		List<Hospital> ho2 = new ArrayList<>();
		ho1.add(h1);
		ho2.add(h2);
		ho2.add(h3);		
		
		HashMap<String,List<Hospital>> hm = new HashMap<>();
		hm.put(h1.hospitalName, ho1);
		hm.put(h2.hospitalName, ho2);
		
		
		al=filterDupes(al,hm); // filter hospitals with same name and address
		DoctorDetailsbyHospitalName(hm); // get the doctor details by hospital name.
		NearestHospital(al); // get the nearest hospital by zip code.
		NearestHospitalByIllness(al);//get nearest hospital by zip code and illness
		HospitalsBySpecialization(al); //get the list of hospitals by specialization.
	}
	public static void HospitalsBySpecialization(ArrayList<Hospital> al){
		System.out.println("\n\n**** Enter specialization to get all hospitals that have doctors with that specialization********\n\n");
		Scanner s = new Scanner(System.in);
		String spec = s.next(); boolean b=true;
		for(Hospital h:al){
			if(h.doc.specialization.equalsIgnoreCase(spec)){ b=false;
				System.out.println("Hospital: "+h.hospitalName+" has doctor "+h.doc.name+" with your desired specialization  at "+h.hospitalAddress);
			}
		}
		if(b)
			System.out.println("No hospitals found with your required specifications");
	}
	
	public static void NearestHospitalByIllness(ArrayList<Hospital> al){
		System.out.println("\n\n**********Enter your illness and zipcode to find the nearest hospital that can diagnose you*********\n");
		System.out.println("Enter zip:");
		Scanner s = new Scanner(System.in);
		int zip = s.nextInt(); int near=Integer.MAX_VALUE;
		System.out.println("Enter illness (Heart// Kidney// Brain)");
		String illness = s.next();
		Hospital hnear=null;
		for(Hospital h:al){
			
			if(h.doc.specialization.equalsIgnoreCase(illness)){
				if((Math.abs(zip-h.hospitalAddress.zipCode))<near){
					near=Math.abs(zip-h.hospitalAddress.zipCode);
					hnear=h;
				}
			}
		}
		System.out.println(hnear);
	}
	public static void NearestHospital(ArrayList<Hospital> al){
		System.out.println("\n*******Now Lets get the nearest hospital*******\n");
		System.out.println("Enter your zip code to get the nearest hospital");
		Scanner s = new Scanner(System.in);
		int zip = s.nextInt();
		int near=Integer.MAX_VALUE;
		Hospital hnear= new Hospital();
		if(Integer.toString(zip).length()!=5)
			System.out.println("Please enter 5 digits exactly");
		else{
		for(Hospital h:al){
			if((Math.abs(zip-h.hospitalAddress.zipCode))<near){
				near=Math.abs(zip-h.hospitalAddress.zipCode);
				hnear=h;
			}
		}
		System.out.println("***Nearest hospital is***********************");
		System.out.println(hnear);}
	}
	
	public static void DoctorDetailsbyHospitalName(HashMap<String,List<Hospital>> hm){
		System.out.println("*********Enter hospital name to get all the doctor details*******");
		Scanner s = new Scanner(System.in);
		String hname = s.nextLine();
		List<Hospital> aal=hm.get(hname);
		if(aal!=null)
		for(Hospital h: aal){
			System.out.println("Doctor details are: ");
			System.out.println("Doctor name: "+h.doc.name);
			System.out.println("Doctor Specialization: "+h.doc.specialization);
			System.out.println("Doctor id: "+h.doc.docId+"\n");
			
		}
	}
	
	public static ArrayList filterDupes(ArrayList<Hospital> al,HashMap<String,List<Hospital>> hm){
		Scanner s= new Scanner(System.in);
		System.out.println("Available hospitals with doctors are");
		for(Hospital h:al )
			System.out.println(h);
		
		System.out.println("Now try entering the same hospital name and adresses");
		System.out.println("Enter Hospital Name:");
		String name = s.nextLine();
		System.out.println("Enter Hospital Address:");
		System.out.println("Enter Hospital address1:");
		String address1=s.nextLine();
		System.out.println("Enter Hospital address2:");
		String address2=s.nextLine();
		System.out.println("Enter Hospital city:");
		String city=s.nextLine();
		System.out.println("Enter Hospital state:");
		String state = s.nextLine();
		System.out.println("Enter Hospital zip (only 5 numbers):");
		int zip = s.nextInt();
		Address a = new Address(address1, address2, city, state, zip);
		Doctor d = new Doctor();
		Hospital h = new Hospital(name, d, a);
		if(al.contains(h))
			System.out.println("Yes, the hospital is already present");
		else{
			System.out.println("No, we dont have that hospital on our list, Please also enter the doctor details");
			System.out.println("Enter Doctor id:");
			int id = s.nextInt();
			s.nextLine();
			System.out.println("Enter Doctor name");
			String dname= s.nextLine();
			System.out.println("Enter Doctors Specialization");
			String spec = s.nextLine();
			d =new Doctor(id, dname, spec);
			h = new Hospital(name, d, a);
			for(Map.Entry m:hm.entrySet()){
				if(name.equalsIgnoreCase((String) m.getKey())){
					ArrayList<Hospital> hahaha =(ArrayList<Hospital>) m.getValue(); 
					hahaha.add(h);
					hm.put(h.hospitalName,hahaha);
				}
			}
			al.add(h);			
			
			/*System.out.println("Now the list of hospitals are");
			for(Hospital k:al)
				System.out.println(k);*/
		}
		
		return al;	}

}


class Hospital {
    String hospitalName;
    Doctor doc;
    Address hospitalAddress;
	
	public Hospital(String hospitalName, Doctor doc, Address hospitalAddress) {
		super();
		this.hospitalName = hospitalName;
		this.doc = doc;
		this.hospitalAddress = hospitalAddress;
	}

	public Hospital() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Hospital [hospitalName=" + hospitalName + ", doc=" + doc + ", hospitalAddress=" + hospitalAddress + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hospitalAddress == null) ? 0 : hospitalAddress.hashCode());
		result = prime * result + ((hospitalName == null) ? 0 : hospitalName.hashCode());
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
		Hospital other = (Hospital) obj;
		if (hospitalAddress == null) {
			if (other.hospitalAddress != null)
				return false;
		} else if (!hospitalAddress.equals(other.hospitalAddress))
			return false;
		if (hospitalName == null) {
			if (other.hospitalName != null)
				return false;
		} else if (!hospitalName.equals(other.hospitalName))
			return false;
		return true;
	}

	
}
class Doctor {
   int docId;
   String name;
   String specialization;
   public Doctor(){
	   
   }
   
   public Doctor(int docId, String name, String specialization) {
	super();
	this.docId = docId;
	this.name = name;
	this.specialization = specialization;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + docId;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((specialization == null) ? 0 : specialization.hashCode());
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
	Doctor other = (Doctor) obj;
	if (docId != other.docId)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (specialization == null) {
		if (other.specialization != null)
			return false;
	} else if (!specialization.equals(other.specialization))
		return false;
	return true;
}
@Override
public String toString() {
	return "Doctor [docId=" + docId + ", name=" + name + ", specialization=" + specialization + "]";
}
   
}
class Address {
   String address1;
   String address2;
   String city;
   String state;
   int zipCode;
   public Address(String address1, String address2, String city, String state, int zipCode) {
	super();
	this.address1 = address1;
	this.address2 = address2;
	this.city = city;
	this.state = state;
	this.zipCode = zipCode;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((address1 == null) ? 0 : address1.hashCode());
	result = prime * result + ((address2 == null) ? 0 : address2.hashCode());
	result = prime * result + ((city == null) ? 0 : city.hashCode());
	result = prime * result + ((state == null) ? 0 : state.hashCode());
	result = prime * result + zipCode;
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
	Address other = (Address) obj;
	if (address1 == null) {
		if (other.address1 != null)
			return false;
	} else if (!address1.equals(other.address1))
		return false;
	if (address2 == null) {
		if (other.address2 != null)
			return false;
	} else if (!address2.equals(other.address2))
		return false;
	if (city == null) {
		if (other.city != null)
			return false;
	} else if (!city.equals(other.city))
		return false;
	if (state == null) {
		if (other.state != null)
			return false;
	} else if (!state.equals(other.state))
		return false;
	if (zipCode != other.zipCode)
		return false;
	return true;
}
@Override
public String toString() {
	return "Address [address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", state=" + state
			+ ", zipCode=" + zipCode + "]";
}

}