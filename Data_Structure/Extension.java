/*-----------------------------------------------------------------------------
author: <Manyung Hon>
------------------------------------------------------------------------------*/

public class Extension {

  public static void main(String[] args) {
    Person[] people = PersonLoader.loadPeople();
    // TODO: write extension code here
    HashTable HashFirst = new HashTable(10000);
    HashTable HashSecond = new HashTable(20000);
    HashTable HashThird = new HashTable(100000);
    HashTable HashFinal = new HashTable(100003);

    BinaryTree tree = new BinaryTree();
   
    for(int i = 0; i<people.length; i++)
    {
      HashFirst.insert(people[i].getName(), people[i].getAge());
      HashSecond.insert(people[i].getName(), people[i].getAge());
      HashThird.insert(people[i].getName(), people[i].getAge());
      HashFinal.insert(people[i].getName(), people[i].getAge());
      tree.insert(people[i].getName(), people[i].getAge());

      System.out.println(i + ":" + people[i].getName());
    }
    
    
    int[] profile = new int[1];

    tree.search("GERALD WORKMAN",profile);
    System.out.println("Tree GERALD WORKMAN: "+profile[0]);
    
    profile[0] = 0;
    HashFirst.search("GERALD WORKMAN",profile);
    System.out.println("1000 Hash GERALD WORKMAN: "+profile[0]);
    
    profile[0] = 0;
    HashSecond.search("JOHN HOLLAND",profile);
    System.out.println("20000 Hash GERALD WORKMAN: "+profile[0]);
    
    profile[0] = 0;
    HashThird.search("JOHN HOLLAND",profile);
    System.out.println("100000 Hash GERALD WORKMAN: "+profile[0]);
    
    profile[0] = 0;
    HashFinal.search("JOHN HOLLAND",profile);
    System.out.println("100003 Hash GERALD WORKMAN: "+profile[0]);
    
    profile[0]= 0;
    tree.search("JAMES TAYLOR",profile);
    System.out.println("Tree JAMES TAYLOR: "+profile[0]);
    
    profile[0] = 0;
    HashFirst.search("JAMES TAYLOR",profile);
    System.out.println("1000 Hash JAMES TAYLOR: "+profile[0]);
    
    profile[0] = 0;
    HashSecond.search("JOHN HOLLAND",profile);
    System.out.println("20000 Hash JAMES TAYLOR: "+profile[0]);
    
    profile[0] = 0;
    HashThird.search("JOHN HOLLAND",profile);
    System.out.println("100000 Hash JAMES TAYLOR: "+profile[0]);
    
    profile[0] = 0;
    HashFinal.search("JOHN HOLLAND",profile);
    System.out.println("1000003 Hash JAMES TAYLOR: "+profile[0]);
    
    profile[0]= 0;
    tree.search("JOHN HOLLAND",profile);
    System.out.println("Tree JOHN HOLLAND: "+profile[0]);
    
    profile[0] = 0;
    HashFirst.search("JOHN HOLLAND",profile);
    System.out.println("1000 Hash JOHN HOLLAND: "+profile[0]);
    
    profile[0] = 0;
    HashSecond.search("JOHN HOLLAND",profile);
    System.out.println("20000 Hash JOHN HOLLAND: "+profile[0]);
    
    profile[0] = 0;
    HashThird.search("JOHN HOLLAND",profile);
    System.out.println("100000 Hash JOHN HOLLAND: "+profile[0]);
    
    profile[0] = 0;
    HashFinal.search("JOHN HOLLAND",profile);
    System.out.println("100003 Hash JOHN HOLLAND: "+profile[0]);
}
}
