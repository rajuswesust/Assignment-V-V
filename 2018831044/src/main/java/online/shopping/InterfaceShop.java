package online.shopping;

public interface InterfaceShop {
    String addAdmin(InterfaceAdmin admin, int adminId);
    String removeAdmin(InterfaceAdmin admin, int adminId);
    String addCustomer(InterfaceCustomer customer, int adminId);

    String addCarts(InterfaceCart cart, int customerId);
    String removeCustomer(InterfaceCustomer customer, int adminId);
    String modifyProduct(Product product,int adminId);
    String addProduct(Product product, int adminId);
    String removeProduct(Product product,int adminId);

    String makeShipments( int adminId);
    String confirmDelivery( int adminId);
}

