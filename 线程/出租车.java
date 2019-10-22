public class a {
	public static void main (String[] args){
		TicketWindow tw=new TicketWindow();
		new Thread(tw,"car1").start();
		new Thread(tw,"car2").start();
		new Thread(tw,"car3").start();
		new Thread(tw,"car4").start();
		new Thread(tw,"car5").start();
	}
}
class TicketWindow implements Runnable{
	private int person=100;
	
	public void run(){
		while(true){
			if(person>0){
				Thread th=Thread.currentThread();
				String th_name=th.getName();
				System.out.println(th_name+" ³Ë¿Í"+person--);
			}
			
		}
	}
}