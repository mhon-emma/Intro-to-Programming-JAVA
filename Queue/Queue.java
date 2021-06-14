/*-----------------------------------------------------------------------------
author: <Manyung Hon>
------------------------------------------------------------------------------*/

public class Queue{

  private int maxCapacity;
  public Node head;
  public Node tail;
  int counter = 0;
  
  public Queue(int maxCapacity){
     //TODO: Add code here
     this.maxCapacity  =  maxCapacity;
   
  }

  public boolean enqueue(String name){
    //TODO: Add code here
    Node newnode = new Node(name);
    if(head == null)
    {
      head = newnode;
      tail = head;
      counter++;
      return true;
    }
    else if(counter != maxCapacity && name != "")
    {
      
         tail.setNext(newnode);
         tail = tail.getNext();
         counter++;
         return true;
    }
   
    return false;
  }

  public String dequeue(){
    //TODO: Add code here
    String temp = "";
    if(head != null)
    {
         temp = head.getName();
         head = head.getNext();
         counter --; 
    }
    
    return temp;
  }

  public boolean isEmpty(){
    //TODO: Add code here
    if(head== null)
    {
      return true;
    }
    return false;
  }

  public boolean isFull(){
    //TODO: Add code here
    if(counter == maxCapacity)
    {return true;}
    return false;
  }
}
