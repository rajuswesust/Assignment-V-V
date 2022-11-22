package online.shopping;

public class Main {
    public static void main(String[] args) {
        Shop shop =  Shop.getInstance();
        Customer newCus= new Customer("raju");
        System.out.println(shop.getAdmins());

    }
}