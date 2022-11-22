package online.shopping;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminTest {

    static Shop shop;
    static Admin admin;
    static Admin admin2;
    static Product product1;
    static Product product2;
    static Product product3;

    @BeforeAll
    static void init(){
        shop = Shop.getInstance();
        admin = new Admin("Admin");
        admin2 = new Admin("Admin2");
        shop.addAdmin(admin, 1234);
        shop.addAdmin(admin2, admin.getId());
        product1 = new Product("Alu", 20);
        product2 = new Product("Begun", 30);
        product3 = new Product("Chichinga", 40);
    }



    @Test
    @Order(1)
    void getName() {
        assertEquals("Admin",admin.getName());
        assertInstanceOf(String.class,admin.getName());
    }

    @Test
    @Order(2)
    void setName() {
        admin.setName("raju");
        assertEquals("raju",admin.getName());
    }

    @Test
    @Order(3)
    void addProduct() {
        assertEquals("Success",admin.addProduct(product1));
        assertEquals("Success",admin.addProduct(product2));
        assertEquals("Success",admin.addProduct(product3));
    }

    @Test
    @Order(5)
    void removeProduct() {
        assertEquals("Success",admin.removeProduct(product1));
        assertEquals("Success",admin.removeProduct(product2));
        assertEquals("Success",admin.removeProduct(product3));
    }

    @Test
    @Order(4)
    void modifyProduct() {
        assertEquals("Success",admin.modifyProduct(product1));
        assertEquals("Success",admin.modifyProduct(product2));
        assertEquals("Success",admin.modifyProduct(product3));
    }

    @Test
    @Order(6)
    void makeShipments() {
        assertEquals("Success",admin.makeShipments());
    }

    @Test
    @Order(7)
    void confirmDelivery() {
        assertEquals("Success",admin.confirmDelivery());
    }
}