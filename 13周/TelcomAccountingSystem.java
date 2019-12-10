//import rate.*;
import telcomUser.TelcomUserBasedOnCollection;
//import company.*;


public class TelcomAccountingSystem {

	public static void main(String[] args) {
	
		TelcomUserBasedOnCollection telcomUser = new TelcomUserBasedOnCollection("13800138000");
	
		
		telcomUser.generateCommunicateRecord();
		
		telcomUser.printDetails();
		
	}

}