public class a {
	public static void main(String[] args){
		BB bb=new BB();
		bb.start();
		while(true){
			System.out.println("this is a");
		}
	}
}
class BB extends Thread{
	public void run(){
		while(true){
			System.out.println("this is b");
		}
	}
}
