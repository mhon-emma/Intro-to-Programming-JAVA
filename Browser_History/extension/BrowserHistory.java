/*-----------------------------------------------------------------------------
author: <Manyung Hon>
------------------------------------------------------------------------------*/

public class BrowserHistory {

URLStack forward = new URLStack();
URLStack back = new URLStack();
public URLStack right()
   {return forward;}
   public URLStack left()
   {return back;}

  public boolean navigateToUrl(String url){
    //TODO: Add code here
    if(url != null)
    {
      if(back.isFull() == false)
      {
          back.push(url);
      
          while( forward.isEmpty() == false)
          {
              forward.pop();
          }
          return true;
       }
    }
    return false;
  }

  public String back(){
    // TODO: Add code here
    
    if(forward.isFull() == false)
    {
    String temp = back.peek();
    back.pop();
    forward.push(temp);
    return back.peek();
    }
    return "";
  }

  public String forward() {
    // TODO: Add code here
    if(back.isFull() == false)
    {
      if(forward.isEmpty() == false)
      {
         String temp = forward.peek();
         forward.pop();
         back.push(temp);
         return back.peek();
      }
      else
      {
         back.peek();
      }
    }
    return "";
  }
}
