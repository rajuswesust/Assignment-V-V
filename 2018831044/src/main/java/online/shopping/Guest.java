package online.shopping;

import java.util.List;

public class Guest {




    public List<Product> viewProducts(){
        return Shop.getInstance().getProducts();
    }
    public String getRegistered(String name,int adminId ){

        return Shop.getInstance().addCustomer(new Customer(name),adminId);

    }
}
