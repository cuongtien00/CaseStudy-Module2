package views;

import controller.ToppingManager;
import model.Topping;
import storage.ToppingFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToppingView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToppingManager toppingManager = ToppingManager.getInstance();
        try {
            toppingManager.setToppings(ToppingFile.getInstance().fileReader());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        int choice = -1;
        while (choice != 0) {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    try {
                        toppingManager.addNewTop(newTopping());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        toppingManager.removeT(inputId());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        toppingManager.editTop(inputId(), newTopping());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    toppingManager.showList();
                    break;
                case 0:
            }

        }
    }

    private static Topping newTopping() {
        Scanner input2 = new Scanner(System.in);
        System.out.println("Nhập id: ");
        String id = input2.nextLine();
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên topping: ");
        String name = input.nextLine();
        Scanner input1 = new Scanner(System.in);
        System.out.println("Nhập giá: ");
        double price = input1.nextDouble();
        return new Topping(id, name, price);
    }

    private static void showMenu() {
        System.out.println("                                       　      " + "＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
        System.out.println("                                             " + "＝＝＝＝＝＝TOPPING-LIST-MANAGER＝＝＝＝＝＝");
        System.out.println("                                       　      " + "＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
        System.out.println("                                           　　　　      " + "1. Thêm mới topping: ");
        System.out.println("                                           　　　　      " + "2. Xóa topping: ");
        System.out.println("                                           　　　　      " + "3. Sửa topping: ");
        System.out.println("                                           　　　　      " + "4. Topping Menu: ");
        System.out.println("                                           　　　　      " + "5. Quay lai ");
    }

    private static String inputId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap id: ");
        return scanner.nextLine();

    }
}
