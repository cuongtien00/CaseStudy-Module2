package views;

import controller.MilkTeaManager;
import model.MilkTea;

import java.util.Scanner;

public class MilkTeaView {
    public static void main(String[] args) {
        MilkTeaManager milkTeaManager = MilkTeaManager.getInstance();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0){
            showMenu();
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    milkTeaManager.addNewMilkTea(newMilkTea());
                    break;
                case 2:
                    milkTeaManager.removeMilkTea(inputCode());
                    break;
                case 3:
                    milkTeaManager.editMilkTeaList(inputCode(),newMilkTea());
                    break;
                case 4:
                    milkTeaManager.showList();
                    break;
                case 5:
                    break;
                case 0:
            }
        }

    }
    private static String inputCode(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập code: ");
        return scanner.nextLine();
    }
    private static void showMenu(){
        System.out.println("====MILKTEA-LIST-MANAGER====");
        System.out.println("1. Thêm mới milk tea : ");
        System.out.println("2. Xóa milk tea : ");
        System.out.println("3. Sửa milk tea : ");
        System.out.println("4. MilkTea Menu: ");
        System.out.println("5. Exit ");
    }
    private static MilkTea newMilkTea() {
        Scanner input = new Scanner(System.in);
        System.out.println("Moi nhap code: ");
        String code = input.nextLine();
        System.out.println("Mời nhập loại trà sữa: ");
        String name = input.nextLine();
        Scanner input2 = new Scanner(System.in);
        System.out.println("Moi nhap gia");
        double price = input2.nextDouble();
        return new MilkTea(code, name, price);
    }
}
