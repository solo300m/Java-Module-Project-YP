public class Product {
    private String name = "";
    private double price = 0.0;
    Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Добавленный товар: " + name + ", Цена: " + price ;
    }
}
