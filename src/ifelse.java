
public class ifelse {
    public static void main(String[] args) {
    	int[] arr= {1,2,4,6,7,90,120};
    	
    	//check if this array has any multiple of 2
    	for(int i=0; i<arr.length; i++) {
    		if(arr[i] %2==0) {
    			System.out.println(arr[i]);
    		}
    		else{
    			System.out.println(arr[i]  +"is not multiple of 2");
    		}
    	}
    }
}
