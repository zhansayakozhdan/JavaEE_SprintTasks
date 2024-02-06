package models;

public class Footballer {
    private Integer id;
    private String name;
    private String surname;
    private Integer salary;
    private String club;
    private Integer transferPrice;

    public Footballer(){

    }

    public Footballer(Integer id, String name, String surname, Integer salary, String club, Integer transferPrice) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.club = club;
        this.transferPrice = transferPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public Integer getTransferPrice() {
        return transferPrice;
    }

    public void setTransferPrice(Integer transferPrice) {
        this.transferPrice = transferPrice;
    }
}
