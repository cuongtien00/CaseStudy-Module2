package model;

import java.io.Serializable;
import java.util.Scanner;

public class Customer implements Serializable {
    private String name;
    private String address;

    public Customer() {
    }

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
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
    public Customer inputInfo(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên khách hàng");
        String name = input.nextLine();
        System.out.println("Nhập địa chỉ");
        String add = input.nextLine();
        return new Customer(name,add);
    }

    @Override
    public String toString() {
        return "Khách hàng: " +name
                + '\n' +
                "Địa chỉ: " + address;

    }
}
