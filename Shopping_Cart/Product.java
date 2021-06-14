/*-----------------------------------------------------------------------------
author: <Manyung Hon>
------------------------------------------------------------------------------*/

public class Product {
  private final String name;
  private final double price;
  private int quantity;
  private double discount;
  
  public Product(String name, double price) {
    this.name = name;
    this.price = price;
  }
  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }
  public void setQuantity(int number){
    quantity = number;
  }
  public int getQuantity(){
    return quantity;
  }
  public void setDiscount(double number)
  {
    discount = number;
  }
  public double getDiscount()
  {
    return discount;
  }
  
}
