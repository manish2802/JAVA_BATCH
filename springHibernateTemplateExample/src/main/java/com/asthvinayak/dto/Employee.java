package com.asthvinayak.dto;

public class Employee {
    private long id;
    private String name;
    private String contact;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String toString() {
        return "Employee: " + name + ", id " + getId();
    }   
}
