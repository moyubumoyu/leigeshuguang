public class a {
	public static void main (String[] args){
		int data[]=new int[3];
	    data[0]=10;
		data[1]=20;
		data[2]=30;
		TicketWindow tw=new TicketWindow();
		new Thread(tw,"day1").start();
		new Thread(tw,"day2").start();
		new Thread(tw,"day3").start();
		
	}
}
class TicketWindow implements Runnable{
    
	private int person=2;
	public void run(){
		while(true){
			if(person>=0){
				Thread th=Thread.currentThread();
				String th_name=th.getName();
				System.out.println(th_name+" нд╪Ч"+person--);
			}
			
		}
	}
}