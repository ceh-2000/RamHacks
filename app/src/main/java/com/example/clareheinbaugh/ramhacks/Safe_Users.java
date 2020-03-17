package com.example.clareheinbaugh.ramhacks;

public class Safe_Users {

    String name;
    String phone_number;
    String safe;

    public Safe_Users(String n, String p, String s){
        name = n;
        phone_number = p;
        safe = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getSafe() {
        return safe;
    }

    public void setSafe(String safe) {
        this.safe = safe;
    }

    public String toString() {
        return this.name+"\n"+this.phone_number+"\nSafe? "+this.safe+"\n";
    }
}
