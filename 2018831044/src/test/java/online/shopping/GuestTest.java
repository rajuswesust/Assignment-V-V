package online.shopping;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuestTest {
    static Shop shop;
    static Guest guest;
    static Admin admin;
    static Product product1;
    static Product product2;
    static Product product3;


    @BeforeAll
    static void init(){
        shop = Shop.getInstance();
        guest = new Guest();
        admin = new Admin("Admin");
        shop.addAdmin(admin, 1234);
        product1 = new Product("Alu", 20);
        product2 = new Product("Begun", 30);
        product3 = new Product("Chichinga", 40);
        shop.addProduct(product1, admin.getId());
        shop.addProduct(product2, admin.getId());
        shop.addProduct(product3, admin.getId());


    }


    @Test
    void viewProducts() {
        assertTrue(3<= guest.viewProducts().size());
        assertInstanceOf(Product.class, guest.viewProducts().get(0));
    }

    @Test
    void getRegistered() {
        assertEquals("Success", guest.getRegistered( "Guest", admin.getId()));
    }
}