package online.shopping;

import java.util.List;

public interface InterfaceCustomer {
    void setCart(InterfaceCart cart);

    int getId();

    float buyProduct();
    float addProduct(Product product);
    float removeProduct(Product product);
    List<Product> viewProducts();
    float makePayment( InterfacePayment payment);
}
