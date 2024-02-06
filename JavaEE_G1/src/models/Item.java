package models;

public class Item {
    private Long id;
    private String name;
    private double price;
    private Integer amount;

    public Item(Long id, String name, double price, Integer amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }


}
