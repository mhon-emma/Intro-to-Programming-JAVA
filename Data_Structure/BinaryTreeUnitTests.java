/*-----------------------------------------------------------------------------
author: <Manyung Hon>
------------------------------------------------------------------------------*/

public class BinaryTreeUnitTests {

  public static void main(String[] args) {
    // TODO: write tests here
   
      System.out.println("Test passing: " + test1());

  }
  static public boolean test1()
  {
    BinaryTree testing = new BinaryTree();
    int[] profile = new int[1];

    if(testing.search("hi",profile)!= -1)
    {return false;}
    
    testing.insert("hi",15);  
    testing.insert("yo",2); 
    testing.insert("what",6);
    if(testing.search("yo",profile) != 2)
    {return false;}
    if(testing.search("what",profile) !=6)
    {return false;}
    if(testing.search("",profile)!=-1)
    {return false;}
    testing.insert("what",9);
    if(testing.search("what",profile) !=9)
    {return false;}


   return true;
  }
}
