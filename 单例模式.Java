public class ChocolateFactory{
  private boolean empty;
  private boolean boiled;
  public static ChocolateFactory uniqueInstance=null;
  private ChocolateFactory()
  {
    empty=ture;
    boiled=flase;
  }
  public static ChocolateFactory getInstance()
  {
    if (uniqueInstance==null)
    {
      uniqueInstance=new ChocolateFactory();
    }
    return uniqueInstance;
  }
  public void fill()
  {
    if(empty)
    {
    empty=false;
    boiled=false;
    }
  }
  public void drain()
  {
    if((!empty)&&boiled)
    {
      empty=true;
    }
    }
  public void boil ()
  {
    if((!empty)&&boiled)
    {
      boiled=true;
    }
  }
}

