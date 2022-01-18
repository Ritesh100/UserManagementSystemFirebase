package com.example.firebase;
public class mainModel {

    String  address,contact,email,image,name;
     mainModel(){

     }
    public mainModel(String name, String address, String email, String contact, String image) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.contact = contact;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
