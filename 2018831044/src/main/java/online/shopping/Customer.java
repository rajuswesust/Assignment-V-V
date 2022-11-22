package online.shopping;

import java.util.List;

public class Customer implements InterfaceCustomer {
    private int id;
    private String name;
    private String address;
    private String phone;
    private InterfaceCart currentCart;





    public Customer(String name) {
        this.id= (int) (Math.random()*1000);
        this.currentCart=new Cart(this.id);
        this.name = name;
        this.address="N.A";


    }
    public Customer(String name,String address,String phone) {
        this.id= (int) (Math.random()*1000);
        this.currentCart=new Cart(this.id);
        this.name = name;
        this.address=address;
        this.phone=phone;

    }
    public int getId() {
        return id;
    }

    public void setId(int id,int adminId) {

        this.id = id;
        currentCart.setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public InterfaceCart getCart() {
        return currentCart;
    }
    public void setCart(InterfaceCart cart) {
        this.currentCart = cart;
    }


    @Override
    public float buyProduct() {

        return currentCart.checkout();
    }

    @Override
    public float addProduct(Product product) {
        currentCart.addProduct(product);
        return currentCart.checkout();
    }

    @Override
    public float removeProduct(Product product) {
        currentCart.removeProduct(product);
        return currentCart.checkout();
    }

    @Override
    public List<Product> viewProducts() {
        return Shop.getInstance().getProducts();
    }

    @Override
    public float makePayment(InterfacePayment payment) {
        return payment.payment(currentCart.checkout());
    }

    public float offers(InterfacePayment payment) {
        return payment.offers(currentCart.checkout(), 20.0F);


    }

}
