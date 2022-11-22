package online.shopping;

public interface InterfaceAdmin {
    String addProduct(Product product);

    String removeProduct(Product product);

    String modifyProduct(Product product);

    String makeShipments();

    String confirmDelivery();

    int getId();

}
