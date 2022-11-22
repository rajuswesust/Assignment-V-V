package online.shopping.mockito;

import online.shopping.*;
import org.junit.jupiter.api.*;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerTest {
   static Customer customer;
    static Shop shop;
    static Product product1;
    static Product product2;
    static Product product3;

    static InterfacePayment payment;

   @BeforeAll
   static  void setCustomer(){
       //Mockito

       payment= Mockito.mock(InterfacePayment.class);


       Admin admin = new Admin("Sourav");

        customer= new Customer("Sourav");
        shop = Shop.getInstance();
        product1 = new Product("Alu", 20);
        product2 = new Product("Begun", 30);
        product3 = new Product("Chichinga", 30);
        shop.addAdmin(admin, 1234);
        shop.addProduct(product1,admin.getId());
        shop.addProduct(product2,admin.getId());
        shop.addProduct(product3,admin.getId());

        customer.addProduct(product1);
        customer.addProduct(product2);
       System.out.println( customer.addProduct(product3));
       System.out.println(customer.getCart().getProducts().size());

    }

    @Test
    @Order(1)
    void test1TotalProduct(){
        assertEquals(3, customer.getCart().getProducts().size());
    }
    @Test
    @Order(2)
    void test2Total(){
        assertEquals(80, customer.buyProduct());
    }



    @Test
    @Order(3)
    void test3RemoveProduct(){

        assertEquals(60, customer.removeProduct(product1));
    }


    @Test
    @Order(4)
    void test4AddProduct(){
        Product product4 = new Product("Chichinga", 30);
        customer.addProduct(product4);
        assertEquals(3, customer.getCart().getProducts().size());
    }

    @Test
    @Order(5)
    void test5ViewProduct(){
        assertEquals(6, customer.viewProducts().size());
    }




    @Test
    @Order(6)
    void  test6SetId() {
        customer.setId(12341, 1234);
        assertEquals(12341, customer.getId());
    }
    @Test
    @Order(7)
    void test7getId() {
        assertEquals(12341, customer.getId());

    }

    @Test
    @Order(8)
    void test8getName() {
       assertEquals("Sourav", customer.getName());
    }

    @Test
    @Order(9)
    void test9setName() {
        customer.setName("AHB");
       assertEquals("AHB",customer.getName());

    }

    @Test
    @Order(10)
    void test10getAddress() {
       assertEquals("N.A", customer.getAddress());
    }

    @Test
    @Order(11)
    void test11setAddress() {
        customer.setAddress("Dhaka");
        assertEquals("Dhaka", customer.getAddress());
    }

    @Test
    @Order(12)
    void test12getPhone() {
       assertNull(customer.getPhone());
    }

    @Test
    @Order(13)
    void test13setPhone() {
        customer.setPhone("017");
        assertEquals("017", customer.getPhone());
    }

    @Test
    @Order(14)
    void test14getCart() {
       assertNotNull(customer.getCart());
    }

//    @Test
//    void test16setCart() {
//        Cart cart = new Cart(customer.getId());
//        customer.setCart(cart);
//        assertEquals(cart, customer.getCart());
//    }

    @Test
    void test17getPayment() {
        Mockito.doReturn(100.0f).when(payment).payment(ArgumentMatchers.any(Float.class));
        Mockito.doReturn(90.0f).when(payment).offers(ArgumentMatchers.any(Float.class), ArgumentMatchers.any(Float.class));
        assertEquals(100.0f, customer.makePayment(payment));
        assertEquals(90.0f, customer.offers(payment));
    }


}