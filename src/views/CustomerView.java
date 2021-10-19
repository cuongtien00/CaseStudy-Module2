package views;

import controller.CustomerManager;
import model.Customer;

import java.util.Scanner;

public class CustomerView {
    public void runCustomerView() {

        Scanner scanner = new Scanner(System.in);
        CustomerManager customerManager = CustomerManager.getInstance();

        int choice = -1;
        while (choice!=0){
            showMenu();
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    customerManager.addNewC(newCustomer());
                    break;
                case 2:
                    customerManager.removeC(inputName());
                    break;
                case 3:
                    customerManager.editC(inputName(),newCustomer());
                    break;
                case 4:
                    customerManager.showList();
                    break;
                case 5:
                    break;
                case 0:
            }
        }
    }
    private static String inputName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên: ");
        return scanner.nextLine();
    }
    private static Customer newCustomer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String add = scanner.nextLine();
        return new Customer(name,add);
    }
    private static void showMenu(){
        System.out.println("====CUSTOMER-LIST-MANAGER====");
        System.out.println("1. Thêm mới customer: ");
        System.out.println("2. Xóa customer: ");
        System.out.println("3. Sửa customer: ");
        System.out.println("4. Customer Menu: ");
        System.out.println("5. Quay lại: ");
    }
}
