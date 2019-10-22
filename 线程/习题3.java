public class a {
	public static void main (String[] args){
		TicketWindow tw=new TicketWindow();
		new Thread(tw,"teacher1").start();
		new Thread(tw,"teacher2").start();
		new Thread(tw,"teacher3").start();
	}
}
class TicketWindow implements Runnable{
	private int zuoye=80;
	
	public void run(){
		while(true){
			if(zuoye>0){
				Thread th=Thread.currentThread();
				String th_name=th.getName();
				System.out.println(th_name+" ื๗าต"+zuoye--);
			}
			
		}
	}
}