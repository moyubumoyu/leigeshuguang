public class a {
	public static void main (String[] args){
		TicketWindow tw=new TicketWindow();
		new Thread(tw,"a ").start();
		
	}
}
class TicketWindow implements Runnable{
	private int first=100;
	int second=50;
	public void run(){
		while(true){
			if(first>0){
				Thread th=Thread.currentThread();
				String th_name=th.getName();
				System.out.println(th_name+"main"+first--);
			}
			if(second>0){
				Thread th=Thread.currentThread();
				String th_name=th.getName();
				System.out.println(th_name+"new"+second--);
			}
		}
	}
}
