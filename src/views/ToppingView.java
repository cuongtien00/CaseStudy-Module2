package views;

import model.Topping;

import java.util.Scanner;

public class ToppingView {
    public static void main(String[] args) {

    }

    private static Topping newTopping() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên topping: ");
        String name = input.nextLine();
        Scanner input1 = new Scanner(System.in);
        System.out.println("Nhập giá: ");
        double price = input1.nextDouble();
        Topping topping = new Topping(name,price);
        return topping;
    }

    private static void showMenu(){
        System.out.println("====TOPPING-LIST-MANAGER====");
        System.out.println("1. Topping Menu: ");
        System.out.println("2. Thêm mới topping: ");
        System.out.println("3. Xóa topping: ");
        System.out.println("4. Sửa topping: ");
        System.out.println("5. Exit ");
    }
}
