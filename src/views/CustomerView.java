package views;

import controller.CustomerManager;
import model.Customer;
import storage.CustomerFile;

import java.io.IOException;
import java.util.Scanner;

public class CustomerView {
    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        CustomerManager customerManager = CustomerManager.getInstance();
        try {
            customerManager.setCustomerList(CustomerFile.getInstance().fileReader());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        int choice = -1;
        while (choice!=0){
            showMenu();
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    try {
                        customerManager.addNewC(newCustomer());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        customerManager.removeC(inputName());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        customerManager.editC(inputName(),newCustomer());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    customerManager.showList();
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
        System.out.println("                                       　      " + "＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
        System.out.println("                                             " + "＝＝＝＝＝＝CUSTOMER_LIST-MANAGER＝＝＝＝＝＝");
        System.out.println("                                       　      " + "＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
        System.out.println("                                           　　　　      " +"1. Thêm mới customer: ");
        System.out.println("                                           　　　　      " +"2. Xóa customer: ");
        System.out.println("                                           　　　　      " +"3. Sửa customer: ");
        System.out.println("                                           　　　　      " +"4. Customer Menu: ");
        System.out.println("                                           　　　　      " +"5. Quay lại: ");
    }
}
