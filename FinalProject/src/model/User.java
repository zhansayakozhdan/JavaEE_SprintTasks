package model;

public class User {
    private Long id;
    private String email;
    private String password;
    private String fullName;
    private Integer roleId;

    public User(){

    }
    public User(String fullName, String email, String password, Integer roleId){
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }
    public User(Long id, String email, String password, String fullName, Integer roleId) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.roleId = roleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
