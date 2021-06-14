/*-----------------------------------------------------------------------------
author: <Manyung Hon>
------------------------------------------------------------------------------*/

public class InventoryHelper {

  public static Product getSingleProduct() {
    return new Product("Sunglasses", 49.99);
  }

  public static Product[] getMultipleProducts() {
    Product[] products = new Product[3];
    products[0] = new Product("Hat", 5.49);
    products[1] = new Product("Watch", 150.00);
    products[2] = new Product("Earrings", 19.99);
    return products;
  }
}
