// This is a helper class students can use to associate products and quantities
// in their cart.  Ideally a shopping cart is a set of cartitems rather than a
// set of products (a set of products would make it nearly impossible to track quantity).
public class CartItem {
  private final Product product;
  private CartItem next;

  public CartItem(Product product) {
    this.product = product;
    this.next = null;
  }

  public Product getProduct() {
    return product;
  }

  public CartItem getNext() {
    return next;
  }

  public void setNext(CartItem next) {
    this.next = next;
  }
}
