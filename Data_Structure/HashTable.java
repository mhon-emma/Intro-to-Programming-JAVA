/*-----------------------------------------------------------------------------
author: <Manyung Hon>
------------------------------------------------------------------------------*/

public class HashTable {

  private final ListNode[] buckets;
  private final int numBuckets;
  public HashTable(int numBuckets) {
    this.numBuckets = numBuckets;
    this.buckets = new ListNode[numBuckets];
  }

  public void insert(String key, int value) {
    // TODO: write this method
    
    if(key != "")
    {
      if(buckets[hash(key)] == null)
      {
         buckets[hash(key)] = new ListNode(key, value);
      }
      ListNode compare = null;
      compare = buckets[hash(key)];
      while(compare.getNext() != null)
      {
         compare = compare.getNext();
      }
      ListNode newnode = new ListNode(key,value);
      compare.setNext(newnode);
    }
  }

  public int search(String key, int[] profile) {
    // TODO: write this method
    int entry = hash(key);
    profile[0]++;
    if(buckets[entry] == null)
    {
      return -1;
    }
    
    ListNode compare = buckets[entry];
    if(key!= null)
    {
         while(compare.getKey() != key)
         {
            profile[0]++;
            if(compare.getNext() == null)
            {
               return -1;
            }
            compare = compare.getNext();
         } 
  }
    
    
        
    return compare.getValue();
  }


  private int hash(String key) {
    return Math.abs(key.hashCode()) % numBuckets;
  }
}
