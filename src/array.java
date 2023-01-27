import java.util.ArrayList;

public class array {
		public static void main(String[] args) {
			int [] arr= new int[5];
			arr[0]= 1;

			int[] arr2 = {1,2,3,4,5,6};
			
			//for loop
			
		for(int i=0; i<arr.length;i++) {
			System.out.println(arr2[i]);
		}
		
		String [] name= {"Firstname","LastName"};
		for(int i=0; i<name.length;i++) {
			System.out.println(name[i]);
		}
		
		//Enhanced for loop declaration
		for(String s:name) {
				System.out.println(s);
		}
		
		for(int k:arr2) {
			System.out.println(k);
		}
		
		//Creating an arraylist for dynamic increment of array element
		ArrayList<String> a = new ArrayList<String>();
		a.add("Firstname");
		a.add("Lastname");
		a.add("Middlename");
		//a.remove(2);
        
		//System.out.println(a.get(1));
		
		for(int i=0;i<a.size();i++) {
			System.out.println(a.get(i));
		}
}

}

