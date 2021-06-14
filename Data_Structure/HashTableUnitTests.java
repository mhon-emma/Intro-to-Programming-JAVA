/*-----------------------------------------------------------------------------
author: <Manyung Hon>
------------------------------------------------------------------------------*/

public class HashTableUnitTests {

  public static void main(String[] args) {
    // TODO: write tests here

    System.out.println("All test passed: "+ testing1());
    
  }
  static public boolean testing1()
  {
    HashTable testing = new HashTable(5);
    int[] profile = new int[1];
    if(testing.search("hi",profile)!=-1)
    {return false;}
    testing.insert("hi",2);
    if(testing.search("hi",profile)!= 2)
    {return false;}
    testing.insert("",3);
    testing.insert("what",2);
    testing.insert("yo",5);

    if(testing.search("",profile)!= -1)
    {return false;}
    if(testing.search("not there",profile)!= -1)
    {return false;}

    
    if(testing.search("yo",profile)!=5)
    {return false;}
    if(testing.search("what",profile)!=2)
    {return false;}
    testing.insert("test3",8);
    testing.insert("test4",20);
    testing.insert("test5",82);
    testing.insert("test6",2934);
    if(testing.search("test6",profile) == -1)
    {return false;}
    return true;
  }
  
}
