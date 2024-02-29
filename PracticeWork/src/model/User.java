package model;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String birthCountry;
    private Integer age;
    private String username;
    private String password;

    public User(){

    }

    public User(Long id, String firstName, String lastName, String birthCountry, Integer age, String username, String password, String rePassword) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthCountry = birthCountry;
        this.age = age;
        this.username = username;
        this.password = password;
    }

    public User(String firstName, String lastName, String birthCountry, Integer age, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthCountry = birthCountry;
        this.age = age;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
