public class ShoppingCartUnitTests {
 static Product single = null;
 static Product[] multiple = null;
 static ShoppingCart test = new ShoppingCart();
  public static void main(String[] args) 
  {
     single  = InventoryHelper.getSingleProduct();
     //check if the methods work for one item only first
     if(single(test, single))
     {System.out.println("test for Single succeeded");} 
     else 
     {System.out.println("test for Single failed");}
     
     //then check if the method works for multiple items
     multiple = InventoryHelper.getMultipleProducts();
     if(multi(test,multiple)== true)
     {System.out.println("test for Multiple succeeded");} 
     else 
     {System.out.println("test for Multiple failed");}   
     
     //discount the products and test it on one item only
     if(discount(test,single)== true)
     {System.out.println("test for single unit Discount succeeded");} 
     else 
     {System.out.println("test for single unit Discount failed");}
     //clear the ShoppingCart before testing it for multiple units
     test.clear();
     if(discount(test,multiple) == true)
     {System.out.println("test for multiple units Discount succeeded");} 
     else 
     {System.out.println("test for multiple units Discount failed");}     
     
     
      
  }
  public static boolean add(ShoppingCart test,Product product)
  {
      if(test.check(product) == true)
      {
         return true;
      }
      return false;
      //check if the item is in the cart
  }
  
  
   public static boolean single(ShoppingCart test,Product product)
  {
      //adding
      test.addProduct(product,1);
      if(add(test,product)== false && test.checkout() != product.getPrice())
      {return false;}
      if(test == null)
      {return false;}
      //removing
      test.removeProduct(product);
      if(test.check(product) == false && test.checkout() != 0)
      {return false;}
      
      if(test.isEmpty() != true)
      {return false;}
       //extension for quantity
      if(test.addProduct(product,-1) ==true)
      {return false;}
      
      test.addProduct(product,3);
      if(test.checkout() != (product.getPrice()) * (product.getQuantity()))
      {return false;}
      test.clear();
      return true;
  }
  public static boolean multi(ShoppingCart test,Product[] product)
  {
      //adding
      double count = 0;
      for(int i = 0; i <product.length; i++)
      {test.addProduct(product[i],1);}
      for(int i = 0; i<product.length; i++)
      {
         if(add(test,product[i]) == false)
         {
            return false;
         }
         count = count + product[i].getPrice();
      }
      if(test == null)
      {return false;}

      
      
      if(test.checkout() != count)
      {return false;}
      

      //removing
      for(int i = 0; i <multiple.length; i++)
      {
         test.removeProduct(product[i]);
         if(test.check(product[i]) == true)
         {
            return false;
         }
      }
      if(test.checkout()!= 0 && test.isEmpty() != true)
      {return false;}
            
      for(int i = 0; i <product.length; i++)
      {test.addProduct(product[i],1);}
      //System.out.println(test);
      test.clear();
      if(test.isEmpty()!=true)
      {return false;}

      
     
      //clear then test the quantity for multiple units
      double sum = 0.0;
      for(int i = 0; i<product.length; i++)
      {
         test.addProduct(product[i],3);
         sum = sum + (product[i].getPrice()* product[i].getQuantity());
      }
      if(test.checkout() != sum)
      {return false;}
      test.clear();
      return true;
  }
  public static boolean discount(ShoppingCart test,Product product)
  {
      double discount = 0.0;
      
      
      test.addProduct(product,3);
      test.applyDiscount(product,0.5);
      discount = discount + (product.getDiscount()* product.getQuantity());
      if(discount != test.checkout())
      {return false;}
   return true;
  } 
  
  public static boolean discount(ShoppingCart test,Product[] product)
  {
      double discount = 0.0;
      
      for(int i = 0; i<product.length; i++)
      {
         test.addProduct(product[i],3);
         test.applyDiscount(product[i],0.5);
         discount = discount + (product[i].getDiscount()* product[i].getQuantity());
      }
       
      if(discount != test.checkout())
      {return false;}
   return true;
  }

}
  
  
