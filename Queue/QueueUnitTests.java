/*-----------------------------------------------------------------------------
author: <Manyung Hon>
------------------------------------------------------------------------------*/

public class QueueUnitTests {
static public Queue newtest = new Queue(5);
  public static void main(String[] args) {
    //TODO: Add code here
    System.out.println("test1 returns " + test1());
  }

  static public boolean test1()
  {
  if(newtest.isEmpty() != true)
   {return false;}
  newtest.enqueue("adam");
   if(newtest.tail.getName()!= "adam")
   {return false;}
   newtest.enqueue("John");
   newtest.enqueue("Sansa");
   newtest.enqueue("Arya");
   newtest.enqueue("Sam");
   if(newtest.enqueue("") == true)
   {return false;}
   if(newtest.enqueue("one more" ) == true)
   {return false;}
   if(newtest.tail.getName()!= "Sam")
   {return false;}
   if(newtest.isFull()!= true)
   {return false;}
   if(newtest.dequeue() != "adam")
   {return false;}
   newtest.dequeue();
   newtest.dequeue();
   newtest.dequeue();
   newtest.dequeue();
   if(newtest.isEmpty() != true)
   {return false;}
   if(newtest.dequeue() != "")
   {return false;}


    return true; 
  }
}
