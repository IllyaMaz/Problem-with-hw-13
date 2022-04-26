package com.company;

public class User {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    int id;
    String name;
    String username;
    String email;
    Address address = new Address();
    String phone;
    String website;
    Company company = new Company();

    @Override
    public String toString() {
        return "User{" +"\n"+
                "   id=" + id +",\n"+
                "   name=" + name + ",\n" +
                "   username=" + username + ",\n" +
                "   email=" + email + ",\n" +
                "   address" + address +
                "   phone=" + phone + ",\n" +
                "   website=" + website + ",\n" +
                "   company=" + company +"\n"+
                "   }";
    }
}
