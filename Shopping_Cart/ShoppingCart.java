public class ShoppingCart {

  private CartItem listHead = null;
  private CartItem rear = null;
  public boolean addProduct(Product product, int quantity) {
  if(quantity >0)
  {
    if(check(product) != true)
    {
      
      if(listHead == null)
      {
         listHead = new CartItem(product);
         listHead.getProduct().setQuantity(quantity);
         listHead.setNext(rear);
         return true;
         //if the list is emptym, then add the item right away
      }
      if(listHead !=null)
      {
         CartItem next = new CartItem(product);
         CartItem compare = listHead;
         //if the list is not empty
	      while ((compare != null)) 
         {
            if( compare.getProduct().getName() == product.getName())
            {
               int sum = product.getQuantity() + quantity;
               compare.getProduct().setQuantity(sum);
               return true;
               //if the item exist in the the list, add the quantity to the existed amount
            }
            else if(compare.getNext() == null)
            {
               next.getProduct().setQuantity(quantity);
               compare.setNext(next);
               return true;
               //if the item does not exist int he lsit, add the quantity and item to the end of the list
            }
            else
            {
               compare = compare.getNext();
               //in other case when we have not reach the end of the list and have not find existing item matches, keep moving
            }
            
        }
     }
   }
   
  }
     return false;
  }

  public boolean removeProduct(Product product) 
  {
    
       if(listHead == null)
       {
         return false;
       }
       CartItem listPtr = listHead;
	    CartItem listPtr2 = listPtr;
	    while ( (listPtr != null) && ( listPtr.getProduct().getName() != product.getName())) 
       {
	         listPtr2 = listPtr;
	         listPtr = listPtr.getNext();
	    }
        // If it's not there, return and keep moving to the next item.
	    if (listPtr == null) 
       {
	         return false;
	    }
	   // Otherwise delete: four cases.
       if (listHead == listPtr) 
       {
            // Case 1: only one element.
            listHead = rear = null;
       }
	    else if(listHead == listPtr)
	    {
            //case 2: when the element is the first item
		      listHead = listPtr.getNext();
	    }
	    else if(listPtr == rear)
	    {
            //case 3: when the element is at the end
		      rear = null;
	    }
	    else 
	    { 
            //case 4: if the element is in the middle. 
		      listPtr2.setNext(listPtr.getNext());
	    }
    
    
    return true;
  }

  public double checkout() 
  {
    double sum = 0.0;

    if(listHead == null)
    {
      return 0.0;
      //if there is no item, return 0
    }
    if(listHead != null)
    {
      CartItem count = listHead;
      while(count != rear)
      {
        if(count.getProduct().getDiscount() == 0)
        {
            sum = sum + ((count.getProduct().getPrice())*(count.getProduct().getQuantity())) ;
            count = count.getNext();
            //if there is no discount, multiply the original price by the quantity
        }
        else if(count.getProduct().getDiscount() > 0)
        {
            sum = sum + ((count.getProduct().getDiscount())*(count.getProduct().getQuantity()));
            count = count.getNext();
            //if there is a discount, multiply the discounted price by the quantity
        }
      }
      return sum;
    }
    return 0.0;
  }

  public void clear() 
  {
      listHead.setNext(rear);
      listHead = null;
      //reference the front to the end, then make the front null
  }

  public boolean isEmpty() 
  {
    CartItem check = listHead;
    while( check != rear)
    {
      if(check!=null)
      {
         return false;
      }
      check = check.getNext();
    }
    return true;
    //check if the first item is not null
    //then see if the check everything else using a while loop 
  }
  public boolean check(Product product)
  {
   
      if(listHead == null)//sanity check
      {
        return false;
      }
      CartItem listPtr = listHead;
      while(listPtr != null)
      {
         if(listPtr.getProduct().getName() == product.getName())
         {
            return true;
            //find the item
         }
         listPtr = listPtr.getNext();
      }
      return false;
     //can't find the item
  }
    
  public String toString()
  {
      if(listHead == null)
      {
         return "empty";
      }
      String s = "[";
      CartItem listPtr = listHead;
      while(listPtr != null)
      {
         s += "\"" + listPtr.getProduct().getName() + "\"";
         listPtr = listPtr.getNext();
      }
      //to make ShoppingCart a string
      return s + "]";
  }
  public boolean applyDiscount(Product product, double discount)
  {   
      if(discount >0 && discount <= 1)
      {
         product.setDiscount(product.getPrice() *(1-discount));
         return true;
         //directly decrease the price for each product by percentage
      }
      return false;
  }   
}
