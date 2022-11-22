package online.shopping;

public class Product {
    private int id;
    private String name;
    private int price;

    private String group;
    private String subGroup;

private Shop shop=Shop.getInstance();


    public Product(String name, int price) {
        this.id= (int) (Math.random()*1000);
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

        for (Product product:shop.getProducts()) {
            if(product.getId()==id){
                System.out.println("Product with this id exists");
                return;
            }
        }

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSubGroup() {
        return subGroup;
    }

    public void setSubGroup(String subGroup) {
        this.subGroup = subGroup;
    }
}
