/*-----------------------------------------------------------------------------
author: <Manyung Hon>
------------------------------------------------------------------------------*/

public class URLStack {

  private String[] data;
  private int maxSize = 4;

  public URLStack() {
    data = new String[maxSize];
    
  }

  public void push(String url) {
    // TODO: Add code here
    if(data[data.length-1]!=null)
    {
      data = doubled();
    }
      for(int i=0; i<data.length; i++)
      {
         if(data[i]==null)
         {
            data[i]=url;
            break;
         }
      }
    
    }

  public String pop() {
    // TODO: Add code here
    int compare = 0;
    for(int i=0; i<data.length; i++)
    {
      if(data[i]==null)
      {
         compare = i-1;
         break;
      }
      else if(i == maxSize-1 && data[i]!= null)
      {
         compare = i;
         break;
      }
    }
    if(compare ==-1)
    {return "";}
    data[compare] = null;
    
    return data.toString();
  }

  public String peek() {
    // TODO: Add code here
    int compare = -1;
    for(int i=0; i<data.length; i++)
    {
      if(data[i]==null)
      {
         compare = i-1;
         break;
      }
      else if(i == data.length-1 && data[i]!= null)
      {
         compare = i;
         break;
      }
    }
    if(compare  == -1)
    {return "";}
    
    return data[compare];
  }

  public boolean isFull() {
    // TODO: Add code here
    for(int i=0; i<data.length; i++)
    {
      if(data[i]==null && i!= data.length-1)
      {
         return false;
      }
   }
    return true;
  
  }

  public boolean isEmpty() {
    // TODO: Add code here
    for(int i=0; i<data.length; i++)
    {
      if(data[i]!=null)
      {
         return false;
      }
    }
    return true;
  }
 public String[] doubled()
 {
   maxSize = maxSize*2;
   String[] doubled = new String[maxSize];
   for(int i = 0; i<data.length; i++)
   {
      doubled[i] = data[i];
   }
   data=doubled;
   return doubled;
 }
 public boolean contains(String url){
   for(int i=0; i<data.length;i++)
   {
      if(data[i] == url)
      {
         return true;
      }
   }
   return false;
  }
  public String toString()
  {
      String s = "";
      for(int i = 0; i<data.length; i++)
      {
         s = s + data[i];
      }
      return s;
  }

}

