package price;

import move.Movie2;

public class RegularPrice extends Price{
  public int getPriceCode() {
	  return Movie2.REGULAR;
  }
  public double getCharge(int daysRented) {
	  double result=2;
	  if(daysRented>2)
			 result +=(daysRented -2)*1.5;
	  return result;
  }
}
