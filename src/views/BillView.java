package views;

import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//
//public class BillView {
//    private static List<Bill> billList = null;
//
//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        List<Topping> toppings = new ArrayList<>();
//        Topping t1 = new Topping("1","chan trau trang", 10);
//        Topping t2 = new Topping("2","pudding trung", 10);
//        Topping t3 = new Topping("3","chan trau soi", 10);
//        toppings.add(t1);
//        toppings.add(t2);
//        toppings.add(t3);
//        Customer cuong = new Customer("cuong", "hanoi");
//        Customer huyen = new Customer("huyen", "thai nguyen");
//        MilkTea milkTea = new MilkTea("c01", "Tra sua o long", 15);
//        MilkTea milkTea2 = new MilkTea("c02", "Tra sua hoa nhai", 18);
//        List<MilkTea> milkTeas = new ArrayList<>();
//        milkTeas.add(milkTea);
//        milkTeas.add(milkTea2);
//        Order orderOfCuong = new Order("Tra sua o long", "M", 1, "50%", "70%", "chan trau trang");
//        orderOfCuong.setMilkTeas(milkTeas);
//        orderOfCuong.setToppings(toppings);
//        Order orderOfHuyen = new Order("Tra sua hoa nhai", "L", 2, "50%", "70%", "pudding trung");
//        orderOfHuyen.setMilkTeas(milkTeas);
//        orderOfHuyen.setToppings(toppings);
//        billList = new ArrayList<>();
//        Bill billOfCuong = new Bill("C01", cuong, "18/10", orderOfCuong);
//        Bill billOfHuyen = new Bill("C02", huyen, "18/10", orderOfHuyen);
//        billList.add(billOfHuyen);
//        billList.add(billOfCuong);
//        System.out.println(billOfCuong.getTotalPrice());
//        System.out.println("Total price for bill of Huyen: " + billOfHuyen.getTotalPrice());
//
//
//    }
//
//    private static Bill getBill(Customer customer, Order order) {
//        Scanner input1 = new Scanner(System.in);
//        System.out.println("Nhập billCode: ");
//        String code = input1.nextLine();
//        Scanner input2 = new Scanner(System.in);
//        System.out.println("Nhập ngày xuất Bill: ");
//        String date = input2.nextLine();
//        Bill bill = new Bill(code, customer, date, order);
//        return bill;
//    }
//
//    private static Order newOrder() {
//        System.out.println("--Order trà sữa--");
//        Scanner input = new Scanner(System.in);
//        System.out.println("Nhập loại trà sữa:");
//        String type = input.nextLine();
//        Scanner input2 = new Scanner(System.in);
//        System.out.println("Nhập size: ");
//        String size = input2.nextLine();
//        Scanner input3 = new Scanner(System.in);
//        System.out.println("Nhập số lượng: ");
//        int quantity = input3.nextInt();
//        Scanner input4 = new Scanner(System.in);
//        System.out.println("Phần trăm đường: ");
//        String sugarP = input4.nextLine();
//        Scanner input5 = new Scanner(System.in);
//        System.out.println("Phần trăm đá: ");
//        String iceP = input5.nextLine();
//        Scanner input6 = new Scanner(System.in);
//        System.out.println("Chọn topping: ");
//        String topping = input6.nextLine();
//        Order order = new Order(type, size, quantity, sugarP, iceP, topping);
//        return order;
//    }
//
//    private static void newMilkTea() {
//        Scanner input = new Scanner(System.in);
//        System.out.println("Moi nhap code: ");
//        String code = input.nextLine();
//        System.out.println("Mời nhập loại trà sữa: ");
//        String name = input.nextLine();
//        Scanner input2 = new Scanner(System.in);
//        System.out.println("Moi nhap gia");
//        double price = input2.nextDouble();
//        MilkTea milkTea = new MilkTea(code, name, price);
//    }
//
//    private static Customer newCustomer() {
//        Scanner input = new Scanner(System.in);
//        System.out.println("Nhập tên khách hàng");
//        String name = input.nextLine();
//        System.out.println("Nhập địa chỉ");
//        String add = input.nextLine();
//        Customer customer = new Customer(name, add);
//        return customer;
//    }
//
//    public static void showMenu() {
//        System.out.println("===========BILL-LIST-MANAGER=============");
//        System.out.println("1. Xuất Bill : ");
//        System.out.println("2. Hiển thị list Bills: ");
//        System.out.println("3. Sửa Bill: ");
//        System.out.println("4. Xóa Bill: ");
//        System.out.println("5. Thêm Bill: ");
//        System.out.println("6. Exit: ");
//        System.out.println("Nhập lựa chọn: ");
//    }
//
//    private static Topping newTopping() {
//        Scanner input = new Scanner(System.in);
//        System.out.println("Nhập tên topping: ");
//        String name = input.nextLine();
//        Scanner input1 = new Scanner(System.in);
//        System.out.println("Nhập giá: ");
//        double price = input1.nextDouble();
//        Topping topping = new Topping(name, price);
//        return topping;
//    }
//}
