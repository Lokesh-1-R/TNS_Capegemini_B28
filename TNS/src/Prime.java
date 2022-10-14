
public class Prime {

	
	    public static void main(String[] args) {
	        for (int i=0;i<100;i++) {
	            Prime(i);
	        }
	    }
	    public static void Prime(int number){
	        boolean is_prime = true;
	        for (int i=2;i<number/2;i++){
	            if(number %i==0 ){
	                is_prime = false;

	            }
	        }
	        if(is_prime)
	            System.out.println(number +" is a prime");
	        else
	            System.out.println(number + " is not a prime");
	    }
	}
