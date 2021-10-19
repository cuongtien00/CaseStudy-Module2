package views;

import controller.ToppingManager;
import model.Topping;

import java.io.IOException;
import java.util.Scanner;

public class ToppingView {
    public void runTopping() {
        Scanner scanner = new Scanner(System.in);
        ToppingManager toppingManager = ToppingManager.getInstance();

        int choice = -1;
        while (choice != 0) {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                        toppingManager.addNewTop(newTopping());
                    break;
                case 2:
                        toppingManager.removeT(inputId());
                    break;
                case 3:
                        toppingManager.editTop(inputId(),newTopping());
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
        return new Topping(id,name, price);
    }

    private static void showMenu() {
        System.out.println("====TOPPING-LIST-MANAGER====");
        System.out.println("1. Thêm mới topping: ");
        System.out.println("2. Xóa topping: ");
        System.out.println("3. Sửa topping: ");
        System.out.println("4. Topping Menu: ");
        System.out.println("5. Quay lai ");
    }
    private static String inputId(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap id: ");
        return scanner.nextLine();

    }
}
