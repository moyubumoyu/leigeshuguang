import customer.*;
import move.*;
import rental.*;
public class Chonggou {
	public static void main(String[] args) {
	    Customer8 customer = new Customer8("Àî»ª");
	    Rental4 rental =new Rental4(new Movie2("CHILDRENS",2),10);
	    customer.addRental(rental);
	    System.out.println(customer.statement());
	    
	}
}
