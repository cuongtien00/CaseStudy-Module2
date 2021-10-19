package views;

import model.MilkTea;

import java.util.Scanner;

public class MilkTeaView {
    public static void main(String[] args) {

    }
    private static void showMenu(){
        System.out.println("====MilkTeaList-Manager====");
        System.out.println("1. MilkTea Menu: ");
        System.out.println("2. Thêm mới milk tea : ");
        System.out.println("3. Xóa milk tea : ");
        System.out.println("4. Sửa milk tea : ");
        System.out.println("5. Exit ");
    }
    private static void newMilkTea() {
        Scanner input = new Scanner(System.in);
        System.out.println("Moi nhap code: ");
        String code = input.nextLine();
        System.out.println("Mời nhập loại trà sữa: ");
        String name = input.nextLine();
        Scanner input2 = new Scanner(System.in);
        System.out.println("Moi nhap gia");
        double price = input2.nextDouble();
        MilkTea milkTea = new MilkTea(code, name, price);
    }
}
