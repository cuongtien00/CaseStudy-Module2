package views;

import controller.CustomerManager;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        BillView billView = new BillView();
        CustomerView customerView = new CustomerView();

        Scanner scanner = new Scanner(System.in);

        int choice = -1;
        while (choice!=0){
            choice = scanner.nextInt();
            switch (choice){
                case 1:
//                    customerView.runCustomerView();
                    break;
                case 2:
//                    billView.runBillView();
                    break;
                case 0:
            }
        }
    }

}
