package price;

import move.Movie2;

public class NewReleasePrice extends Price {
  public int getPriceCode() {
	  return Movie2.NEW_RELEASE;
  }
  public double getCharge(int daysRented) {
	  return daysRented*3;
  }
  public int getFrequentRenterPoints(int daysRented) {
	  return(daysRented>1) ?2:1;
  }
}
