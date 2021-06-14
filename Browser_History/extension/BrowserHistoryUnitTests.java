/*-----------------------------------------------------------------------------
author: <Manyung Hon>
------------------------------------------------------------------------------*/

public class BrowserHistoryUnitTests {
   static URLStack test = new URLStack();
   static BrowserHistory history = new BrowserHistory();
  public static void main(String[] args) {
    // TODO: Write tests here
   System.out.println("URL Stack test returns " + URLStack());
   System.out.println("BrowserHistory returns " + BrowserHistory());
  }
  static public boolean URLStack()
  {
      test.push("www.facebook.com");
      test.push("link2");
      test.push("link3");
      test.push("link4");
      test.push("link5");
      if(test.contains("link5")!=true)
      {return false;}
      if(test.isFull() == true)
      {return false;}
      test.pop();
      if(test.contains("link4")!=true)
      {return false;}
      if(test.peek() != "link4")
      {return false;}
      test.push("link6");
      if(test.isFull() == true)
      {return false;}
      test.pop();
      test.pop();
      test.pop();
      test.pop();
      test.pop();
      test.pop();
      if(test.isEmpty()!= true)
      {return false;}
      
      return true;
  }
  static public boolean BrowserHistory()
  {
      if(history.navigateToUrl(null) == true)
      {return false;}
      if(history.navigateToUrl("link1") != true)
      {return false;}
      history.navigateToUrl("link2");
      history.navigateToUrl("link3");
      history.navigateToUrl("link4");
      if(history.navigateToUrl("link5")==true)
      {return false;}
      history.back();
      history.back();

      if(history.forward.isFull() == true)
      {return false;}
      history.back();
      history.back();
      if(history.back() != "")
      {return false;}
      history.forward();
      history.forward();
      if(history.back.isFull()==true)
      {return false;}
      history.forward();
      history.forward();
      history.forward();
      if(history.forward()!= "")
      {return false;}
      return true;
  }

}
